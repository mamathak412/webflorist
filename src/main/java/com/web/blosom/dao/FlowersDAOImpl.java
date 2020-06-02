package com.web.blosom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.web.blosom.model.Flowers;

@Component
public class FlowersDAOImpl {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void saveFlower(Flowers flowers) {
		entityManager.persist(flowers);
	}

	@Transactional
	public List<Flowers> listFlower() {
		List<Flowers> wbFlowers = entityManager.createQuery("Select f from Flowers f", Flowers.class)
				.getResultList();
		return wbFlowers;
	}


}
