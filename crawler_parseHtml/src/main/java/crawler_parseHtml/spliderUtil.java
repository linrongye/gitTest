package crawler_parseHtml;

import crawler_parseHtml.domain.Product;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import redis.clients.jedis.Jedis;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class spliderUtil {
   private static List<String> urlList=new ArrayList <String>();
    private static CloseableHttpClient httpClient=HttpClients.createDefault();
    private static final String REDIS_MAP="JD_URL";
    private static final String USER_AGENT="";
    private static Jedis jedis=new Jedis("192.168.220.26",6379);
    private static final String SEARCH_QUEUE_KEY="search_queue_key";
    private static final String BASE_URL="https://item.jd.com/";
    private static final String PRICE_URL="https://p.3.cn/prices/mgets?pduid=1612881923&skuIds=J_";
    private static final String CRAWLER_OBJECT="crawler_object";

    public static void getUrlFromRedis(){
        String rpop = jedis.rpop(SEARCH_QUEUE_KEY);
        if(rpop!=null) {
          parseHtml(rpop);
        }
    }

    private static  void parseHtml(String id){
        String url="";
          url=  BASE_URL+id+".html" ;
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse execute = httpClient.execute(httpGet);
            String string = EntityUtils.toString(execute.getEntity(), "utf8");
            //System.out.println(string);

            Document document = Jsoup.parse(string);
            //System.out.println(document.title());
            Product product=new Product();
            product.setProNo(id);
            product.setProName(document.title());
            product.setProUrl(url);
            product.setProPrice(getPrice(id));
            product.setProPics(getUrl(string));
            byte[] bytes = serilizeObject(product);
            jedis.lpush(CRAWLER_OBJECT.getBytes(),bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static String getPrice(String  proNo){
        HttpGet httpGet=new HttpGet(PRICE_URL+proNo);
        String substring="";
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            String string = EntityUtils.toString(response.getEntity(), "utf8");
            int start=string.lastIndexOf("\"p\":")+5;
//          /  int end=start;
             substring = string.substring(start);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return substring.substring(0,substring.lastIndexOf("\""));
    }
    public static String getUrl(String html){
        Document document=Jsoup.parse(html);
        Elements elements = document.select("div[id=spec-list]>ul>li>img");
        String pic="";
        for (Element element : elements) {
            pic+=element.attr("src")+" ";
            System.out.println();
        }
        return pic;
    }
    public static byte[] serilizeObject(Product product){
        byte[] bytes=null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(product);
             bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
