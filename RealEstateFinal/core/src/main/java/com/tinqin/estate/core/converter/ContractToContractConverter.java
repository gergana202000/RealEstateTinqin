package com.tinqin.estate.core.converter;

import com.tinqin.estate.api.model.contract.ContractResponse;
import com.tinqin.estate.domain.data.entity.Contract;
import org.springframework.core.convert.converter.Converter;

public class ContractToContractConverter implements Converter<Contract, ContractResponse> {

    @Override
    public ContractResponse convert(Contract source) {
        return ContractResponse.builder()
                .contractName(source.getContractName())
                .price(source.getPrice())
                .date(source.getDateOFConclusion())
                .build();
    }
}
