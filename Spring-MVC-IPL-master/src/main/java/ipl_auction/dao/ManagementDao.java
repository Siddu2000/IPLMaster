package ipl_auction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ipl_auction.dto.Management;

@Component
public class ManagementDao {
	
	@Autowired
	EntityManager manager;

	public void save(Management management) {
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(management);
		transaction.commit();
	}

	public Management login(String username) {

		List<Management> list=manager.createQuery("select x from Management x where username=?1")
				.setParameter(1, username).getResultList();
		if(list.isEmpty())
		{
			return null;
		}
		else {
			return list.get(0);
		}
	}

}
