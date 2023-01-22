package com.glearning.tta.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.tta.dao.TicketJpaRepository;
import com.glearning.tta.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketJpaRepository ticketRepository;

	@Override
	public List<Ticket> getAllTicket() {
		return ticketRepository.findAll();
	}

	@Override
	public void saveTicket(Ticket ticket) {
		this.ticketRepository.save(ticket);
		
	}

	@Override
	public Ticket getTicketById(int id) {
		Optional<Ticket> optional = ticketRepository.findById(id);
		Ticket ticket = null;
		if(optional.isPresent()) {
			ticket = optional.get();
		}
		else {
			throw new RuntimeException("Ticket not found");
		}
		return ticket;
	}

	@Override
	public void deleteTicketById(int id) {
		this.ticketRepository.deleteById(id);
		
	}
	@Override
	public List<Ticket> getByKeyword(String keyword) {
		return ticketRepository.findByKeyword(keyword);
	}

	
		
	}
	


