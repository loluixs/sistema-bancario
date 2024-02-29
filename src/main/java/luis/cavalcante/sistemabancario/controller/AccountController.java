package luis.cavalcante.sistemabancario.controller;

import luis.cavalcante.sistemabancario.entity.account.Account;
import luis.cavalcante.sistemabancario.entity.account.AccountDTO;
import luis.cavalcante.sistemabancario.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")

public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody AccountDTO accountDTO) {
        Account newAccount = this.service.createAccount(accountDTO);
        return ResponseEntity.ok().body(newAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        List<Account> accounts = this.service.getAll();
        return ResponseEntity.ok().body(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable("id") String id) {
        Account newAccount = this.service.findById(id);
        return ResponseEntity.ok().body(newAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> delete(@PathVariable("id") String id) {
        this.service.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}
