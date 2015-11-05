package com.fancy.blog.controller;

import com.fancy.blog.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * blog
 * Skrynnikov.M
 * 05.11.15  15:41
 */
@Controller
public class AuthorController {

  @Autowired
  private BusinessService businessService;

  @RequestMapping(value = "/author", method = RequestMethod.GET)
  public String authors(Map<String, Object> model) {
    model.put("authors", businessService.getAllAuthors());
    return "author";
  }
}
