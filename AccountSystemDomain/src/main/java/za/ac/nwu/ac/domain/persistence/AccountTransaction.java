package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "accounttransaction", schema = "accountsystem")
public class AccountTransaction implements Serializable{

    private static final long serialVersionUID = -2353697207979213035L;

    private Long accountTxId;
    private AccountType accountType;
    private Long memberID;
    private double amount;
    private LocalDate transDate;

    public  AccountTransaction()
    {

    }

    public AccountTransaction(Long accountTxId, AccountType accountType, Long memberID, double amount, LocalDate transDate) {
        this.accountTxId = accountTxId;
        this.accountType = accountType;
        this.memberID = memberID;
        this.amount = amount;
        this.transDate = transDate;
    }

    public AccountTransaction(Long memberID, double amount, LocalDate transDate) {
        this.amount = amount;
        this.transDate = transDate;
        this.memberID = memberID;
    }

    @Id
    @SequenceGenerator(name = "accountsystem_SEQ", sequenceName = "accountsystem.accountsystem_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountsystem_SEQ")
    @Column(name = "id")
    public Long getAccountTxId() {
        return accountTxId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id",insertable = false,updatable = false)
    public AccountType getAccountType() {
        return accountType;
    }

    @Column(name = "memberID")
    public Long getMemberID() {
        return memberID;
    }

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    @Column(name = "transaction_date")
    public LocalDate getTransDate() {
        return transDate;
    }

    public void setAccountTxId(Long accountTxId) {
        this.accountTxId = accountTxId;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
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
        return Double.compare(that.amount, amount) == 0 && Objects.equals(accountTxId, that.accountTxId) && Objects.equals(accountType, that.accountType) && Objects.equals(memberID, that.memberID) && Objects.equals(transDate, that.transDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTxId, accountType, memberID, amount, transDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTxId=" + accountTxId +
                ", accountType=" + accountType +
                ", memberID='" + memberID + '\'' +
                ", TransactionAmount='" + amount + '\'' +
                ", creationDate=" + transDate +
                '}';
    }
}
