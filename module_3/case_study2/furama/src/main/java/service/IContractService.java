package service;

import DTO.ContractDTO;
import models.contract.Contract;

import java.util.List;

public interface IContractService {
    List<ContractDTO> contractList();

    void createContract(Contract contract);
}
