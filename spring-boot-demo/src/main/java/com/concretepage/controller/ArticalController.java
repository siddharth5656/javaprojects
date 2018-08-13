package com.concretepage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.concretepage.entity.Article;
import com.concretepage.entity.Expense;
import com.concretepage.entity.User;
import com.concretepage.service.ArticleService;
import com.concretepage.service.ArticleServiceImpl;
import com.concretepage.service.FERService;

@Controller
@RequestMapping("fer2")
public class ArticalController {

	@Autowired
	private ArticleService articalService;
	
	@PostMapping("/article/add")
	public ResponseEntity<String> addArticle(@RequestBody Article article) {
		boolean isAdded = articalService.addArticle(article);
		return new ResponseEntity<String>((isAdded ? "Article is added successfully."
				: isAdded  ? "Article is added successfully."
						: "Article is not added due to duplicate article."),
				HttpStatus.OK);
	}
		@PostMapping("/article/{id}")
		public ResponseEntity<String>updateArticle (@RequestBody Article article) {
			boolean updateArticleFlag = articalService.updateArticle(article);;
			return new ResponseEntity<String>((updateArticleFlag ? 
					"Expense edited successfully." : "Expense edit failed."), HttpStatus.OK);
		
	}
	
		@DeleteMapping("/article/{articalId}")
		public ResponseEntity<String> deleteExpense(@PathVariable("articalId") int articalId) {
			boolean deleteArticleFlag = articalService.deleteArticle(articalId);
			return new ResponseEntity<String>((deleteArticleFlag ?
					"Article deleted successfully." : "Article delete failed."), HttpStatus.OK);
		}
		@GetMapping("/article/{id}")
		public ResponseEntity<Article> getArtical(@PathVariable("id") int articleId) {
			Article article = articalService.getArticleById(articleId);
			return new ResponseEntity<Article>(article, HttpStatus.OK);
		}
		
		@GetMapping("/articles")
		public ResponseEntity<List<Article>> getExpenses() {
			List<Article> articles = articalService.getAllArticles();
			return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
		}
		
		
}
