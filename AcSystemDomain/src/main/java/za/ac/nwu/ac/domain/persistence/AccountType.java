package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "AccountType", schema = "DiscoveryProject")
public class AccountType implements Serializable{

    @Id
    @Column(name = "accounttypeid", nullable = false)
    private Long accounttypeid;

    //private static final long Serialversion =

    public Long getAccounttypeid() {
        return accounttypeid;
    }

    public void setAccounttypeid(Long accounttypeid) {
        this.accounttypeid = accounttypeid;
    }
}
