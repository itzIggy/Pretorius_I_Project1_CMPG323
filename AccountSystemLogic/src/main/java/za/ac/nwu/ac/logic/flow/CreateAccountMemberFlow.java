package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountMemberDto;

public interface CreateAccountMemberFlow {
    AccountMemberDto createAccountMember(AccountMemberDto accountMembers);
}
