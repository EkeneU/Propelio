package com.propelio.PropertyTechSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyListingController {
    @Autowired
    private PropertyListingService service;

    @GetMapping("/property")
    public List<PropertyListing> searchProperties (@RequestParam(required = false) String type,
                                                   @RequestParam(required = false) String location,
                                                    @RequestParam(required = false) Boolean isAvailable) {
        return service.searchProperty(type, location, isAvailable);
    }
}
