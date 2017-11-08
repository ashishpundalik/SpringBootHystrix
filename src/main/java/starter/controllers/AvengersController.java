package starter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starter.models.Avenger;
import starter.models.Avengers;
import starter.services.AvengersService;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by ashishpundalik on 13/06/2017.
 */

@RestController
public class AvengersController {

    @Autowired
    private AvengersService avengersService;

    @RequestMapping("/avengers")
    public ResponseEntity<Avengers> avengers() throws ExecutionException, InterruptedException {
        Avengers avengers = avengersService.getAvengers();
        return ResponseEntity.ok(avengers);
    }
}
