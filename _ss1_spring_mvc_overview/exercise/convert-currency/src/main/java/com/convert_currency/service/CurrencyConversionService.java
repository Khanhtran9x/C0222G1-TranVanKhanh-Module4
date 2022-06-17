package com.convert_currency.service;

public class CurrencyConversionService implements ICurrencyConversionService{
    public double convertUsdToVnd(double usd){
        return usd * 23000;
    }
}
