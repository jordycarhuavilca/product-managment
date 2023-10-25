package Controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassCrudUserlmp;
import model.TblUsuariocl2;

/**
 * Servlet implementation class ControllerUser
 */
public class ControllerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ControllerProduct controProdcut = new ControllerProduct();
		controProdcut.doGet(request, response);
		}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassCrudUserlmp userService = new ClassCrudUserlmp();
		String txtUser = request.getParameter("user");
		String txtPassword= request.getParameter("password");
		TblUsuariocl2  userObj = new TblUsuariocl2();
		userObj.setUsuariocl2(txtUser);
		userObj.setPasswordcl2(txtPassword);
		TblUsuariocl2 user = userService.getUser(userObj);
		if(user != null) {
			doGet(request,response);
		}else {
			request.setAttribute("message", "login fallido. por favor revisar tus credenciales.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
