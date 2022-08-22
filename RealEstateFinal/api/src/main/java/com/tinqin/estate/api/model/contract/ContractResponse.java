package com.tinqin.estate.api.model.contract;

import com.tinqin.estate.api.base.OperationInput;
import com.tinqin.estate.api.base.OperationOutput;
import lombok.*;

import java.time.LocalDate;
@Builder
@Getter
@Setter(AccessLevel.PRIVATE)

public class ContractResponse implements OperationOutput {
    private String contract;
    private Double price;
    private LocalDate date;

}
