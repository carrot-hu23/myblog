package com.hujinbo.blogs.pojo;

/**
 * 评论表实体
 * @author 胡锦波
 */
public class Comment {

  private long cId;
  private long cArticleId;
  private long cUserId;
  private String cContext;
  private java.sql.Timestamp cDiscussDate;
  private long cCommentNum;


  public long getCId() {
    return cId;
  }

  public void setCId(long cId) {
    this.cId = cId;
  }


  public long getCArticleId() {
    return cArticleId;
  }

  public void setCArticleId(long cArticleId) {
    this.cArticleId = cArticleId;
  }


  public long getCUserId() {
    return cUserId;
  }

  public void setCUserId(long cUserId) {
    this.cUserId = cUserId;
  }


  public String getCContext() {
    return cContext;
  }

  public void setCContext(String cContext) {
    this.cContext = cContext;
  }


  public java.sql.Timestamp getCDiscussDate() {
    return cDiscussDate;
  }

  public void setCDiscussDate(java.sql.Timestamp cDiscussDate) {
    this.cDiscussDate = cDiscussDate;
  }


  public long getCCommentNum() {
    return cCommentNum;
  }

  public void setCCommentNum(long cCommentNum) {
    this.cCommentNum = cCommentNum;
  }

}
