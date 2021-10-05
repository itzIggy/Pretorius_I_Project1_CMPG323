package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accounttype", schema = "discoveryproject")
public class AccountType implements Serializable{

    private static final long serialVersionUID = 6034186934755339239L;

    private Long accountTypeID;
    private String accountMnemonic;
    private String accountName;
    private LocalDate accountDateCreated;

    private Set<AccountTransaction> accountTransactions;

    public AccountType() {
    }

    public AccountType(Long accountTypeID, String accountMnemonic, String accountName, LocalDate accountDateCreated) {
        this.accountTypeID = accountTypeID;
        this.accountMnemonic = accountMnemonic;
        this.accountName = accountName;
        this.accountDateCreated = accountDateCreated;
    }

    public AccountType(String accountMnemonic, String accountName, LocalDate accountDateCreated) {
        this.accountMnemonic = accountMnemonic;
        this.accountName = accountName;
        this.accountDateCreated =accountDateCreated;
    }

    @Id
    @SequenceGenerator(name = "discoveryproject_SEQ", sequenceName = "discoveryproject.discoveryproject_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discoveryproject_SEQ")
    @Column(name = "at_TypeID")
    public Long getAccountTypeID() {
        return accountTypeID;
    }
    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    @Column(name = "at_Mnemonic")
    public String getAccountMnemonic() {
        return accountMnemonic;
    }
    public void setAccountMnemonic(String accountMnemonic) {
        this.accountMnemonic = accountMnemonic;
    }

    @Column(name = "at_Name")
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(name = "at_DateCreated")
    public LocalDate getAccountDateCreated() {
        return accountDateCreated;
    }
    public void setAccountDateCreated(LocalDate accountDateCreated) {
        this.accountDateCreated = accountDateCreated;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType",orphanRemoval = true,cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions(){
        return accountTransactions;
    }
    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return accountTypeID.equals(that.accountTypeID) && accountMnemonic.equals(that.accountMnemonic) && accountName.equals(that.accountName) && accountDateCreated.equals(that.accountDateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, accountMnemonic, accountName, accountDateCreated);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeID=" + accountTypeID +
                ", accountMnemonic='" + accountMnemonic + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountDateCreated=" + accountDateCreated +
                '}';
    }
}
