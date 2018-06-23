package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    public  static Object getBean(String fileName){
        Properties properties=new Properties();
        Object o=null;
        InputStream inputStream=BeanFactory.class.getResourceAsStream("my.properties");
        try {
            properties.load(inputStream);
              o = Class.forName(properties.getProperty(fileName)).newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
