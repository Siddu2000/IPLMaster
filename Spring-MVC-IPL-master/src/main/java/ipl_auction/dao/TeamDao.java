package ipl_auction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ipl_auction.dto.Team;

@Component
public class TeamDao {
	@Autowired
	EntityManager manager;

	public void save(Team team) {
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(team);
		transaction.commit();
	}

	public Team login(String username) {

		List<Team> list = manager.createQuery("select x from Team x where username=?1").setParameter(1, username)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public List<Team> getAllTeam() {

		return manager.createQuery("select x from Team x")
				.getResultList();
		
	}
	
	public Team findById(int id)
	{

		return manager.find(Team.class, id);
	}

	public void update(Team team) {
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.merge(team);
		transaction.commit();
	}

	public List<Team> getAllTeamByName(String name) {
		return manager.createQuery("select x from Team x where name=?1").setParameter(1, name)
				.getResultList();
	}

}
