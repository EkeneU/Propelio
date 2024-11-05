package com.propelio.PropertyTechSearch.Controller;

import com.propelio.PropertyTechSearch.Entity.PropertyUser;
import com.propelio.PropertyTechSearch.Service.PropertyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class PropertyUserController {
    @Autowired
    private PropertyUserService service;
    @GetMapping("/search")
    public List<PropertyUser> searchUsers (@RequestParam(required = false) String first_name,
                                           @RequestParam(required = false) Integer income_bracket) {

        return service.searchusers(first_name, income_bracket);

    }
}
