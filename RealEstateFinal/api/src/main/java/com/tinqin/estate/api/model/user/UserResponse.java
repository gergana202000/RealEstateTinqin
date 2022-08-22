package com.tinqin.estate.api.model.user;

import com.tinqin.estate.api.base.OperationOutput;
import com.tinqin.estate.api.base.OperationProcessor;
import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements OperationOutput {
    private String name;
    private String lastName;
    private String phone;
    private String email;
}
