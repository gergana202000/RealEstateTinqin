package com.tinqin.estate.api.model.estateByAddress;

import com.tinqin.estate.api.base.OperationInput;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class EstateByAddressRequest implements OperationInput {
    private String address;
}
