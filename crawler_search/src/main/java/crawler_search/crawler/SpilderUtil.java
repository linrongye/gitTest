package crawler_search.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.BackoffManager;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.CORBA.PUBLIC_MEMBER;
import redis.clients.jedis.Jedis;

import java.io.IOException;

public class SpilderUtil {
    private static final String BASE_URL="https://search.jd.com/Search?";
    private static final String BASE_COMMON_URL="keyword=?&enc=utf-8&pvid=5fb8803c43044e1d902a7f23395bf31b";
    private static   CloseableHttpClient httpClient=HttpClients.createDefault();
    private static final String REDIS_MAP="JD_URL";
    private static final String SEARCH_QUEUE_KEY="search_queue_key";
    private static Jedis jedis=new Jedis("192.168.220.26",6379);
    //private  final static String OTHER_URL="https://search.jd.com/s_new.php?keyword=手机&pvid=5fb8803c43044e1d902a7f23395bf31b&enc=utf-8&page=";

    public static void getUrl(String keywords){
        String url=BASE_URL+ BASE_COMMON_URL.replace("?", keywords);
        HttpGet httpGet=new HttpGet(url);
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode()==200){
                HttpEntity httpEntity = response.getEntity();
                String html=EntityUtils.toString(httpEntity,"utf8");
               // System.out.println(html);
                parseHtmlToUrl(html);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void parseHtmlToUrl(String html){
        Document document=Jsoup.parse(html);

         Elements elements = document.select("ul[class=gl-warp clearfix]>li>div>div[class=p-img]>a");
        for (Element element : elements) {
            String url=element.attr("href");
            saveRedis(url);
            System.out.println(url);
        }
        Elements ul = document.select("div[id=J_goodsList]>ul");
        Elements lis = ul.select("li[data-pid]");
        for(Element li:lis){
            jedis.lpush(SEARCH_QUEUE_KEY,li.attr("data-pid"));
        }
    }
    public static void getOtherUrl(String key){
        for (int i = 1; i < 100; i++) {

            HttpGet get=new HttpGet(BASE_URL+BASE_COMMON_URL.replace("?",key) +"&page="+(2*i-1));
            get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
            try {
                String string = EntityUtils.toString(httpClient.execute(get).getEntity(), "utf8");
                parseHtmlToUrl(string);
               // System.out.println(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveRedis(String url){
        jedis.lpush(REDIS_MAP,url);
    }
}
