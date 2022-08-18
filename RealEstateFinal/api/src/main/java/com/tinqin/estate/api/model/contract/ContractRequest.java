package com.tinqin.estate.api.model.contract;

import com.tinqin.estate.api.base.OperationInput;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ContractRequest implements OperationInput {
    private Long contractID;
}
