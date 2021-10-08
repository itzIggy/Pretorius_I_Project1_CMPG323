package za.ac.nwu.ac.translator;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.util.List;

public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto createAccountType(AccountTypeDto accountTypeDto);

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    /*AccountTypeDto modifyAccountType(AccountTypeDto accountTypeDto);*/

    /*AccountType removeAccountTypeByMnemonic(String mnemonic);*/
}
