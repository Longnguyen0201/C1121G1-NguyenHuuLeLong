package models.contract;

public class ContractDetail {
    private Integer contractDetailId;
    private Integer contractId;
    private Integer attachServiceId;
    private Integer quantity;

    public ContractDetail() {
    }

    public ContractDetail(Integer contractDetailId, Integer contractId, Integer attachServiceId, Integer quantity) {
        this.contractDetailId = contractDetailId;
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Integer attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
