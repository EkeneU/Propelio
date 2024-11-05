package com.propelio.PropelioLandingPage.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactFormDTO {
    @NotEmpty(message = "First name is required")
    private String first_name;
    @NotEmpty(message = "Last name is required")
    private String last_name;
    @Email(message = "Message is required")
    private String email;
    @NotEmpty(message = "Message is required")
    private String message;
}
