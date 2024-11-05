package com.propelio.PropertyTechSecurity.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PropertySecurity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String email;
    private String user_password;

    @Enumerated(EnumType.STRING)
    private PropertyRole propertyRole;
}
