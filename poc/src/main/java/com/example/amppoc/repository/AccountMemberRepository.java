package com.example.amppoc.repository;

import com.example.amppoc.model.AccountMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountMemberRepository extends JpaRepository<AccountMember, Long> {

    // You can define custom query methods here if needed
    // For example, findByPropertyName methods will be automatically implemented

}

