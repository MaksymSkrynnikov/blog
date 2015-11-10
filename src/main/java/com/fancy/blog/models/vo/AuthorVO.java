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
public class AuthorVO {

  private String id;
  private String name;
  private String login;
  private Date   registrationDate;
  private List<BlogVO> blogs;
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public Date getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
  }

  public List<BlogVO> getBlogs() {
    return blogs;
  }

  public void setBlogs(List<BlogVO> blogs) {
    this.blogs = blogs;
  }

  @Override
  public String toString() {
    return "AuthorVO{" +
           "id='" + id + '\'' +
           ", name='" + name + '\'' +
           ", login='" + login + '\'' +
           ", registrationDate=" + registrationDate +
           ", blogs=" + blogs +
           '}';
  }
}
