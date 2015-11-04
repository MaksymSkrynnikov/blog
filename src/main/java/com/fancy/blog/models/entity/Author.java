package com.fancy.blog.models.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  9:31
 */
@Entity
@Table(name = "author")
public class Author implements Serializable {

  @Id @Column(name = "id")
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;
  @Column(name = "name")
  private String name;
  @Column(name = "login")
  private String login;
  @Column(name = "password")
  private String password;
  @Column(name = "registration_date")
  private Date   registrationDate;
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "author", targetEntity = Blog.class)
  private List<Blog> blogs;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(Date registrationDate) {
    this.registrationDate = registrationDate;
  }

  public List<Blog> getBlogs() {
    return blogs;
  }

  public void setBlogs(List<Blog> blogs) {
    this.blogs = blogs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Author)) return false;

    Author author = (Author) o;

    if (id != null ? !id.equals(author.id) : author.id != null) return false;
    if (name != null ? !name.equals(author.name) : author.name != null) return false;
    if (login != null ? !login.equals(author.login) : author.login != null) return false;
    if (password != null ? !password.equals(author.password) : author.password != null) return false;
    if (registrationDate != null ? !registrationDate.equals(author.registrationDate) : author.registrationDate != null)
      return false;
    return !(blogs != null ? !blogs.equals(author.blogs) : author.blogs != null);

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (login != null ? login.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
    result = 31 * result + (blogs != null ? blogs.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Author{" +
           "id='" + id + '\'' +
           ", name='" + name + '\'' +
           ", login='" + login + '\'' +
           ", password='" + password + '\'' +
           ", registrationDate=" + registrationDate +
           '}';
  }
}
