package furama_resort.services;

import furama_resort.models.Contracts;

import java.util.Queue;

public interface IContractsService {
    Queue <Contracts> readFile (String filePath);

    void writeFile (Contracts contracts, String filePath);

    void createContracts();

    void displayContracts();

    void editContracts(int number);
}
