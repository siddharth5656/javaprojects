package com.concretepage.dao;
import java.util.List;
import com.concretepage.entity.Article;
import com.concretepage.entity.User;
public interface ArticleDAO {
    List<Article> getAllArticles();
    Article getArticleById(int articleId);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
    boolean articleExists(String title, String category);
	boolean registration(User user);
}
 