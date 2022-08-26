package com.tinqin.estate.api.operation;

import com.tinqin.estate.api.base.OperationProcessor;
import com.tinqin.estate.api.model.user.UserRequest;
import com.tinqin.estate.api.model.user.UserResponse;
import com.tinqin.estate.api.model.userByUsername.UserByUsernameRequest;
import com.tinqin.estate.api.model.userByUsername.UserByUsernameResponse;

public interface UserProcessor extends OperationProcessor<UserByUsernameRequest, UserByUsernameResponse> {
}
