package data;

public class Client {

    private int clientID;
    private String clientName;

    public Client() {
    }

    public Client(int clientID, String clientName) {
        this.clientID = clientID;
        this.clientName = clientName;
    }

    public int getClientId() {
        return clientID;
    }

    public void setClientId(int clientId) {
        this.clientID = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "-----------------------------" + System.lineSeparator() +
                "Client ID     : " + clientID + System.lineSeparator() +
                "Client Name   : " + clientName + System.lineSeparator() +
                "-----------------------------";
    }
}
