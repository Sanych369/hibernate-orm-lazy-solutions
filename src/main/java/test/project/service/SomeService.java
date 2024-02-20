package test.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SomeService {
    private final TransactionService transactionService;
    private final NonTransactionService nonTransactionService;


    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
    private void nonTransactMethod() {
        transactionService.prepareDb();
        final var parent = transactionService.startParentWithChild();
        nonTransactionService.getChild(parent);
    }


}
