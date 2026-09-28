package app.vazovsky.supportlab.ticket.api;

import app.vazovsky.supportlab.ticket.api.dto.TicketResponse;
import app.vazovsky.supportlab.ticket.domain.Ticket;

public final class TicketMapper {

    private TicketMapper() {
    }

    public static TicketResponse toResponse(Ticket ticket) {
        return new TicketResponse(
                ticket.getId(),
                ticket.getText(),
                ticket.getStatus(),
                ticket.getCategory(),
                ticket.getPriority(),
                ticket.getSummary(),
                ticket.getSuggestedReply(),
                ticket.getCreatedAt(),
                ticket.getUpdatedAt());
    }
}
