package com.tinqin.estate.api.model.userByUsername;

import com.tinqin.estate.api.base.OperationInput;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class UserByUsernameRequest implements OperationInput {
    private String username;
}
