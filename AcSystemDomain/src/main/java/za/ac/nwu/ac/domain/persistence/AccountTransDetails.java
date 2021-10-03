package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "accounttransdetails", schema = "discoveryproject")
public class AccountTransDetails implements Serializable{



    private static final long serialVersionUID = 7251976649032251254L;

    private AccountTransaction accountTransaction;
    private Long accountTransDID;
    private String accountTransDPartnerName;
    private int accountTransDNumItems;

    public AccountTransDetails(Long accountTransDID, AccountTransaction accountTransaction, String accountTransDPartnerName, int accountTransDNumItems) {
        this.accountTransDID = accountTransDID;
        this.accountTransaction = accountTransaction;
        this.accountTransDPartnerName = accountTransDPartnerName;
        this.accountTransDNumItems = accountTransDNumItems;
    }

    public AccountTransDetails() {
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "att_ID")
    public AccountTransaction getAccountTransaction() {
        return accountTransaction;
    }

    public void setAccountTransaction(AccountTransaction accountTransaction) {
        this.accountTransaction = accountTransaction;
    }

    @Id
    @SequenceGenerator(name = "discoveryproject_SEQ", sequenceName = "discoveryproject.discoveryproject_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discoveryproject_SEQ")
    @Column(name = "atd_ID", nullable = false)
    public Long getAccountTransDID() {
        return accountTransDID;
    }

    public void setAccountTransDID(Long accountTransDID) {
        this.accountTransDID = accountTransDID;
    }

    @Column(name = "atd_PartnerName")
    public String getAccountTransDPartnerName() {
        return accountTransDPartnerName;
    }

    public void setAccountTransDPartnerName(String accountTransDPartnerName) {this.accountTransDPartnerName = accountTransDPartnerName;}

    @Column(name = "atd_NumItems")
    public int getAccountTransDNumItems() {
        return accountTransDNumItems;
    }

    public void setAccountTransDNumItems(int accountTransDNumItems) {
        this.accountTransDNumItems = accountTransDNumItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransDetails that = (AccountTransDetails) o;
        return accountTransDNumItems == that.accountTransDNumItems && Objects.equals(accountTransaction, that.accountTransaction) && Objects.equals(accountTransDID, that.accountTransDID) && Objects.equals(accountTransDPartnerName, that.accountTransDPartnerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransaction, accountTransDID, accountTransDPartnerName, accountTransDNumItems);
    }

    @Override
    public String toString() {
        return "AccountTransDetails{" +
                "accountTransaction=" + accountTransaction +
                ", accountTransDID=" + accountTransDID +
                ", accountTransDPartnerName='" + accountTransDPartnerName + '\'' +
                ", accountTransDNumItems=" + accountTransDNumItems +
                '}';
    }
}
