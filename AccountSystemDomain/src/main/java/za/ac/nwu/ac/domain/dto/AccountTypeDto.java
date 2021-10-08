package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountMember;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "DTO AccountType")
public class AccountTypeDto implements Serializable {

    private static final long serialVersionUID = 2538138663972118712L;

    private Long accountTypeId;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    public AccountTypeDto() {
    }

    public AccountTypeDto(AccountType accountTypeDto) {
        this.setAccountTypeId(accountTypeDto.getAccountTypeId());
        this.setMnemonic(accountTypeDto.getMnemonic());
        this.setAccountTypeName(accountTypeDto.getAccountTypeName());
        this.setCreationDate(accountTypeDto.getCreationDate());
    }

    public AccountTypeDto(Long accountTypeId,String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.accountTypeId=accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.creationDate = creationDate;
    }

    @ApiModelProperty(position = 1,
            value = "AccountType ID",
            name = "ID",
            notes = "Identifies Account type by ID",
            dataType = "java.lang.Integer",
            example = "1",
            allowEmptyValue = false,
            required = true)
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @ApiModelProperty(position = 3,
            value = "AccountType Name",
            name = "Name",
            notes = "Identifies Account type name",
            dataType = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = true)
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @ApiModelProperty(position = 4,
            value = "AccountType Date Created",
            name = "CreationDate",
            notes = "Identifies Account type creation Date",
            dataType = "java.lang.String",
            example = "2020-02-01",
            required = false)
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @ApiModelProperty(position = 2,
    value = "AccountType Mnemonic",
    name = "Mnemonic",
    notes = "Identifies Account type",
    dataType = "java.lang.String",
    example = "MILES",
    required = true)
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, mnemonic, accountTypeName, creationDate);
    }

    @JsonIgnore
    public AccountType getAccountType(){
        return new AccountType(getAccountTypeId(),getMnemonic(),getAccountTypeName(),getCreationDate());
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
