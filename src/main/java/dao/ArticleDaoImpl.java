package dao;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public Article save(Article a) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("INSERT INTO ARTICLES (TITRE, CONTENU) VALUES (?,?)");
			ps.setString(1, a.getTitre());
			ps.setString(2, a.getContenu());
			ps.executeUpdate();
			PreparedStatement ps2=connection.prepareStatement
					("SELECT MAX(ID) AS MAX_ID FROM ARTICLES");
			ResultSet rs=ps2.executeQuery();
			if(rs.next()) {
				a.setId(rs.getLong("MAX_ID"));
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Article> articleParMC(String mc) {
		Connection connection=SingletonConnection.getConnection();
		List<Article> articles = new ArrayList<Article>();
		try {
			PreparedStatement ps=connection.prepareStatement
					("SELECT * FROM ARTICLES WHERE CONTENU LIKE ?");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Article a=new Article();
				a.setId(rs.getLong("ID"));
				a.setContenu(rs.getString("CONTENU"));
				a.setTitre(rs.getString("TITRE"));
				articles.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}
	
	@Override
	public List<Article> getAllArticles() {
		Connection connection=SingletonConnection.getConnection();
		List<Article> articles = new ArrayList<Article>();
		try {
			PreparedStatement ps=connection.prepareStatement
					("SELECT * FROM ARTICLES");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Article a=new Article();
				a.setId(rs.getLong("ID"));
				a.setContenu(rs.getString("CONTENU"));
				a.setTitre(rs.getString("TITRE"));
				articles.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public Article getArticle(Long id) {
		Article a=null;
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM ARTICLES WHERE ID=?");
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				a=new Article();
				a.setId(rs.getLong("ID"));
				a.setTitre(rs.getString("TITRE"));
				a.setContenu(rs.getString("CONTENU"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Article update(Article a) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("UPDATE ARTICLES SET TITRE=?,CONTENU=? WHERE ID=?");
			ps.setString(1, a.getTitre());
			ps.setString(2,a.getContenu());
			ps.setLong(3, a.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void deleteArticle(Long id) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("DELETE FROM ARTICLES WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
