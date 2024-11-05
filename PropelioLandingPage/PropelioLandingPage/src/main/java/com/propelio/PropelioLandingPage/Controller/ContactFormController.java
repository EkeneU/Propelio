package com.propelio.PropelioLandingPage.Controller;

import com.propelio.PropelioLandingPage.DTO.ContactFormDTO;
import com.propelio.PropelioLandingPage.Service.ContactFormService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propelio/api/contact")
public class ContactFormController {
    @Autowired
    private ContactFormService contactFormService;

    public ResponseEntity<String> submitContactForm(@Valid @RequestBody ContactFormDTO contactFormDTO) {
        contactFormService.saveContactForm(contactFormDTO);
        return ResponseEntity.ok("Message sent");
    }
}
