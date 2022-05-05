package repository;

import DTO.ContractDTO;
import models.contract.Contract;

import java.util.List;

public interface IContractRepository {
    List<ContractDTO> contractList();

    void createContract(Contract contract);
}
