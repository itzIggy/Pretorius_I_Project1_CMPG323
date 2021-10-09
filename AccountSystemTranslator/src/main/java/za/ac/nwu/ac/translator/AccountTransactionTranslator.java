package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTransactionTranslator {
    List<AccountTransactionDto> getAllAccountTransactions();

    List<AccountTransactionDto> getAccountTransactionByMemberID(Long memberID);

    AccountTransactionDto createTransaction(AccountTransactionDto accountTransactionDto);

    /*AccountTransactionDto removeAccountTransactionByID(Integer accountTransID);*/
}
