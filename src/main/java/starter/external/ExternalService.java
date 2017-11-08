package starter.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import starter.httpclient.AvengersHttpClient;
import starter.models.Avengers;

import java.net.URI;

/**
 * Created by ashishpundalik on 24/10/2017.
 */
@Component
public class ExternalService {
    @Autowired
    private AvengersHttpClient avengersHttpClient;

    private static final String BASE_URL = "http://localhost:3100";

    public Avengers fetchAvengers() {
        String getAvengersUrl = String.format("%s/avengers", BASE_URL);
        RequestEntity requestEntity = new RequestEntity(null, HttpMethod.GET, URI.create(getAvengersUrl));

        ResponseEntity<Avengers> responseEntity = avengersHttpClient.sendRequest(requestEntity, Avengers.class);

        return responseEntity.getBody();
    }
}
