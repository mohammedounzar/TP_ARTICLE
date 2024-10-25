package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Article;

import java.io.IOException;
import java.util.List;

import org.apache.catalina.connector.Response;

import dao.ArticleDao;
import dao.ArticleDaoImpl;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDao metier;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@Override
	public void init() throws ServletException {
		metier=new ArticleDaoImpl();
	}
	
    public ControleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if(path.equals("/index.do")) {
			ArticleModel model=new ArticleModel();
			List<Article> articles=metier.getAllArticles();
			model.setArticles(articles);
			request.setAttribute("model", model);
			request.getRequestDispatcher("articles.jsp").forward(request, response);
		}
		else if(path.equals("/chercher.do")) {
			String motCle=request.getParameter("motCle");
			ArticleModel model=new ArticleModel();
			model.setMotCle(motCle);
			List<Article> articles=metier.articleParMC("%"+motCle+"%");
			model.setArticles(articles);
			request.setAttribute("model", model);
			request.getRequestDispatcher("articles.jsp").forward(request, response);
		}
		else if(path.equals("/saisie.do")) {
			request.setAttribute("article", new Article());
			request.getRequestDispatcher("SaisieArticle.jsp").forward(request, response);
			
		}
		else if(path.equals("/SaveArticle.do")&&(request.getMethod().equals("POST"))) {
			String titre=request.getParameter("titre");
			String contenu=request.getParameter("contenu");
			Article a=metier.save(new Article(titre, contenu));
			request.setAttribute("article", a);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
		}
		else if(path.equals("/Supprimer.do")) {
			Long id=Long.parseLong(request.getParameter("id"));
			metier.deleteArticle(id);
			//request.getRequestDispatcher("produits.jsp").forward(request, response);
			response.sendRedirect("chercher.do?motCle=");
		}
		else if(path.equals("/Edit.do")) {
			Long id=Long.parseLong(request.getParameter("id"));
			Article a=metier.getArticle(id);
			request.setAttribute("article", a);
			request.getRequestDispatcher("EditProduit.jsp").forward(request, response);
		}
		else if(path.equals("/UpdateArticle.do")&&(request.getMethod().equals("POST"))) {
			Long id=Long.parseLong(request.getParameter("id"));
			String titre=request.getParameter("titre");
			String contenu=request.getParameter("contenu");
			Article a= new Article(titre, contenu);
			a.setId(id);
			metier.update(a);
			request.setAttribute("article", a);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
		}
		else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
