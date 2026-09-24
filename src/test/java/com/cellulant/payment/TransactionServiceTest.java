package com.cellulant.payment;

import com.cellulant.payment.model.Transaction;
import com.cellulant.payment.service.TransactionService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private final TransactionService transactionService = new TransactionService();

    @Test
    void testProcessTransaction_Success() {
        Transaction input = new Transaction(null, "ACC123", new BigDecimal("5000.00"), "KES", null, null);
        
        Transaction result = transactionService.processTransaction(input);

        assertNotNull(result.getId());
        assertEquals("SUCCESS", result.getStatus());
        assertEquals("KES", result.getCurrency());
        assertNotNull(result.getTimestamp());
    }

    @Test
    void testGetTransactionById() {
        Transaction input = new Transaction(null, "ACC999", new BigDecimal("150.00"), "USD", null, null);
        Transaction saved = transactionService.processTransaction(input);

        Optional<Transaction> fetched = transactionService.getTransactionById(saved.getId());

        assertTrue(fetched.isPresent());
        assertEquals("ACC999", fetched.get().getAccountId());
    }
}