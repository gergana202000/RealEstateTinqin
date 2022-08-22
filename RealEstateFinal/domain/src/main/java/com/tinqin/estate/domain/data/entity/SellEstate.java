package com.tinqin.estate.domain.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "sell_estate")
public class SellEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellID;
    @OneToOne
    @JoinColumn(name = "estate_id")
    private Estate estate;

    @OneToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
}
