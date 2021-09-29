package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "accounttype", schema = "discoveryproject")
public class AccountType implements Serializable{

    private static final long serialVersionUID = 6034186934755339239L;
    @Id
    @SequenceGenerator(name = "discoveryproject_SEQ", sequenceName = "discoveryproject.discoveryproject_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discoveryproject_SEQ")
    @Column(name = "at_TypeID")
    private Long accountTypeID;

    @Column(name = "at_Mnemonic")
    private String accountMnemonic;

    @Column(name = "at_Name")
    private String accountName;

    @Column(name = "at_DateCreated")
    private LocalDate accountDateCreated;

    public AccountType(Long accountTypeID, String accountMnemonic, String accountName, LocalDate accountDateCreated) {
        this.accountTypeID = accountTypeID;
        this.accountMnemonic = accountMnemonic;
        this.accountName = accountName;
        this.accountDateCreated = accountDateCreated;
    }

    public AccountType() {
    }

    public Long getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public String getAccountMnemonic() {
        return accountMnemonic;
    }

    public void setAccountMnemonic(String accountMnemonic) {
        this.accountMnemonic = accountMnemonic;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LocalDate getAccountDateCreated() {
        return accountDateCreated;
    }

    public void setAccountDateCreated(LocalDate accountDateCreated) {
        this.accountDateCreated = accountDateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(accountMnemonic, that.accountMnemonic) && Objects.equals(accountName, that.accountName) && Objects.equals(accountDateCreated, that.accountDateCreated);
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
