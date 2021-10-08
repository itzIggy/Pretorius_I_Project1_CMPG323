package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository accountTransactionRepository;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository){
        this.accountTransactionRepository =accountTransactionRepository;
    }

    @Override
    public List<AccountTransactionDto> getAllAccountTransactions() {
        List<AccountTransactionDto> accountTransactions = new ArrayList<>();
        try {
            for (AccountTransaction accountTransaction : accountTransactionRepository.findAll()) {
                accountTransactions.add(new AccountTransactionDto(accountTransaction));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from DB!");
        }

        return accountTransactions;
    }

    /*public AccountTransactionDto getAccountTransactionByMemberID(Long memberID) {
        try{
            AccountTransaction accountTransaction = accountTransactionRepository.getAccountTransactionByMemberID(memberID);
            return new AccountTransactionDto(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from DB!");
        }
    }*/

    @Override
    public AccountTransactionDto createTransaction(AccountTransactionDto accountTransactionDto) {
        try{
            AccountTransaction accountTransaction = accountTransactionRepository.save(accountTransactionDto.getAccountTransaction());
            return new AccountTransactionDto(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to DB");
        }
    }
}
