package com.bbva.servicioconversiondivisas.dtos;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ConvertirDivisasRequest {

    @NotNull(message = "El monto no puede ser nulo")
    @Positive(message = "El monto debe ser positivo")
	private BigDecimal monto;
	
	@NotNull(message = "La moneda de origen no puede ser nula")
	private String monedaOrigen;
	
	@NotNull(message = "La moneda de destino no puede ser nula")
	private String monedaDestino;

	public ConvertirDivisasRequest(BigDecimal monto, String monedaOrigen, String monedaDestino) {
		this.monto = monto;
		this.monedaOrigen = monedaOrigen;
		this.monedaDestino = monedaDestino;
	}

	public ConvertirDivisasRequest() {
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

}
