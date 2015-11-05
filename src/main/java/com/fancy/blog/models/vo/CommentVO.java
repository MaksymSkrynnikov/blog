package com.fancy.blog.models.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  16:13
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentVO implements Serializable {

  private String text;

  public CommentVO(){
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CommentVO)) return false;

    CommentVO commentVO = (CommentVO) o;

    return !(text != null ? !text.equals(commentVO.text) : commentVO.text != null);

  }

  @Override
  public int hashCode() {
    return text != null ? text.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "CommentVO{" +
           "text='" + text + '\'' +
           '}';
  }
}
