package com.fancy.blog.controller;

import com.fancy.blog.models.vo.CommentVO;
import com.fancy.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

  @RequestMapping(value = "/{blogUuid}/comment/", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public String addComment(@PathVariable String blogUuid, @RequestBody CommentVO comment) {
    System.out.println(blogUuid + " " + comment);
    return "blog";
  }
}
