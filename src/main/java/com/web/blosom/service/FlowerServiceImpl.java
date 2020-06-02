package com.web.blosom.service;

import java.util.ArrayList;
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
        
        if(flowers.size() > 0) {
        	logger.info("Flower listed " + flowers);
            return flowers;
        } else {
            return new ArrayList<Flowers>();
        }
	}
}
