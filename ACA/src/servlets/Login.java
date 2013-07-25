package servlets;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acceso.UnidadCentralDAO;

import model.User;


public class Login extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	private UnidadCentralDAO unidadCentralDAO;
	

	public void init(){
		unidadCentralDAO = null;
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)	throws IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User userOrNull = unidadCentralDAO.getUser(username);

		if (userOrNull != null && password.equals(userOrNull.getPassword())) {

			HttpSession session = req.getSession(true);
			String welcomePage = userOrNull.welcomePage();
			session.setAttribute("welcomePage", welcomePage);
			res.sendRedirect("./" + welcomePage);

		} else res.sendRedirect("./login.html");
	}
}
