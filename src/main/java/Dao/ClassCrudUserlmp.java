package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IUserable;
import model.TblUsuariocl2;

public class ClassCrudUserlmp implements IUserable{

	@Override
	public TblUsuariocl2 getUser(TblUsuariocl2 tbluser) {
		try {
			EntityManagerFactory conex=Persistence.createEntityManagerFactory("LPII_CL2_CarhuavilcaJordy");
			EntityManager emanager=conex.createEntityManager();
			emanager.getTransaction().begin();
			
			String jpql = "SELECT u FROM TblUsuariocl2 u WHERE u.usuariocl2 = :username AND u.passwordcl2 = :password";
			TblUsuariocl2 user = emanager.createQuery(jpql, TblUsuariocl2.class)
					.setParameter("username", tbluser.getUsuariocl2())
					.setParameter("password", tbluser.getPasswordcl2())
					.getResultList()
					.stream()
					.findFirst()
					.orElse(null);
			emanager.getTransaction().commit();
			return user;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

}
