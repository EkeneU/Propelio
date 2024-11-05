package com.propelio.PropertyTechSearch.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@Entity
@Table(name = "property_listing")
public class PropertyListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String property_name;
    @NonNull
    private String location;
    @NonNull
    private String property_type;
    @NonNull
    private String price;
    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "_id")
    @JsonBackReference
    private PropertyUser propertyUser;
    @NonNull
    private Boolean is_available;
}
