package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "accounttransaction", schema = "accountsystem")
public class AccountTransaction implements Serializable{

    private static final long serialVersionUID = -1339536858857374788L;

    private Long accountTransID;
    private double transAmount;
    private AccountType accountType;
    private Long memberID;
    private LocalDate accountTransDate;

    public AccountTransaction() {
    }

    public AccountTransaction(Long accountTransID,Long memberID, AccountType accountType, double transAmount, LocalDate accountTransDate) {
        this.accountTransID = accountTransID;
        this.transAmount = transAmount;
        this.accountTransDate = accountTransDate;
        this.accountType = accountType;
        this.memberID = memberID;
    }

    public AccountTransaction(Long memberID, double transAmount, LocalDate accountTransDate) {
        this.transAmount = transAmount;
        this.accountTransDate = accountTransDate;
        this.memberID = memberID;
    }

    @Id
    @SequenceGenerator(name = "accountsystem_SEQ", sequenceName = "accountsystem.accountsystem_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountsystem_SEQ")
    @Column(name = "id", nullable = false)
    public Long getAccountTransID() {
        return accountTransID;
    }

    public void setAccountTransID(Long accountTransID) {
        this.accountTransID = accountTransID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id")
    public AccountType getAccountType(){
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Column(name = "amount")
    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }

    @Column(name = "transactionDate")
    public LocalDate getAccountTransDate() {
        return accountTransDate;
    }

    public void setAccountTransDate(LocalDate accountTransDate) {
        this.accountTransDate = accountTransDate;
    }

    @Column(name = "memberID")
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
        return Double.compare(that.transAmount, transAmount) == 0 && accountTransID.equals(that.accountTransID) && accountType.equals(that.accountType) && memberID.equals(that.memberID) && accountTransDate.equals(that.accountTransDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransID, transAmount, accountType, memberID, accountTransDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTransID=" + accountTransID +
                ", accountTransAmount=" + transAmount +
                ", accountType=" + accountType +
                ", memberID=" + memberID +
                ", accountTransDate=" + accountTransDate +
                '}';
    }
}
