package h_spring_data_jpa.transaction;

public interface TransactionService {

    Long transferTransaction(Integer sender, Integer receiver, Long amount, String remark);
    
}
