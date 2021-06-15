package com.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.bean.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{

	List<Ticket> findByUserId(Integer id);
	
	@Modifying
	@Query(value = "DELETE FROM Ticket t WHERE t.ticketNumber = :ticketNumber")
	int deleteByTicketNumber(@Param("ticketNumber") Integer ticketNumber);
}
