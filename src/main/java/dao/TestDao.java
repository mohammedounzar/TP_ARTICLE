package dao;

import java.util.List;

import metier.entities.Article;

public class TestDao {
	public static void main(String[] args) {
		ArticleDaoImpl dao=new ArticleDaoImpl();
		//Article a=dao.save(new Article("Green Boys 05", "lfada2i moul taj"));
		//Article a2=dao.save(new Article("Eagles 06", "lheyba o lkarizma"));
		//System.out.println(a.toString());
		//System.out.println(a2.toString());
		System.out.println("Chercher des articles");
		//List<Article> articles=dao.articleParMC("%oul%");
		List<Article> articles=dao.getAllArticles();
		for (Article article: articles) {
			System.out.println(article.toString());
		}
	}
}
