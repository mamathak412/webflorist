package com.web.blosom.dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.web.blosom.entity.WBFLowers;
import com.web.blosom.model.Flowers;

@Component
public class FlowersDAOImpl {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void saveFlower(DFlowers flowers) {
		entityManager.persist(convertFlowerDomainToEntityModel(flowers));
	}

	@Transactional
	public List<DFlowers> listFlower() {
		List<FLowers> wbFlowers = entityManager.createQuery("Select d from FLOWERS d", FLowers.class)
				.getResultList();
		return convertEntityToDomain(wbFlowers);
	}

	private List<DFlowers> convertEntityToDomain(List<FLowers> wbFlowers) {
		List<DFlowers> flowers = new ArrayList<DFlowers>();

		for (FLowers wbFlower : wbFlowers) {
			DFlowers flower = new DFlowers();
			flower.setCostOfFlowers(wbFlower.getCostOfFlowers());
			flower.setDiscount(wbFlower.getDiscount());
			flower.setFlowerName(wbFlower.getFlowerName());
			flower.setNoOfFlowers(wbFlower.getNoOfFlowers());
			flowers.add(flower);
		}
		return flowers;
	}

	private FLowers convertFlowerDomainToEntityModel(DFlowers flowers) {
		FLowers wbFlowers = new FLowers();
		wbFlowers.setCostOfFlowers(flowers.getCostOfFlowers());
		wbFlowers.setDiscount(flowers.getDiscount());
		wbFlowers.setFlowerName(flowers.getFlowerName());
		wbFlowers.setNoOfFlowers(flowers.getNoOfFlowers());
		return wbFlowers;
	}

}
