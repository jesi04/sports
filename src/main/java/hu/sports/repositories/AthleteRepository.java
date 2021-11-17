package hu.sports.repositories;

import hu.sports.domain.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
    public List<Athlete> findAllByOrderByName();
}
