package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.Client;
import data.Contract;
import data.ContractType;
import interfaces.ContractOperations;

public class ContractManagement implements ContractOperations {
    private ArrayList<Contract> contracts;
    private ArrayList<Client> clients;
    private ArrayList<ContractType> contractTypes;
    private Set<Integer> clientIDSet;
    private Set<Integer> typeIDSet;
    private Map<Integer, Contract> contractMap;

    public ContractManagement() {
        this.contracts = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.contractTypes = new ArrayList<>();
        this.clientIDSet = new HashSet<>();
        this.typeIDSet = new HashSet<>();
        this.contractMap = new HashMap<>();

        initializeData();

    }

    public void initializeData() {
        // Initial Clients
        clients.add(new Client(1, "Vietcombank"));
        clients.add(new Client(2, "FPT Software"));
        clients.add(new Client(3, "Vinamilk"));
        clients.add(new Client(4, "Hoa Phat Group"));
        clients.add(new Client(5, "Mobile World"));
        clients.add(new Client(6, "Masan Group"));
        clients.add(new Client(7, "Vingroup"));
        clients.add(new Client(8, "Viettel"));
        clients.add(new Client(9, "PetroVietnam"));
        clients.add(new Client(10, "SABECO"));

        for (Client client : clients) {
            clientIDSet.add(client.getClientId());
        }

        // Initial Contract Types ID
        contractTypes.add(new ContractType(1, "Service"));
        contractTypes.add(new ContractType(2, "Supply"));
        contractTypes.add(new ContractType(3, "Consulting"));
        contractTypes.add(new ContractType(4, "Maintenance"));
        contractTypes.add(new ContractType(5, "Outsourcing"));
        contractTypes.add(new ContractType(6, "Leasing"));
        contractTypes.add(new ContractType(7, "Other"));

        for (ContractType type : contractTypes) {
            typeIDSet.add(type.getTypeID());
        }

        // Use for testing
        contracts.add(new Contract(7, 3, 2, "Alpha Consulting", "2024-01-01", "2024-12-31", 1000000f));
        contracts.add(new Contract(2, 1, 5, "Bravo Maintenance", "2023-05-01", "2024-05-01", 800000f));
        contracts.add(new Contract(10, 5, 1, "Charlie Service", "2024-03-01", "2024-09-01", 600000f));
        contracts.add(new Contract(4, 2, 4, "Delta Outsourcing", "2024-04-01", "2025-04-01", 1200000f));
        contracts.add(new Contract(1, 4, 3, "Echo Leasing", "2022-01-01", "2022-12-31", 300000f));
        contracts.add(new Contract(9, 6, 7, "Foxtrot Other", "2024-06-01", "2024-12-01", 2000000f));
        contracts.add(new Contract(3, 7, 6, "Golf Supply", "2024-02-01", "2024-08-31", 500000f));
        contracts.add(new Contract(6, 8, 2, "Hotel Consulting", "2024-07-01", "2025-07-01", 750000f));
        contracts.add(new Contract(8, 9, 4, "India Maintenance", "2024-05-10", "2024-11-10", 900000f));
        contracts.add(new Contract(5, 10, 5, "Juliet Outsourcing", "2023-01-01", "2023-12-31", 1100000f));

        for (Contract contract : contracts) {
            contractMap.put(contract.getContractID(), contract);
        }

    }

    public void showMenu() {
        System.out.println("==============================");
        System.out.println("  Contract Management Menu");
        System.out.println("==============================");
        System.out.println("1. Create Contract");
        System.out.println("2. Display All Contracts");
        System.out.println("3. Update Contract");
        System.out.println("4. Delete Contract");
        System.out.println("5. Find Contracts by Name");
        System.out.println("6. Save to file");
        System.out.println("7. Exit");
        System.out.println("==============================");
    }

    @Override
    public void createContract(Contract contract) {

    }

    @Override
    public void updateContract(int ContractID, Contract contract) {
    }

    @Override
    public boolean deleteContract(int contractID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteContract'");
    }

    @Override
    public List<Contract> findContractsByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findContractsByName'");
    }

    @Override
    public List<Contract> listAllContracts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAllContracts'");
    }
}
