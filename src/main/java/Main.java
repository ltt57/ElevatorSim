import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); // Getting user inputs
    Elevator elevator = new Elevator(); // Elevator object

    System.out.println("[ |--------ELEVATOR--------| ]");
    System.out.println("[ |    1 | 2 | 3 | 4 | 5   | ]");
    System.out.println("[ |------------------------| ]");
    System.out.println("[ |------------------------| ]");
    System.out.println("[ |   [  ]   |  |   [  ]   | ]");
    System.out.println("[ |   [  ]   |  |   [  ]   | ]");
    System.out.println("[ |   [  ]   |  |   [  ]   | ]");
    System.out.println("[ |   [  ]   |  |   [  ]   | ]");
    System.out.println("[ |   [  ]   |  |   [  ]   | ]");
    System.out.println("[ |------------------------| ]");
    System.out.println("[ |------------------------| ]");
    System.out.println("[ |------------------------| ]");

    System.out.print("\nEnter Floor Number [1-5] or [exit] to leave: ");

    while (true) {
        String opt = scanner.nextLine().trim().toLowerCase(); // Read user input

      // Exit option
      if ("exit".equals(opt)) {
        System.out.println("Cya Later!");
        break;
      } 
        
      // Floor options 1-4
      else if ("1".equals(opt) || "2".equals(opt) || "3".equals(opt) || "4".equals(opt))
      {
        int floor = Integer.parseInt(opt);
        elevator.goToFloor(floor);
        elevator.openDoor();
        System.out.println("\n[  Press Enter to Close Door  ]");
        scanner.nextLine();
        elevator.closeDoor();
      } 

      /**
      ***----------FLOOR 5-----------***
      **********************************
      SPECIAL ACCESS - PASSKEY REQUIRED
      Passkey: 1234
      *********************************
      ----------------------------------
      **/
        
    // Floor 5 option
      else if ("5".equals(opt)) { 
        boolean accessGranted = false; // Access control

        while (!accessGranted) { 
                System.out.print("Enter Passkey to Access (HINT: 1234): ");
                String passkey = scanner.nextLine().trim();

                if (passkey.equals("1234")) {
                    System.out.println("Access Granted!");
                    accessGranted = true;
                } else {
                    System.out.println("Ooops, invalid passkey... Please try again!");
                }
            }

            int floor = Integer.parseInt(opt);
            elevator.goToFloor(floor);
            elevator.openDoor();
            System.out.println("\n[  Press Enter to Close Door  ]");
            scanner.nextLine();
            elevator.closeDoor();
        } else {
            System.out.println("Ooops, invalid input! Please enter a floor number [1-5] or [exit]:");
            continue;
        }

        /**
         **************ELEVATOR MOVEMENT*************
         ********************************************
         
         Movement options: [+] UP or [-] DOWN
         ********************************************
         ********************************************
        **/
        while (true) {
            System.out.print("\nEnter [+] to go UP, [-] to go DOWN, or [exit]: ");
            String direction = scanner.nextLine().trim();

            if (!direction.equals("+") && !direction.equals("-") && !direction.equalsIgnoreCase("exit")) {
                System.out.println("Ooops, invalid entry! Please enter [+] to go UP, [-] to go DOWN, or [exit].");
                continue;
            }

          // Exit option 
            if (direction.equalsIgnoreCase("exit")) {
                System.out.println("Cya Later!");
                System.exit(0);
            }

          
          // Floor movement restrictions
            if (elevator.getCurrentFloor() == 5 && direction.equals("+")) {
                System.out.println("You've reached the highest floor, you can only go DOWN!");
                continue;
            }
            if (elevator.getCurrentFloor() == 1 && direction.equals("-")) {
                System.out.println("You're on the lowest floor, you can only go UP!");
                continue;
            }

          // Floor movement options
            if (direction.equals("+")) {
                System.out.print("Select a Floor ABOVE " + elevator.getCurrentFloor() + ": ");
            } else {
                System.out.print("Select a Floor BELOW " + elevator.getCurrentFloor() + ": ");
            }

            int nextFloor = scanner.nextInt();
            scanner.nextLine();

          // Validate floor movement UP or DOWN
            if ((direction.equals("-") && nextFloor > elevator.getCurrentFloor()) ||
                (direction.equals("+") && nextFloor < elevator.getCurrentFloor())) {
                System.out.println("Ooops, invalid choice! You selected a floor in the wrong direction.");
                continue;
            }
          
          // Special access for Floor 5
            if (nextFloor == 5) {
                boolean accessGranted = false;

                while (!accessGranted) { 
                    System.out.print("Enter Passkey to Access (HINT: 1234): ");
                    String passkey = scanner.nextLine().trim();

                    if (passkey.equals("1234")) {
                        System.out.println("Access Granted!");
                        accessGranted = true;
                    } else {
                        System.out.println("Ooops, invalid passkey... Please try again!");
                    }
                }
            }
          
          // Elevator movement 
            if (nextFloor >= 1 && nextFloor <= 5) {
                elevator.closeDoor();
                elevator.goToFloor(nextFloor);
                elevator.openDoor();
            } else {
                System.out.println("Ooops, invalid choice! Pick a floor between 1 and 5.");
            }
        }
    }

    scanner.close();
  }
}
