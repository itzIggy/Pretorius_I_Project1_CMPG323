package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountMemberDto;
import za.ac.nwu.ac.domain.persistence.AccountMember;

import java.util.List;

public interface AccountMemberTranslator {
    List<AccountMemberDto> getAllAccountMembers();

    AccountMemberDto createAccountMember(AccountMemberDto accountMemberDto);

    List<AccountMemberDto> getAccountMemberByMemberID(Long memberID);

    AccountMemberDto modifyAccountMember(AccountMemberDto accountMemberDto);

    AccountMemberDto addCurrencyToBalance(Long memberID, double balance);

    AccountMemberDto subtractCurrencyFromBalance(Long memberID, double balance);

}
