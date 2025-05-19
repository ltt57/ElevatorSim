public class Elevator {
  private int currentFloor = 1;

  public void goToFloor(int floor) {
    System.out.println(" ");
    System.out.println("Elevator Going...\n");

    if (floor > currentFloor) {
      for (int i = currentFloor + 1; i <= floor; i++) {
        System.out.println("[------On Floor " + i + "-------] \n");
      }
    } else if (floor < currentFloor) {
      for (int i = currentFloor - 1; i >= floor; i--) {
        System.out.println("[-------On Floor " + i + "-------] \n");
      }
    }

    currentFloor = floor;
  }

  public void openDoor() {
    System.out.println("Door Opening...\n");
    System.out.println("[ |--------ELEVATOR--------| ]");
    System.out.println("[ |         Floor " + currentFloor + "        | ]");
    System.out.println("[ |------------------------| ]");
    System.out.println("[ |------------------------| ]");
    System.out.println("[ |[  ] |            | [  ]| ]");
    System.out.println("[ |[  ] |            | [  ]| ]");
    System.out.println("[ |[  ] |            | [  ]| ]");
    System.out.println("[ |[  ] |            | [  ]| ]");
    System.out.println("[ |[  ] |            | [  ]| ]");
    System.out.println("[ |------------------------| ]");
    System.out.println("[ |------------------------| ]");
    System.out.println("[ |------------------------| ]");
  }

  public void closeDoor() {
    System.out.println("\n Door Closing...\n");
    System.out.println("[ |--------ELEVATOR--------| ]");
    System.out.println("[ |         Floor " + currentFloor + "        | ]");
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

    }

  public int getCurrentFloor() 
  {
    return currentFloor; 
  }
  
}