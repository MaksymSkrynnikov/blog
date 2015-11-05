package com.fancy.blog.controller;

import com.fancy.blog.dao.AuthorDao;
import com.fancy.blog.models.entity.Author;
import com.fancy.blog.models.entity.Blog;
import com.fancy.blog.models.entity.Comment;
import com.fancy.blog.service.BlogService;
import com.fancy.blog.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  9:20
 */
@Controller
public class WelcomeController {

  @Autowired
  private BlogService blogService;

  @Autowired
  private BusinessService businessService;

  @Autowired
  private AuthorDao authorDao;


  @PostConstruct
  public void init() throws InterruptedException {
    for (int i = 0; i < 5; i++) {
      add();
      TimeUnit.SECONDS.sleep(1);
    }
  }

  @RequestMapping("/welcome")
  public String blogs(Map<String, Object> model) {
    model.put("blogs", businessService.getAllBlogs());
    return "welcome";
  }

  private void add() {

    Comment comment = new Comment();
    comment.setCreationMoment(new Date());
    comment.setText("Bad comment");
    comment.setOwnerName("Stranger");
    Blog blog = new Blog();
    blog.setCreationMoment(new Date());
    blog.setText("text");
    blog.setTitle("title");
    blog.setComments(new LinkedList<>(Collections.singleton(comment)));
    Author author = new Author();
    author.setName("Some name");
    author.setRegistrationDate(new Date());
    authorDao.addNewAuthor(author);
    author.setLogin("login");
    blog.setAuthor(author);
    blogService.addNewBlog(blog);
  }
}
