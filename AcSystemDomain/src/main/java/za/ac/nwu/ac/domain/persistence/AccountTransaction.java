package za.ac.nwu.ac.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "accounttransaction", schema = "discoveryproject")
public class AccountTransaction implements Serializable{

    @Id
    @Column(name = "att_ID", nullable = false)
    private Long att_ID;

    public Long getAttID() {
        return att_ID;
    }

    public void setAttID(Long accountTrans_ID) {
        this.att_ID = accountTrans_ID;
    }

    @Column(name = "att_Amount")
    private double att_Amount;

    public double getAttAmount() { return att_Amount;}

    public void setAttAmount(double attAmount) {
        this.att_Amount = attAmount;
    }

    @Column(name = "att_Date")
    private Date att_Date;

    public Date getAttDate() { return att_Date;}

    public void setAttDate(Date attDate) {
        this.att_Date = attDate;
    }
}
