package data;

public class ContractType {
    private int typeID;
    private String typeName;

    public ContractType() {
    }

    public ContractType(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "-----------------------------" + System.lineSeparator() +
                "Type ID       : " + typeID + System.lineSeparator() +
                "Type Name     : " + typeName + System.lineSeparator() +
                "-----------------------------";
    }
}
