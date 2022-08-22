package com.tinqin.estate.api.model.sellEstate;

import com.tinqin.estate.api.base.OperationOutput;

import java.time.LocalDate;
import java.util.List;

public class SellResponse implements OperationOutput {
    private Double price;
    private Double size;
    private LocalDate date;

}
