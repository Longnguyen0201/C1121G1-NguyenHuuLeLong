package DTO;

public class ContractDTO {
    private Integer contractId;
    private String startDate;
    private String endDay;
    private Double deposit;
    private Double totalMoney;
    private String employeeName;
    private String customerName;
    private String serviceName;

    public ContractDTO(Integer contractId, String startDate, String endDay, Double deposit, Double totalMoney,
                       String employeeName, String customerName, String serviceName) {
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDay = endDay;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employeeName = employeeName;
        this.customerName = customerName;
        this.serviceName = serviceName;
    }

    public ContractDTO() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
