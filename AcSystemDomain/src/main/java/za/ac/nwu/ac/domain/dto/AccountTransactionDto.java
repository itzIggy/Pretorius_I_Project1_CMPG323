/*
package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "DTO AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -7819344808062462808L;

    private Long memberID;
    private double transAmount;
    private LocalDate transDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(Long memberID, double transAmount, LocalDate transDate) {
        this.memberID = memberID;
        this.transAmount = transAmount;
        this.transDate = transDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction){
        this.setMemberID(accountTransaction.getMemberID());
        this.setTransAmount(accountTransaction.getTransAmount());
        this.setTransDate(accountTransaction.getAccountTransDate());
    }

    @ApiModelProperty(position = 1,
            value = "AccountTransaction MemberID",
            name = "MemberID",
            notes = "Identifies Account transaction Member",
            dataType = "java.lang.String",
            example = "1",
            required = true)
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @ApiModelProperty(position = 2,
            value = "AccountTransaction amount",
            name = "Amount",
            notes = "Identifies Account transaction Amount",
            dataType = "java.lang.String",
            example = "1000",
            required = true)
    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }

    @ApiModelProperty(position = 2,
            value = "AccountTransaction Date",
            name = "Date",
            notes = "Identifies Account transaction Date",
            dataType = "java.lang.String",
            example = "2020-01-01",
            required = true)
    public LocalDate getTransDate() {
        return transDate;
    }

    public void setTransDate(LocalDate transDate) {
        this.transDate = transDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Double.compare(that.transAmount, transAmount) == 0 && memberID.equals(that.memberID) && transDate.equals(that.transDate);
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction(){
        return new AccountTransaction(getMemberID(),getTransAmount(),getTransDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, transAmount, transDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "memberID=" + memberID +
                ", transAmount=" + transAmount +
                ", transDate=" + transDate +
                '}';
    }
}
*/