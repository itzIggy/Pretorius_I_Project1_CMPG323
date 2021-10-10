package za.ac.nwu.ac.translator.impl;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class AccountTypeTranslatorImpl implements AccountTypeTranslator{

    private final AccountTypeRepository accountTypeRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountTypeTranslatorImpl.class);

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){

        List<AccountTypeDto> accountTypes = new ArrayList<>();
        try{
            for (AccountType accountType : accountTypeRepository.findAll()){
                accountTypes.add(new AccountTypeDto(accountType));
            }
        } catch (Exception e){

            LOGGER.error("error for getAllAccountTypes");
            throw new RuntimeException("Unable to read from the DB", e);
        }

        return  accountTypes;
    }

    @Override
    public AccountTypeDto createAccountType(AccountTypeDto accountTypeDto) {
        try{
            AccountType accountType =accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        }catch (Exception e){
            LOGGER.error("error for creatingAccountType");
            throw new RuntimeException("Unable to save to DB");
        }
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        }catch (Exception e){
            LOGGER.error("error for getAccountTypeByMnemonic");
            throw new RuntimeException("Unable to read from DB");
        }
    }

    @Override
    public AccountTypeDto modifyAccountType(String mnemonic, String accountName, LocalDate newDate) {
        try{
            AccountType accountType  = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);

            if( newDate != null)
            {
                accountType.setCreationDate(newDate);
            }
            else
            {
                accountType.setCreationDate(LocalDate.now());
            }

            AccountType newAccountType = accountTypeRepository.save(accountType);


            return new AccountTypeDto(newAccountType);

        }catch (Exception e){
            LOGGER.error("error for modifyingAccountTypes");
            throw new RuntimeException("Unable to save to DB");
        }
    }

    @Override
    public void removeAccountTypeByID(Long accountTypeID){
        try{
            accountTypeRepository.deleteById(accountTypeID);
        }catch (Exception e){
            LOGGER.error("error for removingAccountTypes");
            throw new RuntimeException("Unable to delete from DB!");
        }
    }
}
