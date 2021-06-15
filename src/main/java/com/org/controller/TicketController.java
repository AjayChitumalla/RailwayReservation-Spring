package com.org.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.bean.Ticket;
import com.org.bean.Train;
import com.org.bean.User;
import com.org.repository.TicketRepository;
import com.org.repository.TrainRepository;
import com.org.repository.UserRepository;

@Controller
public class TicketController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TrainRepository trainRepository;
	@Autowired
	private TicketRepository ticketRepository;
	
	@RequestMapping("/bookTicket")
	public String bookTicket(@RequestParam("numberOfSeats") Integer numberOfSeats, 
			@RequestParam("ticketClass") String ticketClass, @RequestParam("trainNumber") Integer trainNumber, 
			@RequestParam("trainFare") Integer trainFare, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("id");
		User user = userRepository.getById(id);
		Train train = trainRepository.getById(trainNumber);
		Ticket ticket = new Ticket();
		ticket.setNumberOfSeats(numberOfSeats);
		ticket.setPrice(trainFare*numberOfSeats);
		ticket.setTicketClass(ticketClass);
		ticket.setTrain(train);
		ticket.setUser(user);
		ticketRepository.save(ticket);
		request.setAttribute("info", "Successfully booked the ticket, you can check your tickets in my tickets section !!!");
		return "home";
	}
	
	@RequestMapping("/showTickets")
	public String showUserTickets(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("id");
		List<Ticket> tickets = ticketRepository.findByUserId(id);
		session.setAttribute("tickets", tickets);
		return "show-tickets";
	}
	
	@RequestMapping("/cancelTicket")
	public String cancelTicket(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("id");
		List<Ticket> tickets = ticketRepository.findByUserId(id);
		session.setAttribute("tickets", tickets);
		
		return "cancel-ticket";
	}
	
	@RequestMapping("/processCancellation")
	@Transactional
	public String processCancellation(@RequestParam("ticketNumber") Integer ticketNumber, HttpServletRequest request) {
		
		ticketRepository.deleteByTicketNumber(ticketNumber);
		request.setAttribute("info","Ticket cancelled successfully!!!");
		return "home";
	}
}
