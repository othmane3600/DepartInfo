package web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.jdbc.Blob;

import dao.DaoActu;
import dao.EQPR_DAO;
import dao.Emploi_du_TempsDAO;
import dao.Emploi_du_tempsDaoImpl;
import dao.EtudiantDaoImpl;
import dao.JournalistImpl;
import dao.LoginDAO;
import dao.ProfesseurDao;
import dao.ProfesseurDaoImpl;
import metierEntite.Emploi_du_temps;
import metierEntite.Equipe_Recherche;
import metierEntite.Etudiant;
import metierEntite.Journaliste;
import metierEntite.Professeur;
import metierEntite.User;


/**
 * Servlet implementation class ServletController
 */
@WebServlet (name="cs",urlPatterns= {"/test","/controleur","/GestEtu","/AddEtu","/saveEtud","/DelEtu","/ModfEtu",
		"/modEtud","/GestProf","/AddProf","/SaveProf","/modProf","/listeEqr"
		,"/ModfProf","/GestEqp","/addEqr","/Slct1","/Slct2","/Slct3","/listerJournaliste","/AddJournalistepost","/AddJournalisteget"})
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
    private EQPR_DAO eq= new EQPR_DAO();
    private JournalistImpl journalisteDao  ;
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
		 if(request.getServletPath().equals("/Slct1")) {
				System.out.println(request.getServletPath());
			 List<Etudiant> listeEtudiant = etudiantDao.getEtudiantActive();
				listeEtudiant.stream().forEach(System.out::println);
				request.setAttribute("listeEtudiant", listeEtudiant);
				request.getRequestDispatcher("/formulaire.jsp").forward(request, response);
		}
		 if(request.getServletPath().equals("/Slct2")) {
				List<Etudiant> listeEtudiant = etudiantDao.getEtudiantNotActive();
				
				System.out.println("Ziad zin" + listeEtudiant.size());
				request.setAttribute("listeEtudiant", listeEtudiant);
				request.getRequestDispatcher("/formulaire.jsp").forward(request, response);
		}
		 if(request.getServletPath().equals("/Slct3")) {
				List<Etudiant> listeEtudiant = etudiantDao.getAllEtudiant();
				listeEtudiant.stream().forEach(System.out::println);
				request.setAttribute("listeEtudiant", listeEtudiant);
				request.getRequestDispatcher("/formulaire.jsp").forward(request, response);
		}
		 
		if(request.getServletPath().equals("/listerJournaliste")) {
				List<Journaliste> listeJournaliste = journalisteDao.listerJournalistes();
				request.setAttribute("listesJournaliste", listeJournaliste);
				request.getRequestDispatcher("/listeJournalistes.jsp").forward(request, response);
		}
		
		if(request.getServletPath().equals("/AddJournalisteget")) {
			request.getRequestDispatcher("/ajouterJournaliste.jsp").forward(request, response);
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

	        	response.sendRedirect("GestProf");
	       
		 		 }
	        else if (request.getServletPath().equals("/DelProf")) {
	        	int id=Integer.parseInt(request.getParameter("id"));
	        	System.out.println("diliteee  "+id);
	        	profDao.Stop(id);
	        	List<Professeur> listeProfesseurs = profDao.getAllProf();
				request.setAttribute("listeProf", listeProfesseurs);

	        	response.sendRedirect("GestProf");
	}
	        else if(request.getServletPath().equals("/GestEqp")) {
                List<Professeur> p = profDao.getAllProf();
                request.setAttribute("professeurs", p);
                System.out.println(p);
                  this.getServletContext().getRequestDispatcher("/EqpRchrch.jsp").forward(request, response);
            }else if(request.getServletPath().equals("/addEqr")) {
                String nom = request.getParameter("nom");
                String sujet = request.getParameter("sujet");
               String[] prof = request.getParameterValues("professeur");
               for (int i = 0; i < prof.length; i++) {
                  System.out.println(prof[i]);
              }
               int[]idprof = {0,0,0,0};
               for (int i = 0; i < prof.length; i++) {
                   idprof[i]=Integer.parseInt(prof[i]);
                  System.out.println(idprof[i]);
              }
               Equipe_Recherche er = new Equipe_Recherche(nom, sujet);
               eq.addEqp(er, idprof);

            }
            else if(request.getServletPath().equals("/listeEqr")){
                List<Equipe_Recherche> er = eq.getAllEqpr();
                request.setAttribute("equipes", er);
              this.getServletContext().getRequestDispatcher("/ListeEqr.jsp").forward(request, response);

            }else if(request.getServletPath().equals("/AddJournalistepost")) {
            	 String Nom = request.getParameter("nom");
            	 String Prenom = request.getParameter("prenom");
            	 String Email = request.getParameter("email");
            	 String Mdp = request.getParameter("mdp");
            	Journaliste journaliste = new Journaliste();
            	journaliste.setEmail(Email);
            	journaliste.setNom(Nom);
            	journaliste.setPrenom(Prenom);
            	journaliste.setMdp(Mdp);
            	journalisteDao.ajouterJournaliste(journaliste);
            	List<Journaliste> listeJournaliste = journalisteDao.listerJournalistes();
				request.setAttribute("listesJournaliste", listeJournaliste);
				request.getRequestDispatcher("/listeJournalistes.jsp").forward(request, response);
            	
            }
	        
			if(request.getServletPath().equals("/AddEmploipost")) {
				int idProfesseur = Integer.parseInt(request.getParameter("idProfesseur"));
				String nomEmploi = request.getParameter("nomEmploi");
				Emploi_du_TempsDAO emploDao = new  Emploi_du_tempsDaoImpl();
				ProfesseurDao professeurDao = new ProfesseurDaoImpl();
				
				
				 Part filePart = request.getPart("emploi");
		            InputStream emploiFile = null;
		            if (filePart != null) {
		            	emploiFile = filePart.getInputStream();
		            }
		            
		            
				Emploi_du_temps emploi = new Emploi_du_temps(emploiFile,nomEmploi);
				emploDao.Add(emploi);
				
				Emploi_du_temps emploiAvecId = emploDao.getEmploiByName(emploi.getNom());
				
				professeurDao.updateProfesseur(idProfesseur, emploiAvecId.getIdEmploi());
				request.getRequestDispatcher("/ajouterEmploi.jsp").forward(request, response);
			}
	}}
	
