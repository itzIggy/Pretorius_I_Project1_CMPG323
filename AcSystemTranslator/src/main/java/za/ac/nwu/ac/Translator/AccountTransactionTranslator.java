package za.ac.nwu.ac.Translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.util.List;

public interface AccountTransactionTranslator {
    List<AccountTransactionDto> getAccountTransactions();
}
