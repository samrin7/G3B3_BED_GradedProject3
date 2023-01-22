package com.glearning.tta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.glearning.tta.model.Ticket;
import com.glearning.tta.service.TicketService;
import com.glearning.tta.service.TicketServiceImpl;

@Controller
public class TicketController {

	@Autowired
	private TicketService ticketService;

	private TicketServiceImpl ticketServiceImpl;

	// display list of ticket
	@GetMapping("/index")
	public String viewHomePage(Model model) {
		model.addAttribute("listTicket", ticketService.getAllTicket());
		return "index";

	}

	// creating ticket
	@GetMapping("/addTicket")
	public String showTicketForm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "createTicket";
	}

	@PostMapping("/process")
	public String saveTicet(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.saveTicket(ticket);
		return "redirect:/index";

	}

	@GetMapping("/updateForm/{id}")
	public String updateTicket(@PathVariable(value = "id") int id, Model model) {
		// get Ticket from service
		Ticket ticket = ticketService.getTicketById(id);
		// set ticket as a model
		model.addAttribute("ticket", ticket);
		return "updateTicket";
	}

	@GetMapping("/deleteTicket/{id}")
	public String deleteTicket(@PathVariable(value = "id") int id) {
		this.ticketService.deleteTicketById(id);
		return "redirect:/index";
	}

	@GetMapping(path = { "/search" })
	public String home(Ticket ticket, Model model, String keyword) {
		if (keyword != null) {
			List<Ticket> ticket1 = ticketServiceImpl.getByKeyword(keyword);
			model.addAttribute("ticket", ticket1);
		} else {
			List<Ticket> list = ticketService.getAllTicket();
			model.addAttribute("list", list);
		}
		return "index";
	}

	@GetMapping("/viewForm/{id}")
	public String viewTicket(@PathVariable(value = "id") int id, Model model) {
		// get Ticket from service
		Ticket ticket = ticketService.getTicketById(id);
		// set ticket as a model
		model.addAttribute("ticket", ticket);
		return "view";
	}
}

