package br.com.sample.demo.integration;

import br.com.sample.demo.data.BitcoinRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(name = "integrationClient", url = "https://api.coincap.io/v2")
public interface Integration {

    @GetMapping("/rates/bitcoin")
    BitcoinRate getBitcoinRate();

}
