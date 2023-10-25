package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProductsable;
import model.TblProductocl2;

public class ClassCrudProductslmp implements IProductsable {

	private EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_CarhuavilcaJordy");
	@Override
	public void RegistrarProduct(TblProductocl2 tblProduc) {
		 EntityManager emf=conex.createEntityManager(); 	
	        try {
	        	emf.getTransaction().begin();
	            emf.persist(tblProduc);
	        	emf.getTransaction().commit();
	        	System.out.println("el producto fue registrado");
	        	emf.close();
	        } catch (Exception e) {
	        	System.out.println("error " + e);
	            e.printStackTrace();
	        }
	}

	@Override
	public List<TblProductocl2> listarProducts() {
		EntityManager emf= null;
		try {
			emf=conex.createEntityManager(); 
			return emf.createQuery("SELECT p FROM TblProductocl2 p", TblProductocl2.class).getResultList();	
		} catch (Exception e) {
			return null;
		}
        
	}

}
