package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.time.LocalDate;
import java.util.List;

public interface AccountTypeTranslator {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto createAccountType(AccountTypeDto accountTypeDto);

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto modifyAccountType(String mnemonic, String accountName, LocalDate newDate);

    void removeAccountTypeByID(Long accountTypeID);
}
