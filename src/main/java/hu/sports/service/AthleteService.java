package hu.sports.service;

import hu.sports.domain.Athlete;
import hu.sports.repositories.AthleteRepository;
import hu.sports.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteService {
    @Autowired
    private AthleteRepository repository;
    @Autowired
    private SportRepository sportRepository;


    public List<Athlete> getAthletes() {
        return repository.findAllByOrderByName();
    }

    public List<Athlete> postAthletes() {
        return null;
    }
}
