package hello.database.repository;

import hello.database.entities.ListEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ListRepository extends CrudRepository<ListEntity, Long> {
    List<ListEntity> findAll();
    List<ListEntity> findByIdAccount(Long idAccount);
    ListEntity findFirstByIdAccount(Long idAccount);
    List<ListEntity> findByIdSerie(Long idSerie);
    ListEntity findFirstByIdAccountAndIdSerie(Long idAccount, Long idSerie);
    ListEntity findFirstByIdAccountAndIdSerieAndFavorito(Long idAccount, Long idSerie, Boolean favorito);
    ListEntity findFirstByIdAccountAndIdSerieAndVisto(Long idAccount, Long idSerie, Boolean visto);
    ListEntity findFirstByIdAccountAndIdSerieAndPorVer(Long idAccount, Long idSerie, Boolean porVer);
    List<ListEntity> findByIdAccountAndFavorito(Long idAccount, Boolean favorito);
    List<ListEntity> findByIdAccountAndVisto(Long idAccount, Boolean visto);
    List<ListEntity> findByIdAccountAndPorVer(Long idAccount, Boolean porVer);

}
