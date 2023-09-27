package br.com.gustavo.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Cambio {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionFactior;
	private BigDecimal convertedValue;
	private String environment;
	
	public Cambio() {
	}
	
	public Cambio(Long id, String from, String to, BigDecimal conversionFactior, BigDecimal convertedValue,
			String environment) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactior = conversionFactior;
		this.convertedValue = convertedValue;
		this.environment = environment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public BigDecimal getConversionFactior() {
		return conversionFactior;
	}

	public void setConversionFactior(BigDecimal conversionFactior) {
		this.conversionFactior = conversionFactior;
	}

	public BigDecimal getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(BigDecimal convertedValue) {
		this.convertedValue = convertedValue;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cambio other = (Cambio) obj;
		return Objects.equals(id, other.id);
	}
	

}
