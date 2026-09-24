package com.cellulant.payment.service;

import com.cellulant.payment.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TransactionService {

    private final Map<String, Transaction> transactionRepository = new ConcurrentHashMap<>();

    public Transaction processTransaction(Transaction request) {
        String transactionId = "TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        request.setId(transactionId);
        request.setStatus("SUCCESS");
        request.setTimestamp(Instant.now());

        transactionRepository.put(transactionId, request);
        return request;
    }

    public Optional<Transaction> getTransactionById(String id) {
        return Optional.ofNullable(transactionRepository.get(id));
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactionRepository.values());
    }
}