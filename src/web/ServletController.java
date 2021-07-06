package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metierEntite.*;

import metier.SingletonConnection;
import dao.*;


/**
 * Servlet implementation class ServletController
 */
@WebServlet (name="cs",urlPatterns= {"/test","/controleur","/GestEtu","/AddEtu","/saveEtud","/DelEtu","/ModfEtu","/modEtud","/GestProf","/AddProf","/SaveProf","/modProf","/ModfProf"})
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   DaoActu Actu;
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	private LoginDAO loginDao;
	private EtudiantDaoImpl etudiantDao = new EtudiantDaoImpl();
	private ProfesseurDaoImpl profDao=new ProfesseurDaoImpl();

    public void init() {
        loginDao = new LoginDAO();
        
    }

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getServletPath().equals("/test"))
		{	
		request.getRequestDispatcher("/Authentification.jsp").forward(request,response);
		}
		 
		 if(request.getServletPath().equals("/GestEtu")) {
				List<Etudiant> listeEtudiant = etudiantDao.getAllEtudiant();
				listeEtudiant.stream().forEach(System.out::println);
				request.setAttribute("listeEtudiant", listeEtudiant);
				request.getRequestDispatcher("/formulaire.jsp").forward(request, response);
		}
		 if(request.getServletPath().equals("/AddEtu")) {
			 request.getRequestDispatcher("/AddEtud.jsp").forward(request,response);
		 }
		 if(request.getServletPath().equals("/AddProf")) {
			 request.getRequestDispatcher("/GesPro.jsp").forward(request,response);
		 }
		 if(request.getServletPath().equals("/GestProf")) {
			 List<Professeur> listeProfesseurs = profDao.getAllProf();
				listeProfesseurs.stream().forEach(System.out::println);
				request.setAttribute("listeProfesseurs", listeProfesseurs);
				
			 request.getRequestDispatcher("/ListeProf.jsp").forward(request,response);
		 }
		 
		 doPost(request, response);
	 }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String username = request.getParameter("email");
	        String password = request.getParameter("pass");
	        User loginBean = new User(username,password);
	     
	        if(request.getServletPath().equals("/controleur")) {
	        	
	        
	        if (loginDao.validation(loginBean)) {
			    HttpSession session = request.getSession();
			    session.setAttribute("username",username);
	        	this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
	        
	        else {
				/*
				 * HttpSession session = request.getSession(); session.setAttribute("user",
				 * username);
				 */
				this.getServletContext().getRequestDispatcher("/Authentification.jsp").forward(request, response);
			}}
	        if(request.getServletPath().equals("/saveEtud")) {
				String nomc =request.getParameter("fullname");
				String[] spl = nomc.split(" ");
				String prenom = spl[0];
				String nom =spl[1];
				String pass=request.getParameter("password");

				String email=request.getParameter("email");
				String massar=request.getParameter("massar");
				Etudiant et= new Etudiant(email, massar, pass, nom, prenom);
				etudiantDao.Add(et);
	        	response.sendRedirect("/DepartementWebSite/GestEtu");
			}
	        else if (request.getServletPath().equals("/DelEtu")) {
	        	int id=Integer.parseInt(request.getParameter("id"));
	        	System.out.println("diliteee  "+id);
	        	etudiantDao.Stop(id);
	        	List<Etudiant> listeEtudiant = etudiantDao.getAllEtudiant();
				request.setAttribute("listeEtudiant", listeEtudiant);

	        	response.sendRedirect("/DepartementWebSite/GestEtu");

	        	
	        	
	        }
	        if(request.getServletPath().equals("/SaveProf")) {
				String nomc =request.getParameter("fullname");
				String[] spl = nomc.split(" ");
				String prenom = spl[0];
				String nom =spl[1];
				String pass=request.getParameter("password");

				String email=request.getParameter("email");
				int tel=Integer.parseInt(request.getParameter("phone"));
				
				Professeur pr= new Professeur(nom, prenom,tel,email,  pass );
				profDao.Add(pr);
	        	response.sendRedirect("/GestProf");
			}
	        if(request.getServletPath().equals("/ModfEtu")) {
	        	int id=Integer.parseInt(request.getParameter("id"));
	        	Etudiant et = etudiantDao.getEtudiantParId(id);
	        	request.setAttribute("et", et);
				this.getServletContext().getRequestDispatcher("/ModfEtu.jsp").forward(request, response);
	        }
	        if(request.getServletPath().equals("/modEtud")) {
				String nomc =request.getParameter("fullname");
				String[] spl = nomc.split(" ");
				String prenom = spl[0];
				String nom =spl[1];
				String pass=request.getParameter("password");
	        	int id=Integer.parseInt(request.getParameter("id"));

				String email=request.getParameter("email");
				String massar=request.getParameter("massar");
				Etudiant et= new Etudiant(email, massar, pass, nom, prenom);
				etudiantDao.Modify(et.getNom(), et.getPrenom(), et.getEmail(), et.getMdp(),et.getMassar(), id);
				List<Etudiant> listeEtudiant = etudiantDao.getAllEtudiant();
				request.setAttribute("listeEtudiant", listeEtudiant);

	        	response.sendRedirect("GestEtu");
	       
		 		 }
	        if(request.getServletPath().equals("/ModfProf")) {
	        	int id=Integer.parseInt(request.getParameter("id"));
	        	Professeur pr = profDao.getProfesseurById(id);
	        	System.out.println(pr.getTel());
	        	request.setAttribute("pr", pr);
				this.getServletContext().getRequestDispatcher("/ModfProf.jsp").forward(request, response);
	        }
	        if(request.getServletPath().equals("/modProf")) {
				String nomc =request.getParameter("fullname");
				String[] spl = nomc.split(" ");
				String prenom = spl[0];
				String nom =spl[1];
				String pass=request.getParameter("password");
	        	int id=Integer.parseInt(request.getParameter("id"));
				String email=request.getParameter("email");
				int tel=Integer.parseInt(request.getParameter("phone"));
				Professeur pr= new Professeur(nom, prenom,tel,email,pass );
				profDao.Modify(nom, prenom, email, pass,tel, id);
				List<Professeur> listeProfesseurs = profDao.getAllProf();
				request.setAttribute("listeEtudiant", listeProfesseurs);

	        	response.sendRedirect("/GestProf");
	       
		 		 }
		
	}
	}
	
