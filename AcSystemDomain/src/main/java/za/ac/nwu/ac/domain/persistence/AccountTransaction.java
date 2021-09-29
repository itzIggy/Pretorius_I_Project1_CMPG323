package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "accounttransaction", schema = "discoveryproject")
public class AccountTransaction implements Serializable{

    private static final long serialVersionUID = -1339536858857374788L;
    @Id
    @SequenceGenerator(name = "discoveryproject_SEQ", sequenceName = "discoveryproject.discoveryproject_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discoveryproject_SEQ")
    @Column(name = "att_ID", nullable = false)
    private Long accountTransID;

    @Column(name = "att_Amount")
    private double accountTransAmount;

    private AccountType accountType;

    @Column(name = "att_Date")
    private Date accountTransDate;

    public AccountTransaction(Long accountTransID, AccountType accountType, double accountTransAmount, Date accountTransDate) {
        this.accountTransID = accountTransID;
        this.accountTransAmount = accountTransAmount;
        this.accountTransDate = accountTransDate;
        this.accountType = accountType;
    }
    public AccountTransaction() {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "at_TypeID")
    public AccountType getAccountType(){
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }



    public Long getAccountTransID() {
        return accountTransID;
    }


    public void setAccountTransID(Long accountTransID) {
        this.accountTransID = accountTransID;
    }

    public double getAccountTransAmount() {
        return accountTransAmount;
    }

    public void setAccountTransAmount(double accountTransAmount) {
        this.accountTransAmount = accountTransAmount;
    }

    public Date getAccountTransDate() {
        return accountTransDate;
    }

    public void setAccountTransDate(Date accountTransDate) {
        this.accountTransDate = accountTransDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Double.compare(that.accountTransAmount, accountTransAmount) == 0 && Objects.equals(accountTransID, that.accountTransID) && Objects.equals(accountType, that.accountType) && Objects.equals(accountTransDate, that.accountTransDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransID, accountTransAmount, accountType, accountTransDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTransID=" + accountTransID +
                ", accountTransAmount=" + accountTransAmount +
                ", accountType=" + accountType +
                ", accountTransDate=" + accountTransDate +
                '}';
    }
}
