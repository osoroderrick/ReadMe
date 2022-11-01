package com.derrick.LastPricesList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(LastPricesListApplication.class);

    @Scheduled(fixedRate = 3000)
    public void intervals() {
        RestTemplate restTemplate = new RestTemplate();
        List objects = new ArrayList();
        objects.add(new Bitcoin());
        objects.add(new Ticker());
        objects.add(new Market());

            objects = restTemplate.getForObject("https://api.n.exchange/en/api/v1/price/BTCLTC/latest/?market_code=nex", List.class);

            log.info(objects.toString());
        }
    }
