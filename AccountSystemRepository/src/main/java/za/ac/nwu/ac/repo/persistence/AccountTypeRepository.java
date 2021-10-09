package za.ac.nwu.ac.repo.persistence;

import io.swagger.annotations.ApiParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
    @Query(value = "SELECT       " +
            "        at          " +
            "        FROM        " +
            "        AccountType " +
            "        at          " +
            "WHERE at.mnemonic = :mnemonic" )
    AccountType getAccountTypeByMnemonic(String mnemonic);

    /*@Query(value = "UPDATE      " +
            "        AccountType        " +
            "SET  AccountType.accountTypeId = :accountTypeId,AccountType.mnemonic = :mnemonic, AccountType.accountTypeName = :accountTypeName, AccountType.creationDate = :creationDate")
    AccountType modifyAccountType(@ApiParam("accountTypeID") AccountTypeDto accountTypeDto);*/

    /*@Query(value = "DELETE FROM AccountType WHERE AccountType.mnemonic = :mnemonic")
    AccountType removeAccountTypeByMnemonic(String mnemonic);*/
}