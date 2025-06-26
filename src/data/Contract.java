package data;

public class Contract {
    private int contractID;
    private int clientID;
    private int typeID;
    private String contractName;
    private String startDate;
    private String endDate;
    private float totalValue;

    public Contract() {
    }

    public Contract(int contractID, int clientID, int typeID, String contractName, String startDate, String endDate,
            float totalValue) {
        this.contractID = contractID;
        this.clientID = clientID;
        this.typeID = typeID;
        this.contractName = contractName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalValue = totalValue;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        // System.lineSeprator() : return "\r\n" on window, \n on Linux/macOS
        // (match with any OS)
        return "-----------------------------" + System.lineSeparator() +
                "Contract ID   : " + contractID + System.lineSeparator() +
                "Client ID     : " + clientID + System.lineSeparator() +
                "Type ID       : " + typeID + System.lineSeparator() +
                "Name          : " + contractName + System.lineSeparator() +
                "Start Date    : " + startDate + System.lineSeparator() +
                "End Date      : " + endDate + System.lineSeparator() +
                "Total Value   : " + String.format("%.2f", totalValue) + System.lineSeparator() +
                "-----------------------------";
    }
}
