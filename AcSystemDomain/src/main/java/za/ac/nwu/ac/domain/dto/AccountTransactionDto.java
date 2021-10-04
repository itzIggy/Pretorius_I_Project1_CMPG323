package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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
        this.setTransAmount(accountTransaction.getAccountTransAmount());
        this.setTransDate(accountTransaction.getAccountTransDate());
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }

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
