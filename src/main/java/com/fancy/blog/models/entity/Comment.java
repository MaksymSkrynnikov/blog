package com.fancy.blog.models.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  9:31
 */
@Entity
@Table(name = "comment")
public class Comment implements Comparable<Comment>, Serializable {

  @Id @Column(name = "id")
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;
  @Column(name = "text")
  private String text;
  @Column(name = "creation_date")
  private Date   creationMoment;
  @OneToOne(targetEntity = Blog.class)
  private Blog blog;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getCreationMoment() {
    return creationMoment;
  }

  public void setCreationMoment(Date creationMoment) {
    this.creationMoment = creationMoment;
  }

  @Override
  public int compareTo(Comment that) {
    return creationMoment.compareTo(that.getCreationMoment());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Comment)) return false;

    Comment comment = (Comment) o;

    if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
    if (text != null ? !text.equals(comment.text) : comment.text != null) return false;
    return !(creationMoment != null ? !creationMoment.equals(comment.creationMoment) : comment.creationMoment != null);

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (text != null ? text.hashCode() : 0);
    result = 31 * result + (creationMoment != null ? creationMoment.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Comment{" +
           "id='" + id + '\'' +
           ", text='" + text + '\'' +
           ", creationMoment=" + creationMoment +
           '}';
  }
}
