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
    comment.setText("Really helpful technology, I'm going to use it on my next project");
    comment.setOwnerName("Stranger");
    Blog blog = new Blog();
    blog.setCreationMoment(new Date());
    blog.setText("HATEOAS, an abbreviation for Hypermedia as the Engine of Application State, is a constraint of the REST application architecture that distinguishes it from most other network application architectures. The principle is that a client interacts with a network application entirely through hypermedia provided dynamically by application servers. A REST client needs no prior knowledge about how to interact with any particular application or server beyond a generic understanding of hypermedia. By contrast, in some service-oriented architectures (SOA), clients and servers interact through a fixed interface shared through documentation or an interface description language (IDL). " +
                        "The HATEOAS constraint decouples client and server in a way that allows the server functionality to evolve independently.");
    blog.setTitle("HATEOAS");
    blog.setComments(new LinkedList<>(Collections.singleton(comment)));
    Author author = new Author();
    author.setName("John Doe");
    author.setRegistrationDate(new Date());
    author.setLogin("john@doe.com");
    authorDao.addNewAuthor(author);
    blog.setAuthor(author);
    blogService.addNewBlog(blog);
  }
}
