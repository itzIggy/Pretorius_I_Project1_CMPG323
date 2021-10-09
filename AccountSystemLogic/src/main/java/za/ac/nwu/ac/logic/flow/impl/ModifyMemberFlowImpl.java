package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountMemberDto;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;
import za.ac.nwu.ac.translator.AccountMemberTranslator;

import javax.transaction.Transactional;

@Transactional
@Component(value = "modifyMemberFlow")
public class ModifyMemberFlowImpl implements ModifyMemberFlow {

    private final AccountMemberTranslator accountMemberTranslator;

    @Autowired
    public ModifyMemberFlowImpl(AccountMemberTranslator accountMemberTranslator) {
        this.accountMemberTranslator = accountMemberTranslator;
    }

    @Override
    public AccountMemberDto modifyAccountMember(AccountMemberDto accountMemberDto){
        return accountMemberTranslator.modifyAccountMember(accountMemberDto);
    }

    @Override
    public AccountMemberDto addCurrencyToBalance(Long memberID, double balance){
        return  accountMemberTranslator.addCurrencyToBalance(memberID,balance);
    }

    @Override
    public AccountMemberDto subtractCurrencyFromBalance(Long memberID, double balance){
        return  accountMemberTranslator.subtractCurrencyFromBalance(memberID,balance);
    }
}
