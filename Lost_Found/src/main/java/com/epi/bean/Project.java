package com.epi.bean;

public class Project {
  Integer p_id;
  String p_author;
  String p_sort;
  String p_image;
  String p_content;
  String p_date;
  public Project(){}

  public Project(Integer p_id, String p_author, String p_sort, String p_image,
      String p_content, String p_date, String p_status) {
    this.p_id = p_id;
    this.p_author = p_author;
    this.p_sort = p_sort;
    this.p_image = p_image;
    this.p_content = p_content;
    this.p_date = p_date;
    this.p_status = p_status;
  }

  public String getP_sort() {
    return p_sort;
  }

  @Override
  public String toString() {
    return "Project{" +
        "p_id=" + p_id +
        ", p_author='" + p_author + '\'' +
        ", p_sort='" + p_sort + '\'' +
        ", p_image='" + p_image + '\'' +
        ", p_content='" + p_content + '\'' +
        ", p_date='" + p_date + '\'' +
        ", p_status='" + p_status + '\'' +
        '}';
  }

  public void setP_sort(String p_sort) {
    this.p_sort = p_sort;
  }

  String p_status;

  public Integer getP_id() {
    return p_id;
  }

  public void setP_id(Integer p_id) {
    this.p_id = p_id;
  }

  public String getP_author() {
    return p_author;
  }

  public void setP_author(String p_author) {
    this.p_author = p_author;
  }

  public String getP_image() {
    return p_image;
  }

  public void setP_image(String p_image) {
    this.p_image = p_image;
  }

  public String getP_content() {
    return p_content;
  }

  public void setP_content(String p_content) {
    this.p_content = p_content;
  }

  public String getP_date() {
    return p_date;
  }

  public void setP_date(String p_date) {
    this.p_date = p_date;
  }

  public String getP_status() {
    return p_status;
  }

  public void setP_status(String p_status) {
    this.p_status = p_status;
  }
}
