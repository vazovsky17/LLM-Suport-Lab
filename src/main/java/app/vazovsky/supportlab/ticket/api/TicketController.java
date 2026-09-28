package app.vazovsky.supportlab.ticket.api;

import app.vazovsky.supportlab.ticket.TicketService;
import app.vazovsky.supportlab.ticket.api.dto.CreateTicketRequest;
import app.vazovsky.supportlab.ticket.api.dto.TicketResponse;
import app.vazovsky.supportlab.ticket.domain.Ticket;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
