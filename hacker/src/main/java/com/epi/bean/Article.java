package com.epi.bean;

public class Article {
    private Integer rId;

    public Article(){}
    public Article(String rAuthor, String rSort, String rImage, String rDate, String rContent) {
        this.rAuthor = rAuthor;
        this.rSort = rSort;
        this.rImage = rImage;
        this.rDate = rDate;
        this.rContent = rContent;
    }

    private String rAuthor;

    private String rSort;

    private String rImage;

    private String rDate;

    private Integer rStatus;

    private String rContent;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrAuthor() {
        return rAuthor;
    }

    public void setrAuthor(String rAuthor) {
        this.rAuthor = rAuthor == null ? null : rAuthor.trim();
    }

    public String getrSort() {
        return rSort;
    }

    public void setrSort(String rSort) {
        this.rSort = rSort == null ? null : rSort.trim();
    }

    public String getrImage() {
        return rImage;
    }

    public void setrImage(String rImage) {
        this.rImage = rImage == null ? null : rImage.trim();
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate == null ? null : rDate.trim();
    }

    public Integer getrStatus() {
        return rStatus;
    }

    public void setrStatus(Integer rStatus) {
        this.rStatus = rStatus;
    }

    public String getrContent() {
        return rContent;
    }

    public void setrContent(String rContent) {
        this.rContent = rContent == null ? null : rContent.trim();
    }

    @Override
    public String toString() {
        return "Article{" +
                "rId=" + rId +
                ", rAuthor='" + rAuthor + '\'' +
                ", rSort='" + rSort + '\'' +
                ", rImage='" + rImage + '\'' +
                ", rDate='" + rDate + '\'' +
                ", rStatus=" + rStatus +
                ", rContent='" + rContent + '\'' +
                '}';
    }
}