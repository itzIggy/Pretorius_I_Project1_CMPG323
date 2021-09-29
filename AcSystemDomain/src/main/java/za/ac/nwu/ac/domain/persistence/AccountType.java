package za.ac.nwu.ac.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "accounttype", schema = "discoveryproject")
public class AccountType implements Serializable{

    @Id
    @Column(name = "at_TypeID", nullable = false)
    private Long at_TypeID;


    public Long getAtTypeID() {
        return at_TypeID;
    }

    public void setAtTypeID(Long accountTypeID) {
        this.at_TypeID = accountTypeID;
    }

    @Column(name = "at_Mnemonic")
    private String at_Mnemonic;

    public String getAtMnemonic() {
        return at_Mnemonic;
    }

    public void setAtMnemonic(String atMnemonic) {
        this.at_Mnemonic = atMnemonic;
    }

    @Column(name = "at_Name")
    private String at_Name;

    public String getAtName() {
        return at_Name;
    }

    public void setAtName(String atName) {
        this.at_Name = atName;
    }

    @Column(name = "at_DateCreated")
    private Date at_DateCreated;

    public Date getAtDateCreated() {
        return at_DateCreated;
    }

    public void setAtDateCreated(Date atDateCreated) {
        this.at_DateCreated = atDateCreated;
    }
}
