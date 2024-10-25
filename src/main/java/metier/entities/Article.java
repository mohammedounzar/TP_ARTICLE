package metier.entities;

import java.io.Serializable;

public class Article implements Serializable {
	private Long id;
	private String titre;
	private String contenu;
	public Article(String titre, String contenu) {
		super();
		this.titre = titre;
		this.contenu = contenu;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", contenu=" + contenu + "]";
	}
	
	
}
