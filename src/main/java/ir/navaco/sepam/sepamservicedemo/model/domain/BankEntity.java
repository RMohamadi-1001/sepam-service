package ir.navaco.sepam.sepamservicedemo.model.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = BankEntity.BANK_NAME)
public class BankEntity {
    static final String BANK_NAME="MSPS_BANK";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BNK_ID")
    private Long id;

    @Column(name = "BNK_CODE", nullable = false)
    private Long code;

    @Column(name = "BNK_NAME", nullable = false)
    private String name;

    @Column(name = "BNK_BIN", nullable = true)
    private Long binCode;

    @Column(name = "BNK_IS_ACTIVE", nullable = true)
    private boolean active;

    @Column(name = "BNK_ABSTRACT", nullable = true)
    private String abstractCode;

}
