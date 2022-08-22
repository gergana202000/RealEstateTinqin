package com.tinqin.estate.api.model.estate;

import com.tinqin.estate.api.base.OperationOutput;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)


public class EstateResponse implements OperationOutput {
    private String estateName;
    private Double price;
    private Double size;

}
