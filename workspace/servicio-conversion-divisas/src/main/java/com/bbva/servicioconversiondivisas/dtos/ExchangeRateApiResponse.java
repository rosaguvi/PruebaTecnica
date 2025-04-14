package com.bbva.servicioconversiondivisas.dtos;

import java.math.BigDecimal;
import java.util.Map;

public class ExchangeRateApiResponse {

    private String base;
    private String timestamp;
    private String success;
    private String date;
    private Map<String, BigDecimal> rates;
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Map<String, BigDecimal> getRates() {
		return rates;
	}
	public void setRates(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}
    
}
