package com.tinqin.estate.api.model.soldEstateByCity;

import com.tinqin.estate.api.base.OperationInput;
import com.tinqin.estate.api.base.OperationOutput;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)

public class SoldEstateByCityResponse implements OperationOutput {
    private String userFirstName;
    private String userLastName;
    private String estateName;
    private Double price;
    private Double size;

}
