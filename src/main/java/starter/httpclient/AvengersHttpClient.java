package starter.httpclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ashishpundalik on 08/11/2017.
 */

@Component
public class AvengersHttpClient {
    @Autowired
    private RestTemplate restTemplate;

    public <T> ResponseEntity<T> sendRequest(RequestEntity<?> requestEntity, Class<T> responseType) {
        return restTemplate.exchange(requestEntity, responseType);
    }
}
