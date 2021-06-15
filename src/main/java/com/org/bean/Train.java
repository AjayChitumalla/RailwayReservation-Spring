package com.org.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "train")
@Data
public class Train {
	
	@Id
	@Column(name = "train_no")
	private Integer trainNumber;
	@Column(name = "train_name")
	private String trainName;
	@Column(name = "source_point")
	private String sourcePoint;
	@Column(name = "destination_point")
	private String destinationPoint;
	@Column(name = "start_time")
	private String startTime;
	@Column(name = "reach_time")
	private String reachTime;
	@Column(name = "available_seats")
	private Integer availableSeats;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private Integer fare;
}
