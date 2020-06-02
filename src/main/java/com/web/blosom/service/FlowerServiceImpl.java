package com.web.blosom.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.web.blosom.dao.FlowerRepository;
import com.web.blosom.model.Flowers;
import com.web.blosom.ws.rest.FlowersRestServiceImpl;

@Component
public class FlowerServiceImpl {
	
	private Logger logger = LoggerFactory.getLogger(FlowersRestServiceImpl.class);
	
	@Autowired
	private FlowerRepository flowersRepository;

	public void addFlower(Flowers flower){
           flowersRepository.save(flower);
           logger.info("Flower added " + flower);
	}
	
	public List<Flowers> listFlowers(){
		List<Flowers> flowers = flowersRepository.findAll();
		logger.info("Flowers in service " + flowers);
        if(flowers.size() > 0) {
        	logger.info("Flower listed " + flowers);
            return flowers;
        } else {
        	Flowers flower1 = new Flowers();
        	flower1.setFlowerId(1);
        	flower1.setFlowerName("Rose");
        	flower1.setCostOfFlowers(10);
        	flower1.setDiscount(2.0);
        	
        	Flowers flower2 = new Flowers();
        	flower2.setFlowerId(2);
        	flower2.setFlowerName("Lilly");
        	flower1.setCostOfFlowers(15);
        	flower1.setDiscount(1.5);
        	
        	flowers.add(flower1);
        	flowers.add(flower2);
            return flowers;
        }
	}
}
