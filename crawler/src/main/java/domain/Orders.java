package com.sample;


public class Orders {

  private long id;
  private long userId;
  private String number;
  private java.sql.Timestamp createtime;
  private long money;
  private String note;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public long getMoney() {
    return money;
  }

  public void setMoney(long money) {
    this.money = money;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

}
