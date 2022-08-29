package ir.navaco.sepam.sepamservicedemo.repository;

import ir.navaco.sepam.sepamservicedemo.model.domain.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "branch", path = "branchs")
public interface BranchRepository extends JpaRepository<BranchEntity,Long> {
    BranchEntity findByCode(@Param("code") Long code);
}
