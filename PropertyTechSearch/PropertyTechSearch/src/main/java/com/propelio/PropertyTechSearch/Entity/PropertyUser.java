package com.propelio.PropertyTechSearch.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "property_user")
public class PropertyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer _id;
    @NonNull
    private String first_name;
    @NonNull
    private String last_name;
    @NonNull
    private String sex;
    @NonNull
    private Integer income_bracket;
    @OneToMany(mappedBy = "propertyUser", cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonManagedReference
    private List<PropertyListing> listings;
}
