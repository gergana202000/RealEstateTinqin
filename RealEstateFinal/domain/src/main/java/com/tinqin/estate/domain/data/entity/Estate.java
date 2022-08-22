package com.tinqin.estate.domain.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estate")
@Getter
@Setter

public class Estate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estateId;
    private String estateName;
    private Double price;
    private Double size;
    private String address;
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_service_id")
    private TypeService typeService;

    @ManyToOne
    @JoinColumn(name = "additional_id")
    private Additional additional;

    @ManyToOne
    @JoinColumn(name = "type_estate_id")
    private TypeEstate typeEstate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "estate")
    private SellEstate sellEstate;

    public Estate(){}

    public Estate(Double price, Double size, String address, String description, TypeService typeService, Additional additional, TypeEstate typeEstate, User user) {
        this.price = price;
        this.size = size;
        this.address = address;
        this.description = description;
        this.typeService = typeService;
        this.additional = additional;
        this.typeEstate = typeEstate;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estate estate = (Estate) o;
        return Objects.equals(estateId, estate.estateId) && Objects.equals(price, estate.price) && Objects.equals(size, estate.size) && Objects.equals(address, estate.address) && Objects.equals(description, estate.description) && Objects.equals(typeService, estate.typeService) && Objects.equals(additional, estate.additional) && Objects.equals(typeEstate, estate.typeEstate) && Objects.equals(user, estate.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estateId, price, size, address, description, typeService, additional, typeEstate, user);
    }
}
