package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

//@Entity
//@Table(name = "ACCOUNT_TYPE", schema = "DISCOVERY")
public class AccountType implements Serializable{

        private Long accountType_ID;
        private String mnemonic;
        private String accountType_Name;
        private LocalDate dateCreated;
        private Set<AccountTransaction> accountTransactionSet;

        public AccountType(){}

        //@Contract(pure = true)
        public AccountType(long accountType_ID, String mnemonic, String accountType_Name, LocalDate dateCreated){
            this.accountType_ID = accountType_ID;
            this.mnemonic = mnemonic;
            this.accountType_Name = accountType_Name;
            this.dateCreated = dateCreated;
        }
}
