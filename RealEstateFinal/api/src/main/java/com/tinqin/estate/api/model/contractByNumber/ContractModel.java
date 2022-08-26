package com.tinqin.estate.api.model.contractByNumber;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class ContractModel {
    private String contractName;
    private Double price;
    private LocalDate data;
}
