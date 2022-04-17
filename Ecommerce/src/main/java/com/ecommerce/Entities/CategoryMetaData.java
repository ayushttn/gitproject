package com.ecommerce.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CategoryMetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "categoryMetaData")
    private Set<CategoryMetadataFieldValue> categoryMetadataFieldValues = new HashSet<>();
}
