package com.fancy.blog.controller;

import com.fancy.blog.models.vo.CommentVO;
import com.fancy.blog.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
  private BusinessService businessService;

  @RequestMapping("/{blogUuid}")
  public String getBlog(Map<String, Object> model, @PathVariable String blogUuid) {
    model.put("blog", businessService.getBlog(blogUuid));
    return "blog";
  }

  @RequestMapping(value = "/{blogUuid}/comment/", method = RequestMethod.POST)
  public String addComment(@PathVariable String blogUuid, @ModelAttribute("comment") CommentVO comment) {
    businessService.addComment(blogUuid, comment);
    return "redirect:/blog/" + blogUuid;
  }
}
