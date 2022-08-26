package com.tinqin.estate.api.model.estateByAddress;

import com.tinqin.estate.api.base.OperationOutput;
import com.tinqin.estate.api.model.estate.EstateResponse;
import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class EstateByAddressResponse implements OperationOutput {
    public List<EstateModel> estates;
}
