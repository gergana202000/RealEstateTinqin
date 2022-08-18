package com.tinqin.estate.domain.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "type_contract")
@Getter
@Setter
public class TypeContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeContractId;
    @OneToMany(mappedBy = "typeContract")
    private Set<Contract> contracts;

    public TypeContract(){}

    public TypeContract(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeContract that = (TypeContract) o;
        return Objects.equals(typeContractId, that.typeContractId) && Objects.equals(contracts, that.contracts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeContractId, contracts);
    }
}
