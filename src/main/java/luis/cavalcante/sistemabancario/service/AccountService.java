package luis.cavalcante.sistemabancario.service;

import luis.cavalcante.sistemabancario.entity.account.Account;
import luis.cavalcante.sistemabancario.entity.account.AccountDTO;
import luis.cavalcante.sistemabancario.entity.account.enums.AccountStatus;
import luis.cavalcante.sistemabancario.entity.account.exceptions.AccountNotFoundException;
import luis.cavalcante.sistemabancario.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account createAccount(AccountDTO accountDTO) {
        Account newAccount = new Account(accountDTO);
        newAccount.setAccountNumber(accountNumber());
        this.repository.save(newAccount);
        return newAccount;
    }

    public List<Account> getAll() {
        return this.repository.findAll();
    }

    public Account findById(String Id) {
        Account account = this.repository.findById(Id)
                .orElseThrow(AccountNotFoundException::new);
        return account;
    }

    public Account deleteAccount(String id) {
        Account account = this.repository.findById(id)
                .orElseThrow(AccountNotFoundException::new);
        account.setAccountStatus(AccountStatus.BLOCKED);
        this.repository.save(account);
        return account;
    }

    private Long accountNumber() {
        var intSize = this.repository.findAll().size();
        return (long) intSize + 1;
    }
}
