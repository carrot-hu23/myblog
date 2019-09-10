package com.hujinbo.blogs.pojo;


/**
 * 用户实体
 *
 * @author 胡锦波
 */
public class User {

  private long uId;
  private String uName;
  private String uPassword;
  private String uEmail;
  private String uPhoto;


  public long getUId() {
    return uId;
  }

  public void setUId(long uId) {
    this.uId = uId;
  }


  public String getUName() {
    return uName;
  }

  public void setUName(String uName) {
    this.uName = uName;
  }


  public String getUPassword() {
    return uPassword;
  }

  public void setUPassword(String uPassword) {
    this.uPassword = uPassword;
  }


  public String getUEmail() {
    return uEmail;
  }

  public void setUEmail(String uEmail) {
    this.uEmail = uEmail;
  }


  public String getUPhoto() {
    return uPhoto;
  }

  public void setUPhoto(String uPhoto) {
    this.uPhoto = uPhoto;
  }

}
