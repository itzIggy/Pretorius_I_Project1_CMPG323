package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component(value = "createAccountTransactionFlow")
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    public CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator){
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public AccountTransactionDto createTransaction(AccountTransactionDto accountTransactionDto){
        if(null == accountTransactionDto.getTransDate()){
            accountTransactionDto.setTransDate(LocalDate.now());
        }
        return accountTransactionTranslator.createTransaction(accountTransactionDto);
    }
}
