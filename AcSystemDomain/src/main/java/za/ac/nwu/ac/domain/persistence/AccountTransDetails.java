package za.ac.nwu.ac.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "accounttransdetails", schema = "discoveryproject")
public class AccountTransDetails implements Serializable{


    @Id
    @Column(name = "atd_ID", nullable = false)
    private Long atd_ID;


    public Long getAtd_ID() { return atd_ID; }

    public void setAtd_ID(Long accountTransDetails_ID) {
        this.atd_ID = accountTransDetails_ID;
    }


    @Column(name = "atd_PartnerName")
    private String atd_PartnerName;


    public String getAtdPartnerName() {
        return atd_PartnerName;
    }

    public void setAtdPartnerName(String atdPartnerName) {
        this.atd_PartnerName = atdPartnerName;
    }

    @Column(name = "atd_NumItems")
    private int atd_NumItems;


    public int getAtdNumItems() {
        return atd_NumItems;
    }

    public void setAtdNumItems(int atdNumItems) {
        this.atd_NumItems = atdNumItems;
    }
}
