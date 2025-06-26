import data.Contract;
import services.ContractManagement;
import utils.InputHandler;

public class Main {
    public static void main(String[] args) {

        int choice;

        ContractManagement app = new ContractManagement();

        while (true) {

            app.showMenu();
            choice = InputHandler.getInt("Enter your choice: ", "Choice", 1, 7);
            System.out.println();
            System.out.println();

            switch (choice) {
                case 1:
                    Contract newContract = new Contract();
                    app.createContract(newContract);
                    break;
                case 2:
                    app.listAllContracts();
                    break;
                case 3:
                    // Just for clean code xd :3
                    app.updateContract(-1, null);
                    break;
                case 4:
                    System.out.println("=== Delete Contract ===");
                    break;
                case 5:
                    System.out.println("=== Find Contracts by Name ===");
                    break;
                case 6:
                    System.out.println("=== Save Contracts to File ===");
                    break;
                case 7:
                    System.out.println("=== See you again <3 ===");
                    break;
            }

            if (choice == 7) {
                break;
            }

        }

    }
}
