package com.fancy.blog.models.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  16:13
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentVO {

  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
