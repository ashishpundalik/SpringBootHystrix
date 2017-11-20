package starter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import starter.models.Avenger;
import starter.models.Avengers;
import starter.services.AvengersService;

import java.util.concurrent.ExecutionException;

/**
 * Created by ashishpundalik on 13/06/2017.
 */

@RestController
public class AvengersController {

    @Autowired
    private AvengersService avengersService;

    @RequestMapping(value = "/avengers", method = RequestMethod.GET)
    public ResponseEntity<Avenger> avengers(@RequestParam("id") int id) throws ExecutionException, InterruptedException {
        Avenger avenger = avengersService.getAvengerById(id);
        return ResponseEntity.ok(avenger);
    }

    @RequestMapping(value = "/avengers/all", method = RequestMethod.GET)
    public ResponseEntity<Avengers> allAvengers() throws ExecutionException, InterruptedException {
        Avengers avengers = avengersService.getAllAvengers();
        return ResponseEntity.ok(avengers);
    }
}
