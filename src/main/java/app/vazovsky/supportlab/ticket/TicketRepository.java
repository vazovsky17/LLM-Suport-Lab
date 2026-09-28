package app.vazovsky.supportlab.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import app.vazovsky.supportlab.ticket.domain.Ticket;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {

}
