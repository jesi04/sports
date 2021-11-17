package hu.sports.controller;

import hu.sports.domain.Athlete;
import hu.sports.service.AthleteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AthleteController {

    private final AthleteService service;

    public AthleteController(AthleteService service) {
        this.service = service;
    }

    @GetMapping("/athletes")
    public List<Athlete> getAthletes(){
        return service.getAthletes();
    }

    @PostMapping("/athletes")
    @ResponseStatus(HttpStatus.CREATED)
    public Athlete postAthletes(@RequestBody Athlete athlete){
        return service.postAthletes(athlete);
    }

    @PutMapping("/athletes/{id}")
    public Athlete putAthlete(@PathVariable("id") int id, @RequestBody Athlete athlete){
        return service.putAthlete(id, athlete);
    }



}
