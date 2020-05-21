package com.web.blosom.ws.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.blosom.model.Flowers;
import com.web.blosom.rest.model.FlowersWs;
import com.web.blosom.service.FlowerServiceImpl;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RestController
public class FlowersRestServiceImpl {

	@Autowired
	private FlowerServiceImpl flowerService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/webflorist/add", method=RequestMethod.POST)
	public ResponseEntity<FlowersWs> addFlower(@RequestBody FlowersWs flowerWs) {
		flowerService.addFlower(convertWsFlowerToDomain(flowerWs));
		return new ResponseEntity<FlowersWs>(flowerWs, HttpStatus.OK);
	}

	private Flowers convertWsFlowerToDomain(FlowersWs flowersWs) {
		Flowers flowers = new Flowers();
		flowers.setCostOfFlowers(flowersWs.getCostOfFlowers());
		flowers.setDiscount(flowersWs.getDiscount());
		flowers.setFlowerId(flowersWs.getFlowerId());
		flowers.setFlowerName(flowersWs.getFlowerName());
		flowers.setNoOfFlowers(flowersWs.getNoOfFlowers());
		return flowers;
	}

	@RequestMapping(value="/webflorist/list", method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<FlowersWs>> listFlower() {
		List<Flowers> flowers = flowerService.listFlowers();
		return new ResponseEntity<List<FlowersWs>>(convertDomainToWsList(flowers), HttpStatus.OK);
	}

	private List<FlowersWs> convertDomainToWsList(List<Flowers> flowers) {
		List<FlowersWs> flowersWs = new ArrayList<FlowersWs>();

		for (Flowers flower : flowers) {
			FlowersWs wsflower = new FlowersWs();
			wsflower.setCostOfFlowers(flower.getCostOfFlowers());
			wsflower.setDiscount(flower.getDiscount());
			wsflower.setFlowerId(flower.getFlowerId());
			wsflower.setFlowerName(flower.getFlowerName());
			wsflower.setNoOfFlowers(flower.getNoOfFlowers());
			flowersWs.add(wsflower);
		}
		return flowersWs;
	}

}
