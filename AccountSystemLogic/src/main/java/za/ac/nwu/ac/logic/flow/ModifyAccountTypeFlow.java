package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.time.LocalDate;

public interface ModifyAccountTypeFlow {

    AccountTypeDto modifyAccountType(String mnemonic, String accountName, LocalDate newDate);
}
