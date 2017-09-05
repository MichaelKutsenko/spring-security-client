package security.client.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Mocart on 05-Sep-17.
 */
@Component
public class RestTemplateFactory {

    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new AuthResponseHandler());
        return restTemplate;
    }
}
