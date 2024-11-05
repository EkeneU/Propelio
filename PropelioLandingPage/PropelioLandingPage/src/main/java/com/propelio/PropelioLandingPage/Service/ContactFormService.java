package com.propelio.PropelioLandingPage.Service;

import com.propelio.PropelioLandingPage.DTO.ContactFormDTO;
import com.propelio.PropelioLandingPage.Entity.ContactForm;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ContactFormService {
    List<ContactForm>findAll();
    ContactForm saveContactForm(ContactFormDTO contactForm);

}
