package dev.hstr0100.dio.iss.repository;

import dev.hstr0100.dio.iss.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gabriel / hstr0100 / vertx010
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findFirstByName(String name);
}
