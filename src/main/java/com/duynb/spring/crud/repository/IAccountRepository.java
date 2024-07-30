package com.duynb.spring.crud.repository;

import com.duynb.spring.crud.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Integer> {
    Account findByUsername(String username);
}
