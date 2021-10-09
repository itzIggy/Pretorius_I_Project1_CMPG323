package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.logic.flow.RemoveAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;

@Transactional
@Component(value = "removeAccountTypeFlow")
public class RemoveAccountTypeFlowImpl implements RemoveAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public RemoveAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public void removeAccountTypeByID(Long accountTypeID){
        accountTypeTranslator.removeAccountTypeByID(accountTypeID);
    }
}
