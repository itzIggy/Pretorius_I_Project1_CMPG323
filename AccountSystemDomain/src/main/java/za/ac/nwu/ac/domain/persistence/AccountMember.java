package za.ac.nwu.ac.domain.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accountmember", schema = "accountsystem")
public class AccountMember implements Serializable {

    private static final long serialVersionUID = -8578265584806498994L;

    private Long memberID;
    private String memberFname;
    private String memberLname;
    private double memberBalance;
    private String memberPhone;

    private Set<AccountTransaction> accountTransactions;

    public AccountMember(Long memberID, String memberFname, String memberLname, double memberBalance, String memberPhone) {
        this.memberID = memberID;
        this.memberFname = memberFname;
        this.memberLname = memberLname;
        this.memberBalance = memberBalance;
        this.memberPhone = memberPhone;
    }

    public AccountMember() {
    }

    public AccountMember(String memberFname, String memberLname, double memberBalance, String memberPhone) {
        this.memberFname = memberFname;
        this.memberLname = memberLname;
        this.memberBalance = memberBalance;
        this.memberPhone = memberPhone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberID")
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @JsonIgnore
    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountMember")
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Column(name = "memberFname")
    public String getMemberFname() {
        return memberFname;
    }

    public void setMemberFname(String memberFname) {
        this.memberFname = memberFname;
    }

    @Column(name = "memberLname")
    public String getMemberLname() {
        return memberLname;
    }

    public void setMemberLname(String memberLname) {
        this.memberLname = memberLname;
    }

    @Column(name = "memberBalance")
    public double getMemberBalance() {
        return memberBalance;
    }

    public void setMemberBalance(double memberBalance) {
        this.memberBalance = memberBalance;
    }

    @Column(name = "memberPhone")
    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountMember that = (AccountMember) o;
        return Double.compare(that.memberBalance, memberBalance) == 0 && Objects.equals(memberID, that.memberID) && Objects.equals(memberFname, that.memberFname) && Objects.equals(memberLname, that.memberLname) && Objects.equals(memberPhone, that.memberPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, memberFname, memberLname, memberBalance, memberPhone);
    }

    @Override
    public String toString() {
        return "AccountMember{" +
                "memberID=" + memberID +
                ", memberFname='" + memberFname + '\'' +
                ", memberLname='" + memberLname + '\'' +
                ", memberBalance=" + memberBalance +
                ", memberPhone='" + memberPhone + '\'' +
                '}';
    }
}
