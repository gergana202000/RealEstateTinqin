package com.tinqin.estate.api.model.userByUsername;

import com.tinqin.estate.api.base.OperationOutput;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class UserByUsernameResponse implements OperationOutput {
    public List<UserModel> users;
}
