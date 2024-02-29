package luis.cavalcante.sistemabancario.repositories;

import luis.cavalcante.sistemabancario.entity.account.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
}
