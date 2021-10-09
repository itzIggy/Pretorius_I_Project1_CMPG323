package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountMember;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "AccountMember", description = "DTO Account Member")
public class AccountMemberDto implements Serializable {

    private static final long serialVersionUID = 4611286498185450558L;

    private String memberFname;
    private String memberLname;
    private double memberBalance;
    private String memberPhone;

    public AccountMemberDto() {
    }

    public AccountMemberDto(String memberFname, String memberLname, double memberBalance, String memberPhone) {
        this.memberFname = memberFname;
        this.memberLname = memberLname;
        this.memberBalance = memberBalance;
        this.memberPhone = memberPhone;
    }

    public AccountMemberDto(AccountMember accountMember){
        this.setMemberFname(accountMember.getMemberFname());
        this.setMemberLname(accountMember.getMemberLname());
        this.setMemberBalance(accountMember.getMemberBalance());
        this.setMemberPhone(accountMember.getMemberPhone());
    }

    @ApiModelProperty(position = 1,
            value = "AccountMember First Name",
            name = "memberFname",
            notes = "Identifies Account Member First Name",
            dataType = "java.lang.String",
            example = "Ivan",
            required = true)
    public String getMemberFname() {
        return memberFname;
    }

    public void setMemberFname(String memberFname) {
        this.memberFname = memberFname;
    }

    @ApiModelProperty(position = 2,
            value = "AccountMember Last Name",
            name = "memberLname",
            notes = "Identifies Account Member Last Name",
            dataType = "java.lang.String",
            example = "Pretorius",
            required = true)
    public String getMemberLname() {
        return memberLname;
    }

    public void setMemberLname(String memberLname) {
        this.memberLname = memberLname;
    }

    @ApiModelProperty(position = 3,
            value = "AccountMember Balance",
            name = "memberBalance",
            notes = "Identifies Account Member Balance",
            dataType = "java.lang.String",
            example = "1500",
            required = true)
    public double getMemberBalance() {
        return memberBalance;
    }

    public void setMemberBalance(double memberBalance) {
        this.memberBalance = memberBalance;
    }

    @ApiModelProperty(position = 4,
            value = "AccountMember Phone Number",
            name = "memberPhone",
            notes = "Identifies Account Member Phone Number",
            dataType = "java.lang.String",
            example = "0797515646",
            required = true)
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
        AccountMemberDto that = (AccountMemberDto) o;
        return Double.compare(that.memberBalance, memberBalance) == 0 && Objects.equals(memberFname, that.memberFname) && Objects.equals(memberLname, that.memberLname) && Objects.equals(memberPhone, that.memberPhone);
    }

    @JsonIgnore
    public AccountMember getAccountMember(){
        return new AccountMember(getMemberFname(),getMemberLname(),getMemberBalance(),getMemberPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberFname, memberLname, memberBalance, memberPhone);
    }

    @Override
    public String toString() {
        return "AccountMemberDto{" +
                "memberFname='" + memberFname + '\'' +
                ", memberLname='" + memberLname + '\'' +
                ", memberBalance=" + memberBalance +
                ", memberPhone='" + memberPhone + '\'' +
                '}';
    }
}
