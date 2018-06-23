package cn.linry.converter;
import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * * 接口规范说明：
 * Converter<S, T>
 * S,Source，源，转换之前的数据，这里是字符串String类型的商品生产日期
 * T,Target，目标，转换之后的数据，这里是Date类型的商品生产日期
 */
public class DateConverter implements Converter<String,Date> {
  /* *//**//* *//**//**//**//**
     * 实现转换逻辑的方法
     * */
    public Date convert(String source) {
// 1.日期格式化对象(2016-02-03 13:22:53)
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
// 转换成功，直接返回
            return format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
// 转换失败，返回null
        return null;
    }
}