package hu.sports.controller;

import hu.sports.domain.Athlete;
import hu.sports.service.AthleteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Athlete> postAthletes(){
        return service.postAthletes();
    }

}
