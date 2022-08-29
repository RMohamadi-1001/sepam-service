package ir.navaco.sepam.sepamservicedemo.repository;

import ir.navaco.sepam.sepamservicedemo.model.domain.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<BankEntity,Long> {

    Optional<BankEntity> findByCode(Long code);
}
