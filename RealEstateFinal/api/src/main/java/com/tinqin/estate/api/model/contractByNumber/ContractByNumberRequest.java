package com.tinqin.estate.api.model.contractByNumber;

import com.tinqin.estate.api.base.OperationInput;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class ContractByNumberRequest implements OperationInput {
    private Integer number;
}
