package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

//@Entity
//@Table(name = "AccountTransaction", schema = "DiscoveryProject")
public class AccountTransaction implements Serializable{

    //private static final long Serialversion =

    private AccountTransaction accountNum;
    private double transactAmount;
    private LocalDate transactDate;

    public AccountTransaction(){}

    public AccountTransaction(AccountTransaction accountNum, double transactAmount, LocalDate transactDate){
        this.accountNum = accountNum;
        this.transactAmount = transactAmount;
        this.transactDate = transactDate;
    }

}
