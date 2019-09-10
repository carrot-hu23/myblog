package com.hujinbo.blogs.pojo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * 文章分类实体
 * @author 胡锦波
 * @date 2019/09/02
 */
@Entity
@Table(name = "category")
@Data
public class Category {
  @Id
  private long cId;
  private String cName;
  private long cCount;

  @OneToMany(mappedBy = "category")
  private List<Article> articles = new ArrayList<>();

  @Override
  public String toString() {
    return "Category{" +

            ", articles=" + articles +
            '}';
  }
}
