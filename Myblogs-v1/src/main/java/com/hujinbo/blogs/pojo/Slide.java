package com.hujinbo.blogs.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/***
 * 轮播图实体
 * @author 胡锦波
 * */
@Entity
@Table(name = "slide")
public class Slide {
  /**
   * 轮播图id
   * */
  @Id
  private long sId;
  /**
   * 轮播图url
   * */
  private String sUrl;
  /**
   * 轮播图文章id    前端还未实现跳转
   * */
  private long sArticleId;
  /**
   * 轮播图上传时间
   * */
  private java.sql.Timestamp sPublishDate;


  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }


  public String getSUrl() {
    return sUrl;
  }

  public void setSUrl(String sUrl) {
    this.sUrl = sUrl;
  }


  public long getSArticleId() {
    return sArticleId;
  }

  public void setSArticleId(long sArticleId) {
    this.sArticleId = sArticleId;
  }


  public java.sql.Timestamp getSPublishDate() {
    return sPublishDate;
  }

  public void setSPublishDate(java.sql.Timestamp sPublishDate) {
    this.sPublishDate = sPublishDate;
  }

}
