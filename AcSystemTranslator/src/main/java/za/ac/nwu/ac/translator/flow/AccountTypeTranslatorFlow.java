package za.ac.nwu.ac.translator.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorFlow implements AccountTypeTranslator {


    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorFlow(AccountTypeRepository accountTypeRepository){
        this.accountTypeRepository = accountTypeRepository;
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

    /*@Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto) {
        try{
            AccountType accountType =accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to DB");
        }
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from DB");
        }
    }*/
}
