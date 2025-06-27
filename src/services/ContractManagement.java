package services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import data.Client;
import data.Contract;
import data.ContractType;
import interfaces.ContractOperations;
import utils.InputHandler;
import utils.Validator;

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
        contracts.add(new Contract(2, 12, 5, "Bravo Maintenance", "2023-05-01", "2024-05-01", 800000f));
        contracts.add(new Contract(13, 3, 2, "Alpha Consulting", "2024-01-01", "2024-12-31", 1000000f));
        contracts.add(new Contract(9, 6, 7, "Foxtrot Other", "2024-06-01", "2024-12-01", 2000000f));
        contracts.add(new Contract(3, 7, 6, "Golf Supply", "2024-02-01", "2024-08-31", 500000f));
        contracts.add(new Contract(11, 3, 2, "Alpha Consulting", "2024-01-01", "2024-12-31", 1000000f));
        contracts.add(new Contract(1, 4, 3, "Echo Leasing", "2022-01-01", "2022-12-31", 300000f));
        contracts.add(new Contract(14, 2, 4, "Delta Outsourcing", "2024-04-01", "2025-04-01", 1200000f));
        contracts.add(new Contract(4, 2, 4, "Delta Outsourcing", "2024-04-01", "2025-04-01", 1200000f));
        contracts.add(new Contract(6, 8, 2, "Hotel Consulting", "2024-07-01", "2025-07-01", 750000f));
        contracts.add(new Contract(7, 3, 2, "Alpha Consulting", "2024-01-01", "2024-12-31", 1000000f));
        contracts.add(new Contract(8, 9, 4, "India Maintenance", "2024-05-10", "2024-11-10", 900000f));
        contracts.add(new Contract(5, 10, 5, "Juliet Outsourcing", "2023-01-01", "2023-12-31", 1100000f));
        contracts.add(new Contract(10, 5, 1, "Charlie Service", "2024-03-01", "2024-09-01", 600000f));
        contracts.add(new Contract(12, 7, 6, "Golf Supply", "2024-02-01", "2024-08-31", 500000f));

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

    public void showClient() {

        System.out.println("-----------------------------");
        System.out.println("         List of Client      ");
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public void showContractType() {
        System.out.println("-----------------------------");
        System.out.println("    List of Contract Type    ");
        for (ContractType contractType : contractTypes) {
            System.out.println(contractType);
        }
    }

    public void showSelectionUpdateMenu() {
        System.out.println("=== Update Contract Menu ===");
        System.out.println("1. Client ID");
        System.out.println("2. Type ID");
        System.out.println("3. Contract Name");
        System.out.println("4. Start Date");
        System.out.println("5. End Date");
        System.out.println("6. Total Value");
        System.out.println("7. Exit Update Menu");
    }

    public void swapContract(List<Contract> resultList, int index1, int index2) {
        Contract tmp = resultList.get(index1);
        resultList.set(index1, resultList.get(index2));
        resultList.set(index2, tmp);
    }

    private void syncContractsList() {
        contracts.clear();
        contracts.addAll(contractMap.values());
    }

    @Override
    public void createContract(Contract contract) {
        System.out.println("=== Create New Contract ===");

        contract = new Contract();

        int contractID;
        int clientID;
        int typeID;
        String contractName;
        String startDate;
        String endDate;
        float totalValue;

        // contractID
        while (true) {
            contractID = InputHandler.getInt("Enter Contract ID: ", "Contract ID");

            if (!Validator.isValidContractId(contractID, contractMap)) {
                System.out.println("Contract ID is already exits. Try again!!!");
                // Adding "Contract ID must be positive if need"
                continue;
            }

            contract.setContractID(contractID);
            break;
        }

        // clientID
        while (true) {
            showClient();
            clientID = InputHandler.getInt("Enter Client ID: ", "Client ID");

            if (!Validator.isValidClientId(clientID, clientIDSet)) {
                System.out.println("Client ID must be exists in list of Clients. Try again!!!");
                continue;
            }

            contract.setClientID(clientID);
            break;
        }

        // typeID
        while (true) {
            showContractType();
            typeID = InputHandler.getInt("Enter Type ID: ", "Type ID");

            if (!Validator.isValidTypeId(typeID, typeIDSet)) {
                System.out.println("Type ID must be exists in list of Contract Type. Try again!!!");
                continue;
            }

            contract.setTypeID(typeID);
            break;
        }

        // contractName
        while (true) {
            contractName = InputHandler.getString("Enter Contract Name: ", "Contract Name");

            if (!Validator.isValidContractName(contractName)) {
                System.out.println("Contract Name must be at least 3 characters. Try again!!!");
                continue;
            }

            contract.setContractName(contractName);
            break;
        }

        // startDate
        while (true) {
            startDate = InputHandler.getString("Enter Start Date (yyyy-mm-dd): ", "Start Date");

            if (!Validator.isValidDate(startDate)) {
                System.out.println("Invalid Start Date or Invalid date format yyyy-mm-dd. Try again!!!");
                continue;
            }

            contract.setStartDate(startDate);
            break;
        }

        // endDate
        while (true) {
            endDate = InputHandler.getString("Enter End Date (yyyy-mm-dd): ", "End Date");

            if (!Validator.isValidEndDate(startDate, endDate)) {
                System.out.println("Invalid End Date or Invalid date format yyyy-mm-dd. Try again!!!");
                continue;
            }

            contract.setEndDate(endDate);
            break;
        }

        // totalValue
        while (true) {
            totalValue = InputHandler.getFloat("Enter Total Value: ", "Total Value");

            if (!Validator.isValidTotalValue(totalValue)) {
                System.out.println("Total vale must be positive. Try again!!!");
                continue;
            }

            contract.setTotalValue(totalValue);
            break;
        }
        contracts.add(contract);
        contractMap.put(contractID, contract);
        System.out.println("=== Contract Created Successfully ===");
        System.out.println(contract);

    }

    @Override
    public List<Contract> listAllContracts() {
        System.out.println("=== All Contracts List ===");

        if (contracts.isEmpty() || contractMap.isEmpty()) {
            System.out.println("Nothing to display");
            return null;
        }
        // Display a list of all contracts, sorted alphabetically by contract name.
        // if names match, sort by Contract ID ascending.
        List<Contract> resultList = new ArrayList<>(contracts); // shallow copy

        // // Hardcore sort
        // for (int i = 0; i < resultList.size() - 1; i++) {
        // for (int j = 0; j < resultList.size() - i - 1; j++) {

        // String o1Name = resultList.get(j).getContractName();
        // String o2Name = resultList.get(j + 1).getContractName();
        // int o1ContractID = resultList.get(j).getContractID();
        // int o2ContractID = resultList.get(j + 1).getContractID();

        // if (o1Name.compareToIgnoreCase(o2Name) > 0) {

        // swapContract(resultList, j, j + 1);
        // }

        // if (o1Name.compareToIgnoreCase(o2Name) == 0) {
        // if (o1ContractID > o2ContractID) {
        // swapContract(resultList, j, j + 1);
        // }
        // }

        // }
        // }

        Comparator<Contract> BY_NAME_THEN_CONTRACTID = Comparator.comparing(Contract::getContractName)
                .thenComparing(Contract::getContractID);

        resultList.sort(BY_NAME_THEN_CONTRACTID);

        for (Contract contract : resultList) {
            System.out.println(contract);
        }

        return resultList;
    }

    @Override
    public void updateContract(int contractID, Contract contract) {
        // Use hashMap instead contract
        // ContractID will handle here

        System.out.println("=== Update Contract ===");

        int clientID;
        int typeID;
        String contractName;
        String startDate;
        String endDate;
        float totalValue;

        contractID = InputHandler.getInt("Enter Contract ID for update: ", "Contract ID");

        if (contractMap.isEmpty()) {
            System.out.println("Nothing to update");
            System.out.println("Update failed!!!");
            return;
        }

        if (!contractMap.containsKey(contractID)) {
            System.out.println("Contract not found");
            System.out.println("Update failed!!!");
            return;
        }

        int choice;

        while (true) {
            showSelectionUpdateMenu();
            choice = InputHandler.getInt("Enter the number you want to update: ", "Number", 1, 7);

            switch (choice) {
                case 1:
                    System.out.println("=== Updating Client ID.....");
                    System.out.println();

                    while (true) {
                        showClient();
                        clientID = InputHandler.getInt("Enter new Client Id: ", "Client Id");

                        if (!Validator.isValidClientId(clientID, clientIDSet)) {
                            System.out.println("Client ID must be exists in list of Clients. Try again!!!");
                            continue;
                        }

                        break;
                    }

                    contractMap.get(contractID).setClientID(clientID);
                    break;
                case 2:

                    System.out.println("Updating Type ID....");
                    System.out.println();

                    while (true) {
                        showContractType();
                        typeID = InputHandler.getInt("Enter new Type ID: ", "Type ID");

                        if (!Validator.isValidTypeId(typeID, typeIDSet)) {
                            System.out.println("Type ID must be exists in list of Contract Type. Try again!!!");
                            continue;
                        }

                        contractMap.get(contractID).setTypeID(typeID);
                        break;
                    }

                    break;
                case 3:

                    System.out.println("Updating Contract Name....");
                    System.out.println();

                    while (true) {
                        contractName = InputHandler.getString("Enter new Contract Name: ", "Contract Name");

                        if (!Validator.isValidContractName(contractName)) {
                            System.out.println("Contract Name must be at least 3 characters. Try again!!!");
                            continue;
                        }

                        contractMap.get(contractID).setContractName(contractName);
                        break;
                    }

                    break;
                case 4:
                    System.out.println("Updating Contract Start Date....");
                    System.out.println();

                    while (true) {
                        startDate = InputHandler.getString("Enter new Start Date (yyyy-mm-dd): ", "Start Date");
                        endDate = contractMap.get(contractID).getEndDate();

                        if (!Validator.isValidDate(startDate)) {
                            System.out.println("Invalid Start Date or Invalid date format yyyy-mm-dd. Try again!!!");
                            continue;
                        }

                        if (!Validator.isValidDateRange(startDate, endDate)) {
                            System.out.println("Start Date must before End Date. Try again!!!");
                            continue;
                        }

                        contractMap.get(contractID).setStartDate(startDate);
                        break;
                    }

                    break;
                case 5:
                    System.out.println("Updating Contract End Date....");
                    System.out.println();

                    while (true) {
                        startDate = contractMap.get(contractID).getStartDate();
                        endDate = InputHandler.getString("Enter new End Date (yyyy-mm-dd): ", "End Date");

                        if (!Validator.isValidEndDate(startDate, endDate)) {
                            System.out.println("Invalid End Date or Invalid date format yyyy-mm-dd. Try again!!!");
                            continue;
                        }

                        contractMap.get(contractID).setEndDate(endDate);
                        break;
                    }

                    break;
                case 6:
                    System.out.println("Updating Contract Total Value....");
                    System.out.println();

                    while (true) {
                        totalValue = InputHandler.getFloat("Enter new Total Value: ", "Total Value");

                        if (!Validator.isValidTotalValue(totalValue)) {
                            System.out.println("Total vale must be positive. Try again!!!");
                            continue;
                        }

                        contractMap.get(contractID).setTotalValue(totalValue);
                        break;
                    }
                    break;

                case 7:
                    System.out.println("Update successful");
                    syncContractsList();
                    return;
            }

        }

    }

    @Override
    public boolean deleteContract(int contractID) {
        System.out.println("=== Delete Contract ===");

        if (contractMap.isEmpty()) {
            System.out.println("Nothing Contract to delete");
            System.out.println("Delete failed");
            return false;
        }

        contractID = InputHandler.getInt("Enter Contract ID of Contract you want to delete: ", "Contract ID");

        if (!contractMap.containsKey(contractID)) {
            System.out.println("Contract not found");
            System.out.println("Delete failed");
            return false;
        }

        System.out.println("Contract: ");
        System.out.println(contractMap.get(contractID));

        contractMap.remove(contractID);
        syncContractsList();

        System.out.println("Delete successful");
        return true;
    }

    @Override
    public List<Contract> findContractsByName(String name) {
        System.out.println("=== Find Contracts by Name ===");

        List<Contract> resultList = new ArrayList<>();

        name = InputHandler.getString("Enter Name of Contract you want to display: ", "Name");

        System.out.println("=== Find Contracts by Name ===");

        for (Contract contract : contracts) {
            if (contract.getContractName().equalsIgnoreCase(name)) {
                resultList.add(contract);
            }
        }

        Comparator<Contract> BY_NAME_THEN_CONTRACTID = Comparator.comparing(Contract::getContractName)
                .thenComparing(Contract::getContractID);

        resultList.sort(BY_NAME_THEN_CONTRACTID);

        for (Contract contract : resultList) {
            System.out.println(contract);
        }

        return resultList;
    }

    @Override
    public boolean saveToFile(String url) {
        System.out.println("=== Save Contracts to File ===");

        File f = new File(url);

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f))) {
            for (Contract contract : contracts) {
                writer.write(contract.toString());
                writer.write("\n");
            }
            writer.flush();
            System.out.println("Save file successful");
            return true;
        } catch (Exception e) {
            System.out.println("Save file error: " + e);
            return false;
        }
    }

    public static void main(String[] args) {
        int choice;
        ContractManagement app = new ContractManagement();
        while (true) {
            app.showMenu();
            choice = utils.InputHandler.getInt("Enter your choice: ", "Choice", 1, 7);
            System.out.println();
            System.out.println();
            switch (choice) {
                case 1:
                    app.createContract(null);
                    break;
                case 2:
                    app.listAllContracts();
                    break;
                case 3:
                    app.updateContract(-1, null);
                    break;
                case 4:
                    app.deleteContract(-1);
                    break;
                case 5:
                    app.findContractsByName(null);
                    break;
                case 6:
                    app.saveToFile("car.txt");
                    break;
                case 7:
                    System.out.println("See you again <3");
                    break;
            }
            if (choice == 7) {
                break;
            }
        }
    }
}
