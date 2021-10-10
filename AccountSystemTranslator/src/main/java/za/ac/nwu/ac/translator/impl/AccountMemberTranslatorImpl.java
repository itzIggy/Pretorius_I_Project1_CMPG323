package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountMemberDto;
import za.ac.nwu.ac.domain.persistence.AccountMember;
import za.ac.nwu.ac.repo.persistence.AccountMemberRepository;
import za.ac.nwu.ac.translator.AccountMemberTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class AccountMemberTranslatorImpl implements AccountMemberTranslator {

    private final AccountMemberRepository accountMemberRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountMemberTranslatorImpl.class);

    @Autowired
    public AccountMemberTranslatorImpl(AccountMemberRepository accountMemberRepository){
        this.accountMemberRepository =accountMemberRepository;
    }

    @Override
    public List<AccountMemberDto> getAllAccountMembers(){

        List<AccountMemberDto> accountMemberDtos = new ArrayList<>();
        try{
            for (AccountMember accountMember : accountMemberRepository.findAll()){
                accountMemberDtos.add(new AccountMemberDto(accountMember));
            }
        } catch (Exception e){

            throw new RuntimeException("Unable to read from the DB", e);
        }

        return  accountMemberDtos;
    }

    @Override
    public AccountMemberDto createAccountMember(AccountMemberDto accountMembers) {
        try{
            AccountMember accountMember =accountMemberRepository.save(accountMembers.getAccountMember());
            return new AccountMemberDto(accountMember);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to DB");
        }
    }

    @Override
    public List<AccountMemberDto> getAccountMemberByMemberID(Long memberID) {
        List<AccountMemberDto> accountMemberDtos = new ArrayList<>();
        try{
            for (AccountMember accountMember : accountMemberRepository.getAccountMemberByMemberID(memberID)){
                accountMemberDtos.add(new AccountMemberDto(accountMember));
            }
        } catch (Exception e){

            throw new RuntimeException("Unable to read from the DB", e);
        }

        return  accountMemberDtos;
    }

    @Override
    public AccountMemberDto modifyAccountMember(AccountMemberDto accountMemberDto) {
        try{
            AccountMember accountMember =accountMemberRepository.save(accountMemberDto.getAccountMember());
            return new AccountMemberDto(accountMember);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to DB");
        }
    }

    @Override
    public AccountMemberDto addCurrencyToBalance(Long memberID, double balance, Integer optional) {
        try{
            AccountMember accountMember = accountMemberRepository.getAccountMemberByID(memberID);

            double updateBalance = accountMember.getMemberBalance() + balance;

            accountMember.setMemberBalance(updateBalance);

            AccountMember newAccountMember = accountMemberRepository.save(accountMember);

            if(optional == 1)
            {
                throw new RuntimeException("Runtime Exception");
            }

            return new AccountMemberDto(newAccountMember);
        } catch (Exception e){

            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountMemberDto subtractCurrencyFromBalance(Long memberID, double balance) {
        try{
            AccountMember accountMember = accountMemberRepository.getAccountMemberByID(memberID);

            double updateBalance = accountMember.getMemberBalance() - balance;

            accountMember.setMemberBalance(updateBalance);

            AccountMember newAccountMember = accountMemberRepository.save(accountMember);

            return new AccountMemberDto(newAccountMember);
        } catch (Exception e){

            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
}
