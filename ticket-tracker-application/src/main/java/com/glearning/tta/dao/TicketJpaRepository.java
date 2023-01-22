package com.glearning.tta.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.glearning.tta.model.Ticket;
	
	public interface TicketJpaRepository extends JpaRepository<Ticket, Integer>{
		@Query(value = "select * from Ticket t where t.ticketTitle like %:keyword% or t.shortDec like %:keyword%", nativeQuery = true)
		List<Ticket> findByKeyword(@Param("keyword") String keyword);


	}

