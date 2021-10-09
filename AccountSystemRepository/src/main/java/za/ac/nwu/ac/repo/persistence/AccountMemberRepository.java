package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountMember;

import java.util.List;

@Repository
public interface AccountMemberRepository extends JpaRepository<AccountMember, Long> {
    @Query(value = "SELECT             " +
            "        at           " +
            "        FROM              " +
            "        AccountMember" +
            "        at                " +
            "WHERE at.memberID = :memberID" )
    List<AccountMember> getAccountMemberByMemberID(Long memberID); //USED FOR GETTING MEMBER IN CONTROLLER

    @Query(value = "SELECT             " +
            "        at           " +
            "        FROM              " +
            "        AccountMember" +
            "        at                " +
            "WHERE at.memberID = :memberID" )
    AccountMember getAccountMemberByID(Long memberID); //USED FOR ADDING AND SUBTRACTING CURRENCY
}
