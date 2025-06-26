package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Map;
import java.util.Set;

import data.Contract;

public class Validator {

    // Check valid for input Contract ID
    public static boolean isValidContractId(int contractId, Map<Integer, Contract> contractMap) {

        // // Id <= 0 => false
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

    public static boolean isValidDate(String date) {

        DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd")
                .withResolverStyle(ResolverStyle.STRICT); // fix date strictly
        // strict: 31-6 throw error
        // lenient: 31-6 to 1-7
        // smart is smart

        try {
            DATE_FORMATTER.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }

    }

    public static boolean isValidDateRange(String startDate, String endDate) {
        if (!isValidDate(startDate) || !isValidDate(endDate)) {
            return false;
        }

        LocalDate starDateLocal = LocalDate.parse(startDate);
        LocalDate endDateLocal = LocalDate.parse(endDate);

        if (starDateLocal.isAfter(endDateLocal)) {
            return false;
        }

        return true;
    }

    public static boolean isValidStartDate(String startDate) {

        return isValidDate(startDate);
    }

    // Check valid for input End Date
    public static boolean isValidEndDate(String startDate, String endDate) {

        // Case if people don't input startDate
        if (startDate == null) {
            return false;
        }

        return isValidDateRange(startDate, endDate);
    }

    // Check valid for input Total Value
    public static boolean isValidTotalValue(float totalValue) {

        // Total Value must be positive.

        return totalValue > 0;
    }

}
