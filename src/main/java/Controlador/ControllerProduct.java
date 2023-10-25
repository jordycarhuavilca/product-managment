package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassCrudProductslmp;
import model.TblProductocl2;

/**
 * Servlet implementation class ControllerProduct
 */
public class ControllerProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassCrudProductslmp userService = new ClassCrudProductslmp();
		List<TblProductocl2> products = userService.listarProducts();
		request.setAttribute("listProducts",products);
		request.getRequestDispatcher("/insertProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassCrudProductslmp userService = new ClassCrudProductslmp();

		String txtName= request.getParameter("name");
		String txtDescription = request.getParameter("description");
		String txtState= request.getParameter("state");
		String txtPurchPrice= request.getParameter("purchasedPrice");
		String txtSellPrice= request.getParameter("sellPrice");
		
		TblProductocl2 tbproduc = new TblProductocl2();
		tbproduc.setNombrecl2(txtName);
		tbproduc.setDescripcl2(txtDescription);
		tbproduc.setEstadocl2(txtState);
		tbproduc.setPreciocompcl2(Double.parseDouble(txtPurchPrice));
		tbproduc.setPrecioventacl2(Double.parseDouble(txtSellPrice));
		userService.RegistrarProduct(tbproduc);
		request.setAttribute("success","Datos registrado en la BD");
		doGet(request,response);
		
	}

}
