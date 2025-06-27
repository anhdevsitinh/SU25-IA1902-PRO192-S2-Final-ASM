package interfaces;

import java.util.List;

import data.Contract;

public interface ContractOperations {

    public void createContract(Contract contract);

    public void updateContract(int contractID, Contract contract);

    public boolean deleteContract(int contractID);

    public List<Contract> findContractsByName(String name);

    public List<Contract> listAllContracts();

    public boolean saveToFile(String url);
}
