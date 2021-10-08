package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountMember;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "DTO AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -7819344808062462808L;

    private AccountType accountType;
    private AccountMember accountMember;
    private double transAmount;
    private LocalDate transDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(AccountType accountType,AccountMember accountMember ,double transAmount, LocalDate transDate) {
        this.accountType = accountType;
        this.accountMember =accountMember;
        this.transAmount = transAmount;
        this.transDate = transDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction){
        this.setAccountType(accountTransaction.getAccountType());
        this.setAccountMember(accountTransaction.getAccountMember());
        this.setTransAmount(accountTransaction.getAmount());
        this.setTransDate(accountTransaction.getTransDate());
    }

    @ApiModelProperty(position = 1,
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

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountMember getAccountMember() {
        return accountMember;
    }

    public void setAccountMember(AccountMember accountMember) {
        this.accountMember = accountMember;
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction(){
        return new AccountTransaction(getAccountType(),getAccountMember(),getTransAmount(),getTransDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Double.compare(that.transAmount, transAmount) == 0 && Objects.equals(accountType, that.accountType) && Objects.equals(accountMember, that.accountMember) && Objects.equals(transDate, that.transDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, accountMember, transAmount, transDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "accountType=" + accountType +
                ", accountMember=" + accountMember +
                ", transAmount=" + transAmount +
                ", transDate=" + transDate +
                '}';
    }
}
