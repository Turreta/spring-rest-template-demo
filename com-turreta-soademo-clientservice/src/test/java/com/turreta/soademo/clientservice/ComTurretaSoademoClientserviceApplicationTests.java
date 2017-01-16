package com.turreta.soademo.clientservice;

import com.turreta.soademo.common.dto.AppConfigDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.junit.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComTurretaSoademoClientserviceApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void test01() {
		RestTemplate restTemplate = new RestTemplate();

		AppConfigDTO dto = new AppConfigDTO();
		dto.setApplicationName("app-1");
		HttpEntity<AppConfigDTO> request = new HttpEntity<>(dto);

		String fooResourceUrl
				= "http://localhost:8080/get-config-by-name";
		ResponseEntity<AppConfigDTO> response
				= restTemplate.postForEntity(fooResourceUrl,request, AppConfigDTO.class);

		Assert.assertTrue(response.getStatusCode()==HttpStatus.OK);
	}


}
