package com.shiva.currency.calculation.currencycalculationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class CurrencyConfiguration {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IClientConfig config;

	@Bean
	public IPing ribbonPing(IClientConfig config) {
		logger.info(" IClientConfig -> {} ", config.toString());
		return new PingUrl();
	}

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		logger.info(" IClientConfig -> {} ", config.toString());
		return new AvailabilityFilteringRule();
	}

}
