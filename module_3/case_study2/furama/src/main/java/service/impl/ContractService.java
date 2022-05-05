package service.impl;

import DTO.ContractDTO;
import models.contract.Contract;
import repository.IContractRepository;
import repository.impl.ContractRepository;
import service.IContractService;

import java.util.List;

public class ContractService implements IContractService {
    IContractRepository contractRepository = new ContractRepository();
    @Override
    public List<ContractDTO> contractList() {
        return contractRepository.contractList();
    }

    @Override
    public void createContract(Contract contract) {
        contractRepository.createContract(contract);
    }
}
