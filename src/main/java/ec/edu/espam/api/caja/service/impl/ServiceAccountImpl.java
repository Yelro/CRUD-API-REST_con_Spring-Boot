package ec.edu.espam.api.caja.service.impl;

import ec.edu.espam.api.caja.domain.Account;
import ec.edu.espam.api.caja.repository.AccountRepository;
import ec.edu.espam.api.caja.service.ServiceAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ServiceAccountImpl implements ServiceAccount {

    private final AccountRepository accountRepository;
    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }
    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
    @Override
    public Account modifyAccount(Account account) {
        return accountRepository.save(account);
    }
}
