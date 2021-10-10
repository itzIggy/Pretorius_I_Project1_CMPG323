package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountMemberDto;

public interface ModifyMemberFlow {

    AccountMemberDto modifyAccountMember(AccountMemberDto accountMemberDto);

    AccountMemberDto addCurrencyToBalance(Long memberID, double balance, Integer optional);

    AccountMemberDto subtractCurrencyFromBalance(Long memberID, double balance);
}
