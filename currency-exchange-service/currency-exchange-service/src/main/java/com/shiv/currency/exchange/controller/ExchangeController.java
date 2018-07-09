package com.shiv.currency.exchange.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shiv.microservices.currencyexchangeservice.ExchangeValue;
import com.shiv.microservices.currencyexchangeservice.ExchangeValueRepository;

@RestController
public class ExchangeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExchangeValueRepository repository;

	@Autowired
	private Environment enveronment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		logger.info(" from vale -> {} ", from);
		logger.info(" to vale -> {} ", to);
		ExchangeValue value = repository.findByFromAndTo(from, to);
		value.setPort(Integer.parseInt(enveronment.getProperty("local.server.port")));
		logger.info("Exchange value -> {} " + value);
		return value;
	}

}
