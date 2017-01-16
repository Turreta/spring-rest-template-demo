package com.turreta.soademo.clientservice;

import com.turreta.soademo.common.dto.AppConfigDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by SANG018 on 1/16/2017.
 */
@RestController
public class ClientController {
    @RequestMapping("/get-config-from-config-server/{app-name}")
    public AppConfigDTO getRemoteConfig(@PathVariable("app-name") String appName) {

        RestTemplate restTemplate = new RestTemplate();

        AppConfigDTO dto = new AppConfigDTO();
        dto.setApplicationName(appName);
        HttpEntity<AppConfigDTO> request = new HttpEntity<>(dto);

        String fooResourceUrl
                = "http://localhost:8080/get-config-by-name";
        ResponseEntity<AppConfigDTO> response
                = restTemplate.postForEntity(fooResourceUrl,request, AppConfigDTO.class);

        return response.getBody();
    }
}
