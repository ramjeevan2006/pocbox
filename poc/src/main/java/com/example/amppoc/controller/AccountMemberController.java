package com.example.amppoc.controller;

import com.example.amppoc.model.AccountMember;
import com.example.amppoc.service.AccountMemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 import java.util.List;
 import java.util.Optional;

@RestController
@RequestMapping("/accountmember")
public class AccountMemberController {

    private final AccountMemberService accountMemberService;

    @Autowired
    public AccountMemberController(AccountMemberService accountMemberService) {
        this.accountMemberService = accountMemberService;
    }

    @GetMapping
    public List<AccountMember> getAllAccountMembers() {
        return accountMemberService.getAllAccountMembers();
    }

    @GetMapping("/{id}")
    public Optional<AccountMember> getAccountMemberById(@PathVariable Long id) {
        return accountMemberService.getAccountMemberById(id);
    }

    @PostMapping
    public AccountMember createAccountMember(@RequestBody AccountMember accountMember) {
        return accountMemberService.createAccountMember(accountMember);
    }

    @PutMapping("/{id}")
    public AccountMember updateAccountMember(@PathVariable Long id, @RequestBody AccountMember updatedAccountMember) {
        return accountMemberService.updateAccountMember(id, updatedAccountMember);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountMember(@PathVariable Long id) {
        accountMemberService.deleteAccountMember(id);
    }
}

