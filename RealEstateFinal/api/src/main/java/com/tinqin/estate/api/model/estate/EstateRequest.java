package com.tinqin.estate.api.model.estate;

import com.tinqin.estate.api.base.OperationInput;
import lombok.*;
@Builder
@Getter
@Setter(AccessLevel.PRIVATE)

public class EstateRequest implements OperationInput {
   /* private Long estateID;*/
    private String estateName;

}
