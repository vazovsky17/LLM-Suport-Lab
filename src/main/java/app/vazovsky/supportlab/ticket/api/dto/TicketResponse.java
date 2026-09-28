package app.vazovsky.supportlab.ticket.api.dto;

import app.vazovsky.supportlab.ticket.domain.TicketCategory;
import app.vazovsky.supportlab.ticket.domain.TicketPriority;
import app.vazovsky.supportlab.ticket.domain.TicketStatus;

import java.time.Instant;
import java.util.UUID;

public record TicketResponse(
        UUID id,
        String text,
        TicketStatus status,
        TicketCategory category,
        TicketPriority priority,
        String summary,
        String suggestedReply,
        Instant createdAt,
        Instant updatedAt) {
}
