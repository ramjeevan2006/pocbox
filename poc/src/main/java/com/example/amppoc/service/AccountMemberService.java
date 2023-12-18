package com.example.amppoc.service;





import com.example.amppoc.model.AccountMember;
import com.example.amppoc.repository.AccountMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountMemberService {

    @Autowired
    AccountMemberRepository accountMemberRepository;


    public List<AccountMember> getAllAccountMembers() {
        return accountMemberRepository.findAll();
    }

    public Optional<AccountMember> getAccountMemberById(Long id) {
        return accountMemberRepository.findById(id);
    }

    public AccountMember createAccountMember(AccountMember accountMember) {
        return accountMemberRepository.save(accountMember);
    }

    public AccountMember updateAccountMember(Long id, AccountMember updatedAccountMember) {
        if (accountMemberRepository.existsById(id)) {
            updatedAccountMember.setId(id);
            return accountMemberRepository.save(updatedAccountMember);
        }
        return null; // Handle not found scenario as needed
    }

    public void deleteAccountMember(Long id) {
        accountMemberRepository.deleteById(id);
    }
}

