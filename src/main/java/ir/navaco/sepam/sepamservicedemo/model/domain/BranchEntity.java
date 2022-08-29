package ir.navaco.sepam.sepamservicedemo.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = BranchEntity.TABLE_NAME)
@Getter
@Setter
@Builder
public class BranchEntity {
    static final String TABLE_NAME = "MSPS_BRANCH";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRN_ID")
    private Long id;

    @Column(name = "BRN_CODE", nullable = true)
    private Long code;

    @Column(name = "BRN_NAME", nullable = true)
    private String name;

    @Column(name = "BRN_ADDRESS", nullable = true)
    private String address;

    @Column(name = "BRN_TEL1", nullable = true)
    private String tel1;

    @Column(name = "BRN_TEL2", nullable = true)
    private String tel2;

    @Column(name = "BRN_FAX", nullable = true)
    private String fax;

    @Column(name = "BRN_IS_MGM", nullable = true)
    private boolean isManagement;

    @Column(name = "BRN_SEPAM_CODE", nullable = true)
    private String sepamCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BNK_ID_FK", referencedColumnName = "BNK_ID", nullable = true)
    private BankEntity bank;
}
