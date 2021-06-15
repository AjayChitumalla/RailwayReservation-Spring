package com.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.bean.Train;

public interface TrainRepository extends JpaRepository<Train, Integer>{
	
	List<Train> findBySourcePointAndDestinationPoint(String source, String destination);
	Train findByTrainNumber(Integer trainNumber);
}
