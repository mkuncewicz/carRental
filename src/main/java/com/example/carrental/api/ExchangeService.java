package com.example.carrental.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ExchangeService {

    private RestTemplate restTemplate = new RestTemplate();

    private static final String EXCHANGE_URL = "https://api.exchangerate.host/";

    public OpenExchangeDto getExchange(String cur1, String cur2, int amount) {
        return callGetMethod(EXCHANGE_URL+"convert?from={cur1}&to={cur2}&amount={amount}",
                OpenExchangeDto.class,
                cur1,cur2,amount);
    }

     private <T> T callGetMethod(String url,Class<T> responseType, Object...objects){
        return restTemplate.getForObject(url,responseType,objects);
    }
}
