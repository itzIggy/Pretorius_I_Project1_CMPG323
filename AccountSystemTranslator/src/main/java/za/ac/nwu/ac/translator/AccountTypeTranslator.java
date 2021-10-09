package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto createAccountType(AccountTypeDto accountTypeDto);

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto modifyAccountType(AccountTypeDto accountTypeDto);

    void removeAccountTypeByID(Long accountTypeID);
}
