package com.tinqin.estate.domain.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contract")
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;
    private Integer number;
    private String contractName;
    private Double price;
    private LocalDate dateOFConclusion;


    @ManyToOne
    @JoinColumn(name = "type_contract_id")
    private TypeContract typeContract;

    /*@ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;*/

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "contract")
    private SellEstate sellEstate;


    public Contract(){}

    public Contract(Integer number, Double price, LocalDate dateOFConclusion, TypeContract typeContract/*, Contract contract*/) {
        this.number = number;
        this.price = price;
        this.dateOFConclusion = dateOFConclusion;
        this.typeContract = typeContract;
        /*this.contract = contract;*/
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract1 = (Contract) o;
        return Objects.equals(contractId, contract1.contractId) && Objects.equals(number, contract1.number) && Objects.equals(price, contract1.price) && Objects.equals(dateOFConclusion, contract1.dateOFConclusion) && Objects.equals(typeContract, contract1.typeContract) /*&& Objects.equals(contract, contract1.contract)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId, number, price, dateOFConclusion, typeContract/*, contract*/);
    }
}
