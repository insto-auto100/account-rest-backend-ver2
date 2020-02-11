package com.account.rest.controller;

import com.account.rest.model.Account;
import com.account.rest.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class AccountControllerTest {
    @InjectMocks
    AccountController accountController;

    @Mock
    AccountRepository accountRepository;

    @Test
    public void testFindAll() {
        // given
        List<Account> accounts = Arrays.asList();
        when(accountRepository.findAll()).thenReturn((List<Account>) accounts);

        // when
        List<Account> result = accountController.getAllAccounts();

        // then
        Mockito.verify(accountRepository, times(1)).findAll();
        assertEquals(0, result.size());
    }

}
