package com.codegym.model.contract;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Integer contractDetailId;
    @NotNull
    private Integer quantity;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "contract_id")
    private Contract contract;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "attach_service_id", referencedColumnName = "attach_service_id")
    private AttachService attachService;

    public ContractDetail() {
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
