package crawler;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import domain.TargetArr;
import domain.select;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crawler {
    public static void main(String[] args) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost=new HttpPost("http://tlias-stu.boxuegu.com/user/login");
        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        parameters.add(new BasicNameValuePair("loginName","A180201061"));//A180304498  A180201061
        //{"success":true,"resultObject":{"studentId":42105,"classId":1371,"emsCode":"929029","portalId":"44233","sex":"1","studentName":"吕卓","studentNo":"A180304498","state":1}}
        parameters.add(new BasicNameValuePair("password","123456asd"));//1913539520  123456asd
        httpPost.setEntity(new UrlEncodedFormEntity(parameters));
// 3.执行请求
        CloseableHttpResponse loginRes = httpClient.execute(httpPost);
// 3.1.获取响应状态码
        int code = loginRes.getStatusLine().getStatusCode();
        System.out.println(code);
        String html="";
        if(code==200){
// 6.获取响应数据
            HttpEntity entity = loginRes.getEntity();
// 7.转换成字符串html数据
            html = EntityUtils.toString(entity,"utf-8");
            System.out.println(html);

        /*    HttpGet get=new HttpGet("http://tlias-stu.boxuegu.com/feedback/queryFeedbackForList?status=0&pageNumber=1&pageSize=10&r_=256345669560349.56");
            get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
            // 3.执行请求
            CloseableHttpResponse response = httpClient.execute(get);
// 4.获取网页内容
            HttpEntity entity1= response.getEntity();
// 5.打印网页内容
            String html1 = EntityUtils.toString(entity1,"utf-8");
            System.out.println(html1);
*/

        HttpGet get=new HttpGet("http://tlias-stu.boxuegu.com/feedback/queryTodayFeedback?r_=1008706715119339.2");
            CloseableHttpResponse response = httpClient.execute(get);
            String string = EntityUtils.toString(response.getEntity(), "utf8");
            Map<String,Object> map = new Gson().fromJson(string, new TypeToken<HashMap<String,Object>>(){}.getType());
            String index=(((LinkedTreeMap)((List)((LinkedTreeMap)map.get("resultObject")).get("list")).get(0)).get("questionCount")).toString();
            System.out.println(index);
            int d=(int)Double.parseDouble(index);

            HttpGet httpPost2=new HttpGet("http://tlias-stu.boxuegu.com/feedback/checkIsCanFeedback?feedbackId=41923");
            CloseableHttpResponse response1=httpClient.execute(httpPost2);
            HttpEntity entity2=response1.getEntity();

            String html2=EntityUtils.toString(entity2,"utf-8");
            System.out.println(html2);

            HttpPost httpPost3=new HttpPost("http://tlias-stu.boxuegu.com/feedback/queryTodayFeedback");
            httpPost3.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
            CloseableHttpResponse response2 = httpClient.execute(httpPost3);
            String feedId="";
            if(response2.getStatusLine().getStatusCode()==200){
                HttpEntity response2Entity = response2.getEntity();
                String string1 = EntityUtils.toString(response2Entity, "utf8");
                feedId = string1.substring(string1.lastIndexOf("feedbackId\":") + 12, string1.lastIndexOf("feedbackId\":") + 17);
                System.out.println(feedId);
            }
            /**
             * {"success":true,"resultObject":{"studentId":42079,"classId":1371,"emsCode":"920468","portalId":"44207","sex":"1","studentName":"林荣业","studentNo":"A180201061","state":1}}
             */
            HttpPost httpPost1=new HttpPost("http://tlias-stu.boxuegu.com/feedback/save");

           // httpPost1.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
            Gson gson=new Gson();
            select select=new select();
            List<TargetArr> targetArr=new ArrayList <TargetArr>();
            TargetArr targetArr1;
            select.setFeedbackId(feedId);
            for (int i = 0; i < d; i++) {
                targetArr1=new TargetArr();
                targetArr1.setQuestionNo(i+1+"");
                targetArr1.setQuestionVal((int)(Math.random()*2)+"");
                targetArr.add(targetArr1);
            }
            select.setTargetArr(targetArr);
            select.setAnonymity(0);
            String s = gson.toJson(select);
            StringEntity entity1 = new StringEntity(s.toString(),"utf-8");
            entity1.setContentEncoding("UTF-8");
            entity1.setContentType("application/json");
           // httpPost1.setHeader("Referer","http://tlias-stu.boxuegu.com/");
           // httpPost1.addHeader("Cookie","SESSION=c3f11b13-07a8-44c4-a420-815c8fab8ac3");
            //List<BasicNameValuePair> parameters1 = new ArrayList<BasicNameValuePair>();
            System.out.println(s);
            httpPost1.setEntity(entity1);
            CloseableHttpResponse loginRes2 = httpClient.execute(httpPost1);
            int code1 = loginRes2.getStatusLine().getStatusCode();
            System.out.println(code1);
            if(code1==200) {
                HttpEntity entity3 = loginRes2.getEntity();
                html = EntityUtils.toString(entity3, "utf-8");
                System.out.println(html);
            }

        }
    }
}
