package com.fancy.blog.models.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  16:13
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentVO implements Serializable {

  private String ownerName;

  private String text;

  private Date creationMoment;

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

  @Override
  public String toString() {
    return "CommentVO{" +
           "ownerName='" + ownerName + '\'' +
           ", text='" + text + '\'' +
           ", creationMoment=" + creationMoment +
           '}';
  }
}
