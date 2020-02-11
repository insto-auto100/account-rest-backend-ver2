package com.account.rest.controller;

import com.account.rest.model.Account;
import com.account.rest.model.Transaction;
import com.account.rest.repository.AccountRepository;
import com.account.rest.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/accounts/{accountId}/transactions")
    public List<Transaction> getAllTransactionsByAccountId(@PathVariable(value = "accountId") Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    @PostMapping("/accounts/{accountId}/transactions")
    public Transaction createTransaction(@PathVariable(value = "accountId") Long accountId,
                                         @Valid @RequestBody Transaction transaction) {
        return accountRepository.findById(accountId).map(account -> {
            transaction.setAccount(account);
            return transactionRepository.save(transaction);
        }).orElseThrow(() -> new RuntimeException("AccountId " + accountId + " not found"));
    }

}
