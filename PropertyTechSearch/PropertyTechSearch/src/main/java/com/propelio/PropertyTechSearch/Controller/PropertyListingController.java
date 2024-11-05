package com.propelio.PropertyTechSearch.Controller;

import com.propelio.PropertyTechSearch.Entity.PropertyListing;
import com.propelio.PropertyTechSearch.Service.PropertyListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("propertytechsearch/api/properties")
public class PropertyListingController {
    public static final String POST_MAPPING_ADD_PROPERTY="/a/property";
    public static final String PUT_MAPPING_UPDATE_PROPERTY="/u/property";
    public static final String DELETE_MAPPING_DELETE_PROPERTY="/d/property";
    @Autowired
    private PropertyListingService service;

    @GetMapping("/property")
    public List<PropertyListing> searchProperties (@RequestParam(required = false) String type,
                                                   @RequestParam(required = false) String location,
                                                   @RequestParam(required = false) Boolean isAvailable) {
        return service.searchProperty(type, location, isAvailable);
    }
    @PostMapping(POST_MAPPING_ADD_PROPERTY)
    public PropertyListing addProperty(@RequestBody PropertyListing listing) {
        listing.setId(0);
        return service.save(listing);

    }
    @PutMapping(PUT_MAPPING_UPDATE_PROPERTY)
    public PropertyListing updateProperty(@RequestBody PropertyListing listing) {
            return service.save(listing);

    }
    @DeleteMapping(DELETE_MAPPING_DELETE_PROPERTY)
    public String deleteProperty(@PathVariable int property_id) {
        PropertyListing listing = service.findById(property_id);
        if (listing==null) {
            throw new RuntimeException("Id is not on the database" + property_id);
        }
        else {
            service.findById(property_id);
            return "Property with ID " + property_id + "has been deleted";
        }
    }
}
