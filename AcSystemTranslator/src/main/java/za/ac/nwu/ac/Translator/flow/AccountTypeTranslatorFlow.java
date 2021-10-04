package za.ac.nwu.ac.Translator.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.Translator.AccountTypeTranslator;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorFlow implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorFlow(AccountTypeRepository accountTypeRepository){
        this.accountTypeRepository =accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        List<AccountTypeDto> accountTypes = new ArrayList<>();
        try {
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypes.add(new AccountTypeDto(accountType));
            }
       }catch (Exception e){
            throw new RuntimeException("Unable to read from DB!");
        }

        return accountTypes;
    }

}
