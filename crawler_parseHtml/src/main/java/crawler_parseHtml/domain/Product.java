package crawler_parseHtml.domain;


import java.io.Serializable;

public class Product {

  private String proId;
  private String proNo;
  private String proName;
  private String proPrice;
  private String proPics;
  private String proUrl;


  public String getProId() {
    return proId;
  }

  public void setProId(String proId) {
    this.proId = proId;
  }


  public String getProNo() {
    return proNo;
  }

  public void setProNo(String proNo) {
    this.proNo = proNo;
  }


  public String getProName() {
    return proName;
  }

  public void setProName(String proName) {
    this.proName = proName;
  }


  public String getProPrice() {
    return proPrice;
  }

  public void setProPrice(String proPrice) {
    this.proPrice = proPrice;
  }


  public String getProPics() {
    return proPics;
  }

  public void setProPics(String proPics) {
    this.proPics = proPics;
  }


  public String getProUrl() {
    return proUrl;
  }

  public void setProUrl(String proUrl) {
    this.proUrl = proUrl;
  }

}
