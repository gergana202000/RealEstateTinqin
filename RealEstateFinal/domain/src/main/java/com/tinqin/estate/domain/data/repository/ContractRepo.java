package com.tinqin.estate.domain.data.repository;

import com.tinqin.estate.domain.data.entity.Contract;
import com.tinqin.estate.domain.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContractRepo extends JpaRepository<Contract, Long> {
    Optional<Contract> findContractByNumber(Integer number);
}
