package com.hujinbo.blogs.pojo;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * 文章实体类
 * @author 胡锦波
 * @date 2019/09/02
 * */
@Data
@Entity
@Table(name = "article")
public class Article {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long aId;
  private long aUserId;
  private String aTitle;
  private String aContext;
  private long aPageView;
  private long aComment;
  /**
   * 注解忘了是哪个，网上也没查到，只能直接生成当前系统时间戳
   * 这样虽然也能实现，但是不够优雅
   * */
  private java.sql.Timestamp aPublishTime = new Timestamp(System.currentTimeMillis());
  private String aCoverPicture;
  private String aPreviewText;
  private String aDiff;


  @ManyToOne()
  @JoinColumn(name = "a_category_id")
  private Category category;

  @ManyToMany(targetEntity = Tag.class)
  @JoinTable(name = "tag_relationship",
          joinColumns = {@JoinColumn(name = "relationship_a_id",referencedColumnName = "aId")},
          inverseJoinColumns = {@JoinColumn(name = "relationship_t_id",referencedColumnName = "tId")}
          )
  private List<Tag> tags;

  @Override
  public String toString() {
    return "Article{" +

            ", tags=" + tags +
            '}';
  }
}
