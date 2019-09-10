package com.hujinbo.blogs.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 标签实体类
 * @author 胡锦波
 * @date 2019/09/02
 */
@Data
@Entity
@Table(name = "tag")
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long tId;
  private String tName;
  private long tCount;

  @ManyToMany(mappedBy = "tags")
  private List<Article> articles = new ArrayList<>();

  @Override
  public String toString() {
    return "Tag{" +
            "tId=" + tId +
            ", tName='" + tName + '\'' +
            '}';
  }
}
