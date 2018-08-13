package com.concretepage.service;

import java.util.List;

import com.concretepage.entity.Article;

public interface ArticleService {
     List<Article> getAllArticles();
     Article getArticleById(int articleId);
     boolean addArticle(Article article);
     boolean updateArticle(Article article);
     boolean deleteArticle(int articleId);
}
