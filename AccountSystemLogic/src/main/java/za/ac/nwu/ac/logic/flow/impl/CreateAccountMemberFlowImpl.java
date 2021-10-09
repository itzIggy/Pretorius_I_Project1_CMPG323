package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountMemberDto;
import za.ac.nwu.ac.logic.flow.CreateAccountMemberFlow;
import za.ac.nwu.ac.translator.AccountMemberTranslator;

import javax.transaction.Transactional;

@Transactional
@Component(value = "createAccountMemberFlowName")
public class CreateAccountMemberFlowImpl implements CreateAccountMemberFlow {

    private final AccountMemberTranslator accountMemberTranslator;

    @Autowired
    public CreateAccountMemberFlowImpl(AccountMemberTranslator accountMemberTranslator){
        this.accountMemberTranslator = accountMemberTranslator;
    }

    @Override
    public AccountMemberDto createAccountMember(AccountMemberDto accountMemberDto){
        return accountMemberTranslator.createAccountMember(accountMemberDto);
    }
}
