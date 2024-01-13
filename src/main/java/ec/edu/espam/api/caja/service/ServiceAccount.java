package ec.edu.espam.api.caja.service;

import ec.edu.espam.api.caja.domain.Account;
import java.util.List;
public interface ServiceAccount {
    List<Account> getAll();
    Account save(Account account);
    Account modifyAccount(Account account);
}
