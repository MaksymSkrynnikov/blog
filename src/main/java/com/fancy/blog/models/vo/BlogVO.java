package com.fancy.blog.models.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * blog
 * Skrynnikov.M
 * 05.11.15  15:56
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogVO {

  private String id;
  private Date   creationMoment;
  private String title;
  private String text;
  private String authorName;
  private Date authorRegistrationMoment;
  private List<CommentVO> comments;

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

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public Date getAuthorRegistrationMoment() {
    return authorRegistrationMoment;
  }

  public void setAuthorRegistrationMoment(Date authorRegistrationMoment) {
    this.authorRegistrationMoment = authorRegistrationMoment;
  }

  public List<CommentVO> getComments() {
    return comments;
  }

  public void setComments(List<CommentVO> comments) {
    this.comments = comments;
  }

  @Override
  public String toString() {
    return "BlogVO{" +
           "id='" + id + '\'' +
           ", creationMoment=" + creationMoment +
           ", title='" + title + '\'' +
           ", text='" + text + '\'' +
           ", authorName='" + authorName + '\'' +
           ", authorRegistrationMoment=" + authorRegistrationMoment +
           ", comments=" + comments +
           '}';
  }
}
