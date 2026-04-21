package io.github.giannihonda.libraryapi.repository;

import io.github.giannihonda.libraryapi.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransactionsTest {

    @Autowired
    TransactionService transactionService;

    /**
     * Commit -> confirm changes
     * Rollback -> undo the changes
     */
    @Test
    void simpleTransaction(){
        transactionService.execute();
    }
}
