package com.epi.bean;

public class Goods {
  private Integer id;
  private String goods;
  private String describe;
  private String image;
  public Goods(){ }
  // 有参构造
  public Goods(Integer id, String goods, String describe, String image) {
    this.id = id;
    this.goods = goods;
    this.describe = describe;
    this.image = image;
  }

  public int getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getGoods() {
    return goods;
  }

  public void setGoods(String goods) {
    this.goods = goods;
  }

  public String getDescribe() {
    return describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  @Override
  public String toString() {
    return "good{" +
        "id=" + id +
        ", goods='" + goods + '\'' +
        ", describe='" + describe + '\'' +
        ", image='" + image + '\'' +
        '}';
  }
}

