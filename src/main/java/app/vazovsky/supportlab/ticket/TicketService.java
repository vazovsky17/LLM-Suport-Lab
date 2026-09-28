package app.vazovsky.supportlab.ticket;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;

import app.vazovsky.supportlab.ticket.domain.Ticket;
import app.vazovsky.supportlab.ticket.domain.TicketStatus;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(String text) {
        Instant now = Instant.now();

        Ticket ticket = new Ticket(
                UUID.randomUUID(),
                text,
                TicketStatus.NEW,
                now,
                now);

        return ticketRepository.save(ticket);
    }
}
