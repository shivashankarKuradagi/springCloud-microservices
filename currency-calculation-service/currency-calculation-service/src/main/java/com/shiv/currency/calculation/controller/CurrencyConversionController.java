package com.shiv.currency.calculation.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shiva.currency.calculation.currencycalculationservice.CurrencyConversionBean;
import com.shiva.currency.calculation.currencycalculationservice.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@RequestMapping("/currency-service/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean calculateConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, Object> uriVariables = new HashMap<>();
		logger.info(" from vale -> {} ", from);
		logger.info(" to vale -> {} ", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000//currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);
		Object obj = responseEntity.getBody();
		
		CurrencyConversionBean response = responseEntity.getBody();
		
		return getCurrencyConvernsebean(from, to, quantity, response);
	}
	
	
	
	@RequestMapping("/currency-service-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean calculateConversionWithFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		logger.info(" from vale -> {} ", from);
		logger.info(" to vale -> {} ", to);
		CurrencyConversionBean bean =proxy.retriveExchangeValue(from, to);
		logger.info(" CurrencyConversionBean -> {} ", bean.toString());
		return getCurrencyConvernsebean(from, to, quantity, bean);
	}



	private CurrencyConversionBean getCurrencyConvernsebean(String from, String to, BigDecimal quantity,
			CurrencyConversionBean bean) {
		return new CurrencyConversionBean(bean.getId(), from, to,
				bean.getConversionRate(), quantity,
				quantity.multiply(bean.getConversionRate()), bean.getPort());
	}

}
