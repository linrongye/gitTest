package cn.linry.domain;

public class User {
    /**
     * `id` int(11) NOT NULL AUTO_INCREMENT,
     *   `username` varchar(32) NOT NULL COMMENT '用户名称',
     *   `birthday` date DEFAULT NULL COMMENT '生日',
     *   `sex` char(10) DEFAULT NULL COMMENT '性别',
     *   `address` varchar(256) DEFAULT NULL COMMENT '地址',
     *   `test` bigint(12) DEFAULT NULL,
     */
    private String id;
    private String birthday;
    private String username;
    private String sex;
    private String address;
    private String test;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", birt='" + birthday + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", addres='" + address + '\'' +
                ", test='" + test + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
