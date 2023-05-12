package ipl_auction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ipl_auction.dto.Player;

@Component
public class PlayerDao {
	@Autowired
	EntityManager manager;

	public void save(Player player) {
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.persist(player);
		transaction.commit();
	}

	public Player login(String username) {

		List<Player> list = manager.createQuery("select x from Player x where username=?1").setParameter(1, username)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public List<Player> getAllPlayers() {

		return manager.createQuery("select x from Player x")
				.getResultList();
	}

	public Player getPlayerById(int id) {
		return manager.find(Player.class, id);
	}

	public void updatePlayer(Player player) {
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();
		manager.merge(player);
		transaction.commit();
	}

	public List<Player> getAvailbalePlayers() {

		return manager.createQuery("select x from Player x where status='Available'")
				.getResultList();
	}
}
