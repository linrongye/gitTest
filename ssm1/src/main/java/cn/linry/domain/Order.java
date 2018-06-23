package cn.linry.domain;

public class Order {
    private String number;
    private String id;
    private String user_id;
    private String createtime;
    private String note;
    private int money;


    @Override
    public String toString() {
        return "Order{" +
                "number='" + number + '\'' +
                ", id='" + id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", createtime='" + createtime + '\'' +
                ", note='" + note + '\'' +
                ", money=" + money +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
