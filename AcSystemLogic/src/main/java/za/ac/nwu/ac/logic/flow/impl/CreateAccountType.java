package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.Translator.AccountTypeTranslator;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountType implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountType(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto){
       if(null == accountTypeDto.getCreationDate()){
            accountTypeDto.setCreationDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountTypeDto);
    }
}
