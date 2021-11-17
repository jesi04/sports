package hu.sports.service;

import hu.sports.domain.Athlete;
import hu.sports.repositories.AthleteRepository;
import hu.sports.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AthleteService {
    @Autowired
    private AthleteRepository repository;
    @Autowired
    private SportRepository sportRepository;


    public List<Athlete> getAthletes() {
        return repository.findAllByOrderByName();
    }

    private boolean isUnique(String name) {
        List<Athlete> athletes = repository.findAll();
        for (Athlete athlete: athletes) {
            if(athlete.getName().equals(name))
                return false;
        }
        return true;
    }

    public Athlete postAthletes(Athlete athlete) {
        if(isUnique(athlete.getName()))
            return repository.save(athlete);
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    public Athlete putAthlete(int id, Athlete athlete) {
        Optional<Athlete> optionalAthlete = repository.findById(id);
        if(optionalAthlete.isPresent()){
            athlete.setId(id);
            return repository.save(athlete);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
