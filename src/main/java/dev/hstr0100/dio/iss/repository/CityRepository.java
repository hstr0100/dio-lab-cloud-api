package dev.hstr0100.dio.iss.repository;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
import dev.hstr0100.dio.iss.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findFirstByName(String name);
}
