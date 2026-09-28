package app.vazovsky.supportlab.ticket.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTicketRequest(

        @NotBlank @Size(max = 10_000) String text

) {
}
