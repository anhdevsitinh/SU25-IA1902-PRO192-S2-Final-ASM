import services.ContractManagement;
import utils.InputHandler;

public class Main {
    public static void main(String[] args) {

        int choice;

        ContractManagement app = new ContractManagement();

        while (true) {

            app.showMenu();
            choice = InputHandler.getInt("Enter your choice: ", "Choice");

            switch (choice) {
                case 1:
                    System.out.println("=== Create New Contract ===");
                    break;
                case 2:
                    System.out.println("=== All Contracts List ===");
                    break;
                case 3:
                    System.out.println("=== Update Contract Information ===");
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