package com.derrick.LastPricesList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class LastPricesListApplication {
	private static final Logger log = LoggerFactory.getLogger(LastPricesListApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(LastPricesListApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			List objects = new ArrayList();
			objects.add(new Bitcoin());
			objects.add(new Ticker());
			objects.add(new Market());
				objects = restTemplate.getForObject("https://api.n.exchange/en/api/v1/price/BTCLTC/latest/?market_code=nex", List.class);

				log.info(objects.toString());

		};
	}
}

