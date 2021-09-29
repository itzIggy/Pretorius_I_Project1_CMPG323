package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;

import javax.transaction.Transactional;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountType implements CreateAccountTypeFlow {


}
