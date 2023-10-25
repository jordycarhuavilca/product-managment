package TestEntidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblProductocl2;

public class TestProducto {
	static EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_CarhuavilcaJordyII");
	static EntityManager emf=conex.createEntityManager(); 
	
	public static void main(String[] args) {
		insertProduct();
		System.out.println();
		listProducts();
	}

    private static void insertProduct() {
    	
		TblProductocl2 product = new TblProductocl2();
		product.setDescripcl2("pulcera acrilico hecho en us");
		product.setEstadocl2("disponible");
		product.setNombrecl2("pulcera");
		product.setPreciocompcl2(18.90);
		product.setPrecioventacl2(29.90);
        try {
        	emf.getTransaction().begin();
            emf.persist(product);
        	emf.getTransaction().commit();
        	System.out.println("el producto fue registrado");
        } catch (Exception e) {
        	System.out.println("error " + e);
            e.printStackTrace();
        }
    }

    private static void listProducts() {
        try {
        	EntityManager emf=conex.createEntityManager(); 
            List<TblProductocl2> listProdu = emf.createQuery("SELECT p FROM TblProductocl2 p", TblProductocl2.class).getResultList();
            for (TblProductocl2 product : listProdu) {
                System.out.println("ID: " + product.getIdproductocl2());
                System.out.println("Nombre: " + product.getNombrecl2());
                System.out.println("Descripción: " + product.getDescripcl2());
                System.out.println("Estado: " + product.getEstadocl2());
                System.out.println("Precio Compra: " + product.getPreciocompcl2());
                System.out.println("Precio Venta: " + product.getPrecioventacl2());
                System.out.println();
            }
        } catch (Exception e) {
        	System.out.println("error " + e);
            e.printStackTrace();		}
    }
}
