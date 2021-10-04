package za.ac.nwu.ac.Translator.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.Translator.AccountTransactionTranslator;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorFlow implements AccountTransactionTranslator {

    private final AccountTransactionRepo accountTransactionRepo;

    @Autowired
    public AccountTransactionTranslatorFlow(AccountTransactionRepo accountTransactionRepo){
        this.accountTransactionRepo =accountTransactionRepo;
    }

    @Override
    public List<AccountTransactionDto> getAccountTransactions() {
        List<AccountTransactionDto> accountTransactions = new ArrayList<>();
        try {
            for (AccountTransaction accountTransaction : accountTransactionRepo.findAll()) {
                accountTransactions.add(new AccountTransactionDto(accountTransaction));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from DB!");
        }

        return accountTransactions;
    }
}
