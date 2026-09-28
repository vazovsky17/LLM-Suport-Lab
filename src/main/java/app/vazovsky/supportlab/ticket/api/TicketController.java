package app.vazovsky.supportlab.ticket.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.vazovsky.supportlab.ticket.TicketService;
import app.vazovsky.supportlab.ticket.api.dto.CreateTicketRequest;
import app.vazovsky.supportlab.ticket.api.dto.TicketResponse;
import app.vazovsky.supportlab.ticket.domain.Ticket;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketResponse create(@Valid @RequestBody CreateTicketRequest request) {
        Ticket ticket = ticketService.createTicket(request.text());

        return TicketMapper.toResponse(ticket);
    }

    @GetMapping("/{id}")
    public TicketResponse getById(@PathVariable UUID id) {
        Ticket ticket = ticketService.getTicket(id);

        return TicketMapper.toResponse(ticket);
    }
}
