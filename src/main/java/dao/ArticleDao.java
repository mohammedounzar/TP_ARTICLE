package dao;

import java.util.List;

import metier.entities.Article;

public interface ArticleDao {
	public Article save(Article a);
	public List<Article> articleParMC(String mc);
	public List<Article> getAllArticles();
	public Article getArticle(Long id);
	public Article update(Article a);
	public void deleteArticle(Long id);
}