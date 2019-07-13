package repositories;

import dataLayer.dataMappers.transaction.TransactionMapper;
import entities.Transaction;

import java.util.UUID;

public class TransactionsRepository {
    public void storeTransaction(String date, String userId, Integer ticketId, Integer ticketsCount) {
        Transaction transaction = new Transaction(UUID.randomUUID().toString(), date, userId, ticketId, "payed", ticketsCount);
        TransactionMapper.storeTransaction(transaction);
    }
}
