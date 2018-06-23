package crawler;

import com.google.gson.Gson;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import domain.Pager;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HuxiuSpilderUtil {
    public  static CloseableHttpClient httpClient=HttpClients.createDefault();
    public static String  huxiuUrl="https://www.huxiu.com/";
    public static String userAgent="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36";
    public static Integer SC_SUCCESS=200;
    public  static List<String> newsList=new ArrayList <String>();
    public static String articleListUrl="https://www.huxiu.com/v2_action/article_list";
    public static String hashCode="79c7c4482026ca5ac8ae74fec872b9c9";
    public static String lastDateLine="";
    public static String firstHtml="";
    // 创建线程池(线程池中有10个线程)
    public static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static int currentPage=0;
    private static C3P0PooledDataSource dataSource=new C3P0PooledDataSource();
    /**
     *
     * @param method 若是get请求则传入get字符串
     * @return
     */
    public static String  getHuxiuHtml(String method,String url){
        String html="";
        if("get".equals(method)){
            HttpGet httpGet=new HttpGet(url);
            httpGet.setHeader("User-Agent",userAgent);
            CloseableHttpResponse execute=null;
            try {
                 execute = httpClient.execute(httpGet);
                if(execute.getStatusLine().getStatusCode()==HuxiuSpilderUtil.SC_SUCCESS){
                    HttpEntity httpEntity = execute.getEntity();
                    firstHtml = EntityUtils.toString(httpEntity, "utf8");

                    return firstHtml;
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    if(execute!=null){
                        execute.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }/*else if("post".equals(method)){

            try {
                HttpPost httpPost=new HttpPost(url);
                httpPost.setHeader("User-Agent",HuxiuSpilderUtil.userAgent);
                List<BasicNameValuePair> list=new ArrayList <BasicNameValuePair>();
                httpPost.setEntity(new UrlEncodedFormEntity(list));
                httpClient.execute(httpPost);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }else{

        }*/
        return null;
    }

    public static void getOtherUrl(){
        try {
            Document document=Jsoup.parse(firstHtml);
            Elements select = document.select("[class^=get-mod-more js-get-mod-more-list transition]");
            currentPage=Integer.parseInt(select.attr("data-cur_page"));
            lastDateLine=select.attr("data-last_dateline");
            for (int i = 0; i <5; i++) {
                HttpPost httpPost=new HttpPost(articleListUrl);
                httpPost.setHeader("User-Agent",HuxiuSpilderUtil.userAgent);
                List<BasicNameValuePair> list=new ArrayList <BasicNameValuePair>();
                list.add(new BasicNameValuePair("huxiu_hash_code",hashCode));
                list.add(new BasicNameValuePair("page",(currentPage+1)+""));
                currentPage+=1;
                list.add(new BasicNameValuePair("last_dateline",lastDateLine));
                httpPost.setEntity(new UrlEncodedFormEntity(list));
                CloseableHttpResponse response = httpClient.execute(httpPost);
                if(response.getStatusLine().getStatusCode()==SC_SUCCESS){
                    HttpEntity entity = response.getEntity();
                    String html1 = EntityUtils.toString(entity, "utf8");
                    Gson gson=new Gson();
                    Pager pager = gson.fromJson(html1, Pager.class);
                    lastDateLine=pager.getLast_dateline();
                    parseHtml(pager.getData().toString());
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  static void parseHtml(String html){
        Document document=Jsoup.parse(html);
        Elements els = document.select("div[class^=mod-b mod-art]");
        for(Element e:els){
// 把新解析出的新闻Id，添加到newsList中
            if(!e.attr("data-aid").equals("")) {
                newsList.add("https://www.huxiu.com/article/" + e.attr("data-aid") + ".html");
            }
        }
    }

    public static void parseArticleAndSave(){


            for (final  String s : newsList) {
                executorService.submit(new Runnable() {
                    public void run() {

                        try {
                            HttpPost httpPost=new HttpPost(s);
                            List<BasicNameValuePair> list =new ArrayList <BasicNameValuePair>();
                            list.add(new BasicNameValuePair("stm",System.currentTimeMillis()+""));
                            httpPost.setEntity(new UrlEncodedFormEntity(list));
                            CloseableHttpResponse execute = httpClient.execute(httpPost);
                            if(execute.getStatusLine().getStatusCode()==SC_SUCCESS){
                                HttpEntity httpEntity = execute.getEntity();
                                parseArticle(EntityUtils.toString(httpEntity,"utf-8"));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        executorService.shutdown();
    }

    public static void parseArticle(String html){
        Document document=Jsoup.parse(html);
       // Elements els = document.select("div.article-wrap");
       // System.out.println(document.title());
        Elements select = document.select("span[class=username fl]");
        for (Element element : select) {
            System.out.println("线程【"+Thread.currentThread().getId()+"】  "+element.text());
        }
    }

    public static void saveDb(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
    }
}
