package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "accounttransaction", schema = "accountsystem")
public class AccountTransaction implements Serializable{

    private static final long serialVersionUID = -2353697207979213035L;

    private Long accountTransID;
    private AccountType accountType;
    private AccountMember accountMember;
    private double amount;
    private LocalDate transDate;

    public  AccountTransaction()
    {

    }

    public AccountTransaction(Long accountTransID, AccountType accountType, AccountMember accountMember, double amount, LocalDate transDate) {
        this.accountTransID = accountTransID;
        this.accountType = accountType;
        this.accountMember = accountMember;
        this.amount = amount;
        this.transDate = transDate;
    }

    public AccountTransaction(AccountType accountType, AccountMember accountMember,double amount, LocalDate transDate) {
        this.accountType = accountType;
        this.accountMember = accountMember;
        this.amount = amount;
        this.transDate = transDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getAccountTransID() {
        return accountTransID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountTypeID")
    public AccountType getAccountType() {
        return accountType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberID")
    public AccountMember getAccountMember() {
        return accountMember;
    }

    public void setAccountMember(AccountMember accountMember) {
        this.accountMember = accountMember;
    }

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    @Column(name = "transaction_date")
    public LocalDate getTransDate() {
        return transDate;
    }

    public void setAccountTransID(Long accountTransID) {
        this.accountTransID = accountTransID;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTransDate(LocalDate transDate) {
        this.transDate = transDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(accountTransID, that.accountTransID) && Objects.equals(accountType, that.accountType) && Objects.equals(accountMember, that.accountMember) && Objects.equals(transDate, that.transDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransID, accountType, accountMember, amount, transDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTransID=" + accountTransID +
                ", accountType=" + accountType +
                ", accountMember=" + accountMember +
                ", amount=" + amount +
                ", transDate=" + transDate +
                '}';
    }
}
