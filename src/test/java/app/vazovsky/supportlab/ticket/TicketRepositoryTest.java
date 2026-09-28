package app.vazovsky.supportlab.ticket;

import app.vazovsky.supportlab.ticket.domain.Ticket;
import app.vazovsky.supportlab.ticket.domain.TicketStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@DataJpaTest
class TicketRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17");

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void shouldSaveAndFindTicket() {
        UUID id = UUID.randomUUID();
        Instant now = Instant.now();

        Ticket ticket = new Ticket(
                id,
                "Не могу войти в аккаунт",
                TicketStatus.NEW,
                now,
                now);

        ticketRepository.save(ticket);

        Ticket savedTicket = ticketRepository.findById(id).orElseThrow();

        assertThat(savedTicket.getId()).isEqualTo(id);
        assertThat(savedTicket.getText()).isEqualTo("Не могу войти в аккаунт");
        assertThat(savedTicket.getStatus()).isEqualTo(TicketStatus.NEW);
    }
}
