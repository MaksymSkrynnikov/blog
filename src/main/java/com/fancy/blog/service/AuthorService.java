package com.fancy.blog.service;

import com.fancy.blog.models.entity.Author;

import java.util.List;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  10:40
 */
public interface AuthorService {

  List<Author> getAllAuthors();

  Author getAuthorByUuid(String authorUuid);

  Author getAuthorByLogin(String login);

  void addNewAuthor(Author author);
}
