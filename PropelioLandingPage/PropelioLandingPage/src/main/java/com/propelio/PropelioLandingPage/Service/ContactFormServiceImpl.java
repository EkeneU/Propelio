package com.propelio.PropelioLandingPage.Service;

import com.propelio.PropelioLandingPage.DTO.ContactFormDTO;
import com.propelio.PropelioLandingPage.Entity.ContactForm;
import com.propelio.PropelioLandingPage.Repository.ContactFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContactFormServiceImpl implements ContactFormService {
    @Autowired
    private ContactFormRepository contactFormRepository;
    @Override
    public List<ContactForm> findAll() {
        return contactFormRepository.findAll();
    }

    @Override
    public ContactForm saveContactForm(ContactFormDTO contactFormDTO) {
        ContactForm contactForm = new ContactForm();
        contactForm.setFirst_name(contactFormDTO.getFirst_name());
        contactForm.setLast_name(contactFormDTO.getLast_name());
        contactForm.setEmail(contactFormDTO.getEmail());
        contactForm.setMessage(contactFormDTO.getMessage());
        contactForm.setSubmittedDateAndTime(LocalDateTime.now());
        return contactForm;
    }

}
