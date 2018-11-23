package com.epi.bean;

import java.util.Date;

public class Image1 {
  private Date imageTime;
  private String image;

  public Date getImageTime() {
    return imageTime;
  }

  @Override
  public String toString() {
    return "Image1{" +
        "imageTime=" + imageTime +
        ", image='" + image + '\'' +
        '}';
  }

  public void setImageTime(Date imageTime) {
    this.imageTime = imageTime;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Image1(Date imageTime, String image) {
    this.imageTime = imageTime;
    this.image = image;
  }
}
