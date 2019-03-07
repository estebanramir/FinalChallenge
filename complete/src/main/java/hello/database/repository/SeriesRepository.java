package hello.database.repository;

import hello.database.entities.SeriesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SeriesRepository extends CrudRepository<SeriesEntity, Long> {
        List<SeriesEntity> findAll();
        List<SeriesEntity> findByAgeRatinkg(String ageRating);
        List<SeriesEntity> findByAgeRatinkgAndShowType(String ageRating, String showType);

        }
