package cn.linry.domain;

import java.util.Date;

/**
 *  `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `name` varchar(32) NOT NULL COMMENT '商品名称',
 *   `price` float(10,1) NOT NULL COMMENT '商品定价',
 *   `detail` varchar(5000) DEFAULT NULL COMMENT '商品描述',
 *   `pic` varchar(64) DEFAULT NULL COMMENT '商品图片',
 *   `createtime` datetime DEFAULT NULL COMMENT '生产日期',
 */
public class item {
    private String id;
    private String name;
    private String price;
    private String detail;
    private String pic;
    private Date createtime;


    @Override
    public String toString() {
        return "item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", prive='" + price + '\'' +
                ", detail='" + detail + '\'' +
                ", pic='" + pic + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
