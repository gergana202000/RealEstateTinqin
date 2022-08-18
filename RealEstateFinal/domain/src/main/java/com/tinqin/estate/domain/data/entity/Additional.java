package com.tinqin.estate.domain.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "additional")
@Getter
@Setter
public class Additional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long additionalId;
    @OneToMany(mappedBy = "additional")
    private Set<Estate> additional;

    public Additional(){}

    public Additional(Set<Estate> additional) {
        this.additional = additional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Additional that = (Additional) o;
        return Objects.equals(additionalId, that.additionalId) && Objects.equals(additional, that.additional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalId, additional);
    }
}
