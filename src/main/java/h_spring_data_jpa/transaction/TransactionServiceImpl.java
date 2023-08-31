package h_spring_data_jpa.transaction;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    @Override
    @Transactional
    public Long transferTransaction(Integer sender, Integer receiver, Long amount, String remark) {
        transactionRepository.transfer(sender,receiver,amount,remark);
        return amount;
    }
}
