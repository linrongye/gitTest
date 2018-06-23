package SpringTest1.domain;

import java.util.Date;

public class User {
    /**
     *  `id` int(11) NOT NULL AUTO_INCREMENT,
     *   `username` varchar(32) NOT NULL COMMENT '用户名称',
     *   `birthday` date DEFAULT NULL COMMENT '生日',
     *   `sex` char(10) DEFAULT NULL COMMENT '性别',
     *   `address` varchar(256) DEFAULT NULL COMMENT '地址',
     *   `test` bigint(12) DEFAULT NULL,
     */
    private int id;
    private String username;
    private Date birthday;
    private  String sex;
    private String address;
    private String test;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", test='" + test + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
