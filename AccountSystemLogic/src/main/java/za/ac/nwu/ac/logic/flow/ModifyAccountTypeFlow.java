package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.util.Optional;

public interface ModifyAccountTypeFlow {

    AccountTypeDto modifyAccountType(AccountTypeDto accountTypeDto);
}
