package com.tinqin.estate.api.operation;

import com.tinqin.estate.api.base.OperationProcessor;
import com.tinqin.estate.api.model.estate.EstateRequest;
import com.tinqin.estate.api.model.estate.EstateResponse;
import com.tinqin.estate.api.model.estateByAddress.EstateByAddressRequest;
import com.tinqin.estate.api.model.estateByAddress.EstateByAddressResponse;

public interface EstateByAddressProcessor extends OperationProcessor<EstateByAddressRequest, EstateByAddressResponse> {
}
