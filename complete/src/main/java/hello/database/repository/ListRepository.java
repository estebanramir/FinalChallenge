package hello.database.repository;

import hello.database.entities.ListEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ListRepository extends CrudRepository<ListEntity, Long> {
    List<ListEntity> findAll();
    List<ListEntity> findByIdAccount(Long idAccount);
    List<ListEntity> findByIdSerie(Long idSerie);

    List<ListEntity> findByIdAccountAndFavorito(Long idAccount, Boolean favorito);

}
