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
public class Comment implements Serializable {

  @Id @Column(name = "id")
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;
  @Column(name = "owner_name")
  private String ownerName;
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

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
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

  public Blog getBlog() {
    return blog;
  }

  public void setBlog(Blog blog) {
    this.blog = blog;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Comment)) return false;

    Comment comment = (Comment) o;

    if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
    if (ownerName != null ? !ownerName.equals(comment.ownerName) : comment.ownerName != null) return false;
    if (text != null ? !text.equals(comment.text) : comment.text != null) return false;
    if (creationMoment != null ? !creationMoment.equals(comment.creationMoment) : comment.creationMoment != null)
      return false;
    return !(blog != null ? !blog.equals(comment.blog) : comment.blog != null);

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (ownerName != null ? ownerName.hashCode() : 0);
    result = 31 * result + (text != null ? text.hashCode() : 0);
    result = 31 * result + (creationMoment != null ? creationMoment.hashCode() : 0);
    result = 31 * result + (blog != null ? blog.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Comment{" +
           "id='" + id + '\'' +
           ", ownerName='" + ownerName + '\'' +
           ", text='" + text + '\'' +
           ", creationMoment=" + creationMoment +
           ", blog=" + blog +
           '}';
  }
}
