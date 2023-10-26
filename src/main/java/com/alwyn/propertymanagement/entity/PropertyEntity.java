package com.alwyn.propertymanagement.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PROPERTY_TITLE")
    private String title;
    private String description;
    private Double price;
    private String address;
    
    @ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY => to fetch the property data excluding user data
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userEntity;
}
