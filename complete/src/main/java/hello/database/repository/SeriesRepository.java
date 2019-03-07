package hello.database.repository;

import hello.database.entities.SeriesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SeriesRepository extends CrudRepository<SeriesEntity, Long> {
        List<SeriesEntity> findAll();
        List<SeriesEntity> findByAgeRatingAndShowType(String ageRating, String showType );
//        List<SeriesEntity> findByAgeRating(String ageRating);
//        List<SeriesEntity> findByStatus(String ageRating);
//        List<SeriesEntity> findByShowType(String ageRating);
//        List<SeriesEntity> findByAgeRatingAndStatus(String ageRating);
//        List<SeriesEntity> findByStatusAndShowType(String ageRating);
//        List<SeriesEntity> findByShowTypeAndStatus(String ageRating);
//        List<SeriesEntity> findByAgeRatingAndStatusAndShowType(String ageRating, String status, String showType);

        }
