package za.ac.nwu.ac.logic.flow;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);


}
