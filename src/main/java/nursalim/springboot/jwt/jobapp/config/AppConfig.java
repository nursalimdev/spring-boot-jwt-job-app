package nursalim.springboot.jwt.jobapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
//		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//		factory.setConnectTimeout(300000);
//		factory.setReadTimeout(3000);
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        return new RestTemplate(factory);
    }
}
