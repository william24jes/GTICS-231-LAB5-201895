package com.example.gtics231lab5201895.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="locations")
public class Location {
    @Id
    @Column(name = "location_id", nullable = false)
    private int location_id;

    private String street_address;
    private String postal_code;
    @Column(nullable = false)
    private String city;

    private String state_province;
    private String country_id;
}
