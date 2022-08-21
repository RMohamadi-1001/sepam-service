package ir.navaco.sepam.sepamservicedemo.repository;

import ir.navaco.sepam.sepamservicedemo.model.domain.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<BranchEntity,Long> {
}
