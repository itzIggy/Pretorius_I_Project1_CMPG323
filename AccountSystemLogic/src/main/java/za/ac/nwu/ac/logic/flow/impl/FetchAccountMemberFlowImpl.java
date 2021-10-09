package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountMemberDto;
import za.ac.nwu.ac.logic.flow.FetchAccountMemberFlow;
import za.ac.nwu.ac.translator.AccountMemberTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountMemberFlowImpl implements FetchAccountMemberFlow {

    private final AccountMemberTranslator accountMemberTranslator;

    @Autowired
    public FetchAccountMemberFlowImpl(AccountMemberTranslator accountMemberTranslator){
        this.accountMemberTranslator = accountMemberTranslator;
    }

    @Override
    public List<AccountMemberDto> getAllAccountMembers(){
        return accountMemberTranslator.getAllAccountMembers();
    }

    @Override
    public List<AccountMemberDto> getAccountMemberByMemberID(Long memberID) {
        return accountMemberTranslator.getAccountMemberByMemberID(memberID);
    }
}
