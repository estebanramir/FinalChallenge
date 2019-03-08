package hello.database.repository;

import hello.database.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    List<AccountEntity> findAll();
    AccountEntity findOneById(Long id);
    AccountEntity findOneByUserName(String userName);


}
