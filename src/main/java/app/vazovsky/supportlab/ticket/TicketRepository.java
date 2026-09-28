package app.vazovsky.supportlab.ticket;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import app.vazovsky.supportlab.ticket.domain.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {

}
