package com.tinqin.estate.api.model.contractByNumber;

import com.tinqin.estate.api.base.OperationOutput;
import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class ContractByNumberResponse implements OperationOutput {
    public List<ContractModel> contracts;
}
