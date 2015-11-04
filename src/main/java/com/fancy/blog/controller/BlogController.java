package com.fancy.blog.controller;

import com.fancy.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  15:13
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

  @Autowired
  private BlogService blogService;

  @RequestMapping("/{blogUuid}")
  public String getBlog(Map<String, Object> model, @PathVariable String blogUuid) {
    model.put("blog", blogService.getBlog(blogUuid));
    return "blog";
  }

  @RequestMapping(value = "/{blogUuid}/comment/{comment}", method = RequestMethod.POST)
  public String addComment(Map<String, Object> model, @PathVariable String blogUuid, @PathVariable String comment) {
    System.out.println(comment);
    return "blog";
  }
}
