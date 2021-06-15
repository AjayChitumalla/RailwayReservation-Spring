package com.org.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketNumber;
	@ManyToOne
	private User user;
	@ManyToOne
	private Train train;
	private Integer numberOfSeats;
	private String ticketClass;
	private Integer price;
}
