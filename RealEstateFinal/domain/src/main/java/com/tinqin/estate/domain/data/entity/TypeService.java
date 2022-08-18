package com.tinqin.estate.domain.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "type_service")
@Getter
@Setter
public class TypeService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeServiceId;
    @OneToMany(mappedBy = "typeService")
    private Set<Estate> estates;


    public TypeService(){}

    public TypeService(Set<Estate> estates) {
        this.estates = estates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeService that = (TypeService) o;
        return Objects.equals(typeServiceId, that.typeServiceId) && Objects.equals(estates, that.estates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeServiceId, estates);
    }
}