package h_spring_data_jpa.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    @Procedure
    void transfer(
            @Param("sender") Integer sender,
            @Param("receiver") Integer receiver,
            @Param("amount") Long amount,
            @Param("remark") String remark
            );

}
