package com.propelio.PropelioLandingPage.Repository;

import com.propelio.PropelioLandingPage.Entity.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormRepository extends JpaRepository<ContactForm, Integer> {

}
