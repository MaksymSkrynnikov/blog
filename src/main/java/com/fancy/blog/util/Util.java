package com.fancy.blog.util;

import com.fancy.blog.models.entity.Author;
import com.fancy.blog.models.entity.Blog;
import com.fancy.blog.models.entity.Comment;
import com.fancy.blog.models.vo.AuthorVO;
import com.fancy.blog.models.vo.BlogVO;
import com.fancy.blog.models.vo.CommentVO;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * blog
 * Skrynnikov.M
 * 05.11.15  14:55
 */
public interface Util {

  static Comment getComment(CommentVO commentVO) {
    Comment comment = new Comment();
    comment.setCreationMoment(new Date());
    comment.setText(commentVO.getText());
    comment.setOwnerName(commentVO.getOwnerName());
    return comment;
  }

  static CommentVO getCommentVO(Comment comment) {
    CommentVO commentVO = new CommentVO();
    commentVO.setOwnerName(comment.getOwnerName());
    commentVO.setText(comment.getText());
    commentVO.setCreationMoment(comment.getCreationMoment());
    return commentVO;
  }

  static List<CommentVO> getCommentVOList(List<Comment> comments) {
    return comments.stream().map(Util::getCommentVO).collect(Collectors.toList());
  }

  static AuthorVO getAuthorVO(Author author) {
    AuthorVO authorVO = new AuthorVO();
    authorVO.setId(author.getId());
    authorVO.setLogin(author.getLogin());
    authorVO.setName(author.getName());
    authorVO.setRegistrationDate(author.getRegistrationDate());
    authorVO.setBlogs(getBlogVOList(author.getBlogs()));
    return authorVO;
  }

  static List<AuthorVO> getAuthorVOList(List<Author> authors) {
    return authors.stream().map(Util::getAuthorVO).collect(Collectors.toList());
  }

  static BlogVO getBlogVO(Blog blog) {
    BlogVO blogVO = new BlogVO();
    blogVO.setId(blog.getId());
    blogVO.setCreationMoment(blog.getCreationMoment());
    blogVO.setTitle(blog.getTitle());
    blogVO.setText(blog.getText());
    blogVO.setAuthorName(blog.getAuthor().getName());
    blogVO.setAuthorRegistrationMoment(blog.getAuthor().getRegistrationDate());
    blogVO.setComments(Util.getCommentVOList(blog.getComments()));
    return blogVO;
  }

  static List<BlogVO> getBlogVOList(List<Blog> blogs) {
    return blogs.stream().map(Util::getBlogVO).collect(Collectors.toList());
  }
}
