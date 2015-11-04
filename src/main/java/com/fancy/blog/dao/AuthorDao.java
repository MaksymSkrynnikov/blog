package com.fancy.blog.dao;

import com.fancy.blog.models.entity.Author;

/**
 * blog
 * Skrynnikov.M
 * 04.11.15  10:28
 */
public interface AuthorDao {

  void addNewAuthor(Author author);

  Author getAuthor(String authorUuid);

  Author getAuthorByLogin(String authorLogin);

  void updateAuthor(Author author);
}
