package ir.navaco.sepam.sepamservicedemo.service;

import ir.navaco.sepam.sepamservicedemo.model.domain.BankEntity;
import ir.navaco.sepam.sepamservicedemo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public BankEntity getBank(Long code) {
        final BankEntity bankE = new BankEntity();
        bankE.setCode(1111L);
        bankE.setActive(true);
        bankE.setName("Bank Maskan");
        //bankRepository.save(bankE);

        //Optional<BankEntity> bankEntity = bankRepository.findByCode(code);
       // return bankEntity.orElse(null);
        return bankE;
    }
    
}
