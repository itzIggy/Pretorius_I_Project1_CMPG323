package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.util.List;

public interface AccountTransactionTranslator {
    List<AccountTransactionDto> getAllAccountTransactions();

    List<AccountTransactionDto> getAccountTransactionByMemberID(Long memberID);

    AccountTransactionDto createTransaction(AccountTransactionDto accountTransactionDto);

}
