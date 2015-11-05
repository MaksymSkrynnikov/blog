package com.fancy.blog.models.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  9:31
 */
@Entity
@Table(name = "blog")
public class Blog implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;

  @Column(name = "creation_moment")
  private Date          creationMoment;

  @Column(name = "title")
  private String        title;

  @Column(name = "text")
  private String        text;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Author.class)
  private Author        author;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @Fetch(FetchMode.SUBSELECT)
  private List<Comment> comments;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getCreationMoment() {
    return creationMoment;
  }

  public void setCreationMoment(Date creationMoment) {
    this.creationMoment = creationMoment;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public void addComment(Comment comment) {
    if (Objects.isNull(comments)) {
      comments = new LinkedList<>();
    }
    comments.add(comment);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Blog)) return false;

    Blog blog = (Blog) o;

    if (id != null ? !id.equals(blog.id) : blog.id != null) return false;
    if (creationMoment != null ? !creationMoment.equals(blog.creationMoment) : blog.creationMoment != null)
      return false;
    if (title != null ? !title.equals(blog.title) : blog.title != null) return false;
    if (text != null ? !text.equals(blog.text) : blog.text != null) return false;
    if (author != null ? !author.equals(blog.author) : blog.author != null) return false;
    return !(comments != null ? !comments.equals(blog.comments) : blog.comments != null);

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (creationMoment != null ? creationMoment.hashCode() : 0);
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (text != null ? text.hashCode() : 0);
    result = 31 * result + (author != null ? author.hashCode() : 0);
    result = 31 * result + (comments != null ? comments.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Blog{" +
           "comments=" + comments +
           ", author=" + author +
           ", text='" + text + '\'' +
           ", title='" + title + '\'' +
           ", creationMoment=" + creationMoment +
           ", id='" + id + '\'' +
           '}';
  }
}
