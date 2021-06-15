package com.org.controller;

import java.util.List;
import java.util.TreeSet;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.bean.Train;
import com.org.repository.TrainRepository;

@Controller
public class TrainController {

	@Autowired
	private TrainRepository trainRepository;
	
	@RequestMapping("/chooseSrcDstn")
	public String getSrcDstnPoints(HttpServletRequest request) {
		
		List<Train> trains = trainRepository.findAll();
		TreeSet<String> sourcePoints = new TreeSet<String>(), destinationPoints = new TreeSet<String>();
		for(Train train : trains) {
			sourcePoints.add(train.getSourcePoint());
			destinationPoints.add(train.getDestinationPoint());
		}
		HttpSession session = request.getSession();
		session.setAttribute("sourcePoints", sourcePoints);
		session.setAttribute("destinationPoints", destinationPoints);
		return "check-availability";
	}
	
	@RequestMapping("/checkAvailability")
	public String checkTrainAvailability(@RequestParam("source") String source, @RequestParam("destination") String destination, HttpServletRequest request) {
		
		List<Train> trains = trainRepository.findBySourcePointAndDestinationPoint(source, destination);
		if(trains.isEmpty()) {
			request.setAttribute("info", "Sorry, No trains available for the selected places");
			return "check-availability";
		}
		request.setAttribute("trains", trains);
		return "select-train";
	}
	
	@RequestMapping("/selectTrain")
	public String selectTrain(@RequestParam("trainNumber") Integer trainNumber, HttpServletRequest request) {
		
		Train train = trainRepository.findByTrainNumber(trainNumber);
		HttpSession session = request.getSession();
		session.setAttribute("selectedTrain", train);
		return "book-ticket";
	}
}
