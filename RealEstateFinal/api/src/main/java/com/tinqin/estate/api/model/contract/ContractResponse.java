package com.tinqin.estate.api.model.contract;

import lombok.*;

import java.time.LocalDate;
@Builder
@Getter
@Setter(AccessLevel.PRIVATE)

public class ContractResponse {
    private String contract;
    private Integer number;
    private Double price;
    private LocalDate date;

}
