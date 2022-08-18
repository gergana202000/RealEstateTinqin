package com.tinqin.estate.domain.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "type_estate")
@Getter
@Setter
public class TypeEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estateTypeId;
    @OneToMany(mappedBy = "typeEstate")
    private Set<Estate> estates;

    public TypeEstate(){}

    public TypeEstate(Set<Estate> estates) {
        this.estates = estates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeEstate that = (TypeEstate) o;
        return Objects.equals(estateTypeId, that.estateTypeId) && Objects.equals(estates, that.estates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estateTypeId, estates);
    }
}
