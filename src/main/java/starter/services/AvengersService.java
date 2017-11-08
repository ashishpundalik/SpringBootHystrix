package starter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import starter.external.ExternalService;
import starter.models.Avenger;
import starter.models.Avengers;

import java.util.List;

/**
 * Created by ashishpundalik on 24/10/2017.
 */
@Component
public class AvengersService {

    @Autowired
    private ExternalService externalService;

    public Avengers getAvengers() {
        return externalService.fetchAvengers();
    }
}
