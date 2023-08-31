package h_spring_data_jpa.transaction.web;

import h_spring_data_jpa.transaction.TransactionService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PatchMapping("/transfer")
    public ResponseEntity<?>transfers(@RequestParam("sender") Integer sender,
                                      @RequestParam("receiver") Integer receiver,
                                      @RequestParam("amount") Long amount,
                                      @RequestParam("remark") String remark){

        transactionService.transferTransaction(sender,receiver,amount,remark);
        Map<String,String>stringMap= new HashMap<>();
        stringMap.put("Transfer money successful",amount+"$");
        stringMap.put("remark",remark);
        stringMap.put("transfer","successful");
        stringMap.put("status", HttpStatus.OK.toString());

        return ResponseEntity.ok(stringMap);
    }


}
