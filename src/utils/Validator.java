package utils;

import java.util.Map;
import java.util.Set;

import data.Contract;

public class Validator {

    // Check valid for input Contract ID
    public static boolean isValidContractId(int contractId, Map<Integer, Contract> contractMap) {

        // Id should be positive
        // if (contractId <= 0) {
        // return false;
        // }

        // Avoid NullPointerException
        if (contractMap == null) {
            return false;
        }

        // Contract ID must be unique
        if (contractMap.containsKey(contractId)) {
            return false;
        }

        return true;
    }

    // Check valid for input Client ID
    public static boolean isValidClientId(int clientId, Set<Integer> clientIDSet) {

        // Avoid NullPointerException
        if (clientIDSet == null) {
            return false;
        }

        // Client ID must exist in the list of clients
        if (clientIDSet.contains(clientId)) {
            return true;
        }

        return false;
    }

    // Check valid for input Type ID
    public static boolean isValidTypeId(int contractTypeId, Set<Integer> contractTypeIDSet) {

        // Avoid NullPointerException
        if (contractTypeIDSet == null) {
            System.out.println();
            return false;
        }

        // Contract Type ID must exist in the list of contract types.
        if (contractTypeIDSet.contains(contractTypeId)) {
            return true;
        }

        return false;
    }

    // Check valid for input Contract Name
    public static boolean isValidContractName(String contractName) {

        // Contract Name must be at least 3 characters

        String NAME_REGEX = "^[\\w\\s]{3,}$";
        return contractName.matches(NAME_REGEX);
    }

    // Check valid for input Start Date
    public static boolean isValidStartDate(String startDate) {
        return true;
    }

    // Check valid for input End Date
    public static boolean isValidEndDate(String endDate) {
        return true;
    }

    // Check valid for input Total Value
    public static boolean isValidTotalValue(float totalValue) {
        return true;
    }

}
