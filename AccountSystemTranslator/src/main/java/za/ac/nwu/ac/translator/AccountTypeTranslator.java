package za.ac.nwu.ac.translator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.util.List;
import java.util.Optional;

public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto createAccountType(AccountTypeDto accountTypeDto);

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto modifyAccountType(AccountTypeDto accountTypeDto);

    /*AccountTypeDto removeAccountTypeByID(Integer accountTypeID);*/
}
