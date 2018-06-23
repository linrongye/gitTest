package crawler;

public class SpilderMain {
    public static void main(String[] args) {
        Long start=System.currentTimeMillis();
        String html = HuxiuSpilderUtil.getHuxiuHtml("get", HuxiuSpilderUtil.huxiuUrl);
      //  System.out.println(html);
        HuxiuSpilderUtil.parseHtml(html);

        HuxiuSpilderUtil.getOtherUrl();
        HuxiuSpilderUtil.parseArticleAndSave();
        for (String s : HuxiuSpilderUtil.newsList) {
            System.out.println(s);
        }
        Long end=System.currentTimeMillis();
        System.out.println((end-start)/1000.0);
    }
}
