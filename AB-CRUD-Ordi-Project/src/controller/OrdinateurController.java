package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrdinateurDAO;
import dao.OrdinateurDAOImplementation;
import model.Ordinateur;

/**
 * Servlet implementation class OrdinateurController
 */
@WebServlet("/OrdinateurController")
public class OrdinateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private OrdinateurDAO dao;
	private static final String List_Ordinateur="/WEB-INF/listeOrdinateur.jsp";
	private static final String Insert_OR_Edit="/WEB-INF/ordinateur.jsp";
	
    
    public OrdinateurController() {
        
        dao = new OrdinateurDAOImplementation();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward="";
		String action = request.getParameter("action");
		
		
		
		if (action.equalsIgnoreCase("delete")){
			forward=List_Ordinateur;
			int ordinateurId= Integer.parseInt(request.getParameter("ordinateurId"));
			dao.deleteOrdinateur(ordinateurId);
			request.setAttribute("ordinateurs", dao.getAllOrdinateurs());
			
		} else if(action.equals("edit")){
			forward=Insert_OR_Edit;
			int ordinateurId= Integer.parseInt(request.getParameter("ordinateurId"));
			Ordinateur ordinateur=dao.getOrdinateurById(ordinateurId);
			request.setAttribute("ordinateur", ordinateur);
		} else if(action.equalsIgnoreCase("insert")){
			
			forward= Insert_OR_Edit;
			
		} else{
			
			forward=List_Ordinateur;
			request.setAttribute("ordinateurs", dao.getAllOrdinateurs());
			
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		Ordinateur ordinateur=new Ordinateur();
		ordinateur.setFabricant(request.getParameter("fabricant"));
		ordinateur.setModel(request.getParameter("model"));		
		ordinateur.setTailleDD(request.getParameter("tailleDD"));
		ordinateur.setTailleMemoire(request.getParameter("tailleMemoire"));
		ordinateur.setTailleEcran(request.getParameter("tailleEcran"));
		ordinateur.setTypeProcesseur(request.getParameter("typeProcesseur"));
		
		String ordinateurId=request.getParameter("ordinateurId");
		
		if(ordinateurId == null || ordinateurId.isEmpty())
			dao.addOrdinateur(ordinateur);
		else{
			ordinateur.setOrdinateurId(Integer.parseInt(ordinateurId));
			dao.updateOrdinateur(ordinateur);			
		}
		RequestDispatcher view = request.getRequestDispatcher(List_Ordinateur);
		request.setAttribute("ordinateurs", dao.getAllOrdinateurs());
		view.forward(request, response);
		
	}

}
