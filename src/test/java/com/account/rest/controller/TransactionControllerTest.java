package com.account.rest.controller;

import com.account.rest.model.Account;
import com.account.rest.model.Transaction;
import com.account.rest.repository.AccountRepository;
import com.account.rest.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class TransactionControllerTest {
    @InjectMocks
    TransactionController transactionController;

    @Mock
    TransactionRepository transactionRepository;

    @Test
    public void testGetAllTransactionsByAccountId() {
        // given
        List<Transaction> transactions = Arrays.asList();
        when(transactionRepository.findByAccountId(1L)).thenReturn((List<Transaction>) transactions);

        // when
        List<Transaction> result = transactionController.getAllTransactionsByAccountId(1L);

        // then
        Mockito.verify(transactionRepository, times(1)).findByAccountId(1L);
        assertEquals(0, result.size());
    }

}
