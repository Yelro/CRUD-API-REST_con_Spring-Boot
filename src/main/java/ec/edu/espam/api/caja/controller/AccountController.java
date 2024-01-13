package ec.edu.espam.api.caja.controller;

import ec.edu.espam.api.caja.domain.Account;
import ec.edu.espam.api.caja.service.ServiceAccount;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/accounts")

public class AccountController {
    private final ServiceAccount accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(accountService.getAll());
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody @Valid Account account) {
        return new ResponseEntity<>(accountService.save(account), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public Account update(@RequestBody Account account, @PathVariable Long id){
        account.setId(id);
        return accountService.modifyAccount(account);
    }
}
