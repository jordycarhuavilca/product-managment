package TestEntidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblUsuariocl2;

public class TestUser {

	public static void main(String[] args) {
				EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_CarhuavilcaJordy");
				EntityManager emanager=conex.createEntityManager();
				emanager.getTransaction().begin();
				
				String jpql = "SELECT u FROM TblUsuariocl2 u WHERE u.usuariocl2 = :username AND u.passwordcl2 = :password";
				TblUsuariocl2 user = emanager.createQuery(jpql, TblUsuariocl2.class)
				    .setParameter("username", "admin")
				    .setParameter("password", "admin")
				    .getResultList()
				    .stream()
				    .findFirst()
				    .orElse(null);

				emanager.getTransaction().commit();

				if (user != null) {
				    System.out.println("correct  credentianls");
				} else {
				    System.out.println("incorrect  credentianls");
				}

	}    //fin del metodo principal...

}   //fin de la clase....
