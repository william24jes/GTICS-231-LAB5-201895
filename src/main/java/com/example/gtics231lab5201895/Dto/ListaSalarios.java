package com.example.gtics231lab5201895.Dto;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public interface ListaSalarios {
    String getJob_title();
    BigDecimal getMax_salary();
    BigDecimal getMin_salary();
    BigDecimal getTotal_salary();
    BigDecimal getAvg_salary();
}
