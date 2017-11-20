package starter.external;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import starter.httpclient.AvengersHttpClient;
import starter.models.Avenger;
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

    @HystrixCommand(
            fallbackMethod = "fetchAvengerByIdFallBack",
            groupKey="Avengers",
            commandKey = "fetchAvengerById"
    )
    public Avenger fetchAvengerById(int id) {
        String getAvengerByIdUrl = String.format("%s/avengers?id=%s", BASE_URL, id);
        RequestEntity requestEntity = new RequestEntity(null, HttpMethod.GET, URI.create(getAvengerByIdUrl));

        ResponseEntity<Avenger> responseEntity = avengersHttpClient.sendRequest(requestEntity, Avenger.class);

        return responseEntity.getBody();
    }

    @HystrixCommand(
            fallbackMethod = "fetchAllAvengersFallBack",
            groupKey = "Avengers",
            commandKey = "fetchAllAvengers"
    )
    public Avengers fetchAllAvengers() {
        String getAvengersUrl = String.format("%s/avengers/all", BASE_URL);
        RequestEntity requestEntity = new RequestEntity(null, HttpMethod.GET, URI.create(getAvengersUrl));

        ResponseEntity<Avengers> responseEntity = avengersHttpClient.sendRequest(requestEntity, Avengers.class);

        return responseEntity.getBody();
    }

    public Avenger fetchAvengerByIdFallBack(int id) {
        return null;
    }

    public Avengers fetchAllAvengersFallBack() {
        return null;
    }
}
