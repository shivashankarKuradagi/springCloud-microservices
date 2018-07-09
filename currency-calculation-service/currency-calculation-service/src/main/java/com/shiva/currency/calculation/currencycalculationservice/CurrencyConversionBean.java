package com.shiva.currency.calculation.currencycalculationservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	
	
	private int id;
	private String from;
	private String to;
	private BigDecimal conversionRate;
	private BigDecimal	quantity;
	private BigDecimal totalCalculatedValue;
	private int port;
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "CurrencyConversionBean [id=" + id + ", from=" + from + ", to=" + to + ", conversionRate="
				+ conversionRate + ", quantity=" + quantity + ", totalCalculatedValue=" + totalCalculatedValue
				+ ", port=" + port + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(BigDecimal conversionMultply) {
		this.conversionRate = conversionMultply;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedValue() {
		return totalCalculatedValue;
	}
	public void setTotalCalculatedValue(BigDecimal totalCalculatedValue) {
		this.totalCalculatedValue = totalCalculatedValue;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public CurrencyConversionBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurrencyConversionBean(int id, String from, String to, BigDecimal conversionRate, BigDecimal quantity,
			BigDecimal totalCalculatedValue, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
		this.quantity = quantity;
		this.totalCalculatedValue = totalCalculatedValue;
		this.port = port;
	}
	
	

}
