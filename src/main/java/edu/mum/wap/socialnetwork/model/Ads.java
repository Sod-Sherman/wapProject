package edu.mum.wap.socialnetwork.model;

import java.time.LocalDate;

public class Ads implements Comparable<Ads>{
    private Integer id;
    private boolean active = true;
    private String content;
    private String article;
    private String url;
    private Long counter;
    private String imgUrl;
    private LocalDate postedDate;
    private Integer duration;
    private String location;
    private Integer ageRangeMin;
    private Integer ageRangeMax;

    public Ads(Integer id, String article, String content, String url, String imgUrl){
        this.id = id;
        this.article = article;
        this.content = content;
        this.url = url;
        this.imgUrl = imgUrl;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public void setCompany(String company) {
        company = company;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAgeRangeMin(Integer ageRangeMin) {
        this.ageRangeMin = ageRangeMin;
    }

    public void setAgeRangeMax(Integer ageRangeMax) {
        this.ageRangeMax = ageRangeMax;
    }

    public Integer getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public Long getCounter() {
        return counter;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getLocation() {
        return location;
    }

    public Integer getAgeRangeMin() {
        return ageRangeMin;
    }

    public Integer getAgeRangeMax() {
        return ageRangeMax;
    }

    @Override
    public String toString(){
        return "Ads{" +
                "id=" + id + '\'' +
                ", article='" + article + '\'' +
                ", content='" + content + '\'' +
                ", location='" + location + '\'' +
                ", url='" + url + '\'' +
                ", active='" + active + '\'' +
                ", counter=" + counter +
                "}";
    }
    @Override
    public int compareTo(Ads ad){
        return getPostedDate().compareTo(ad.getPostedDate());
    }

    public void setContent(String content) {
        this.content = content;
    }
}
