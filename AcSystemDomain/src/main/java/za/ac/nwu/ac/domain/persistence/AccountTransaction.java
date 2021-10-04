package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "accounttransaction", schema = "discoveryproject")
public class AccountTransaction implements Serializable{

    private static final long serialVersionUID = -1339536858857374788L;

    private Long accountTransID;
    private double accountTransAmount;
    private AccountType accountType;
    private Long memberID;
    private LocalDate accountTransDate;

    public AccountTransaction(Long accountTransID,Long memberID, AccountType accountType, double accountTransAmount, LocalDate accountTransDate) {
        this.accountTransID = accountTransID;
        this.accountTransAmount = accountTransAmount;
        this.accountTransDate = accountTransDate;
        this.accountType = accountType;
        this.memberID = memberID;
    }
    public AccountTransaction() {
    }

    @Id
    @SequenceGenerator(name = "discoveryproject_SEQ", sequenceName = "discoveryproject.discoveryproject_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discoveryproject_SEQ")
    @Column(name = "att_ID", nullable = false)
    public Long getAccountTransID() {
        return accountTransID;
    }

    public void setAccountTransID(Long accountTransID) {
        this.accountTransID = accountTransID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "at_TypeID")
    public AccountType getAccountType(){
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Column(name = "att_Amount")
    public double getAccountTransAmount() {
        return accountTransAmount;
    }

    public void setAccountTransAmount(double accountTransAmount) {
        this.accountTransAmount = accountTransAmount;
    }

    @Column(name = "att_Date")
    public LocalDate getAccountTransDate() {
        return accountTransDate;
    }

    public void setAccountTransDate(LocalDate accountTransDate) {
        this.accountTransDate = accountTransDate;
    }

    @Column(name = "att_memberID")
    public Long getMemberID() {
        return memberID;
    }
    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Double.compare(that.accountTransAmount, accountTransAmount) == 0 && accountTransID.equals(that.accountTransID) && accountType.equals(that.accountType) && memberID.equals(that.memberID) && accountTransDate.equals(that.accountTransDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransID, accountTransAmount, accountType, memberID, accountTransDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTransID=" + accountTransID +
                ", accountTransAmount=" + accountTransAmount +
                ", accountType=" + accountType +
                ", memberID=" + memberID +
                ", accountTransDate=" + accountTransDate +
                '}';
    }
}
