package ipl_auction.helper;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ipl_auction")
public class IplConfig {

	@Bean
	public EntityManager getEMF()
	{
		return Persistence.createEntityManagerFactory("dev").createEntityManager();
	}
}
