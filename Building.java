/**
 * This class represents a building with a name, address, number of floors, and a method to navigate within it.
 */
public class Building {

    /** The name of the building */
    protected String name;
  
    /** The address of the building */
    protected String address;
  
    /** The number of floors in the building */
    protected int nFloors;
  
    /**
     * The active floor in the building, which represents the floor that the user is currently on. 
     * The default value is -1, indicating that the user is not inside the building.
     */
    protected int activeFloor = -1;
  
    /**
     * Constructs a building with default values for name, address, and number of floors.
     */
    public Building() {
      this("<Name Unknown>", "<Address Unknown>", 1);
    }
  
    /**
     * Constructs a building with a given address and default values for name and number of floors.
     * @param address The address of the building
     */
    public Building(String address) {
      this(); // Call default constructor
      this.address = address; // Override address
    }
  
    /**
     * Constructs a building with a given name, address, and number of floors.
     * @param name The name of the building
     * @param address The address of the building
     * @param nFloors The number of floors in the building
     * @throws RuntimeException if the number of floors is less than 1
     */
    public Building(String name, String address, int nFloors) {
      if (name != null) {
        this.name = name;
      }
      if (address != null) {
        this.address = address;
      }
      if (nFloors < 1) {
        throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
      }
      this.nFloors = nFloors;
    }
  
    /**
     * Returns the name of the building.
     * @return The name of the building
     */
    public String getName() {
      return this.name;
    }
  
    /**
     * Returns the address of the building.
     * @return The address of the building
     */
    public String getAddress() {
      return this.address;
    }
  
    /**
     * Returns the number of floors in the building.
     * @return The number of floors in the building
     */
    public int getFloors() {
      return this.nFloors;
    }
  
    /**
     * Enters the building and sets the active floor to the ground floor.
     * @return A pointer to the current building
     * @throws RuntimeException if the user is already inside the building
     */
    public Building enter() {
      if (activeFloor != -1) {
        throw new RuntimeException("You are already inside this Building.");
      }
      this.activeFloor = 1;
      System.out.println("You are now inside " + this.name + " on the ground floor.");
      return this; // Return a pointer to the current building
    }
  
    /**
     * Exits the building and sets the active floor to -1.
     * @return Null, as the user is now outside the building
     * @throws RuntimeException if the user is not inside the building
     * @throws RuntimeException if the user has fallen out a window from a floor above the ground floor
     */
    public Building exit() {
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
      }
      if (this.activeFloor > 1) {
        throw new RuntimeException("You have fallen out a window from floor #" + this.activeFloor + "!");
      }
      System.out.println("You have left " + this.name + ".");
      this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
      return null; // We're outside now, so the building is null
    }
  
    /**
     * Navigates to a specified floor.
     * @param floorNum the floor number to navigate to
     * @throws RuntimeException if the user is not currently inside the building or the specified floor number is invalid
     */
    public void goToFloor(int floorNum) {
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
      }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    }
  
    /**
     * Navigates to the next floor up.
     */
    public void goUp() {
      this.goToFloor(this.activeFloor + 1);
    }
  
    /**
     * Navigates to the next floor down.
     */
    public void goDown() {
      this.goToFloor(this.activeFloor - 1);
    }
  
    /**
     * Displays a list of available options.
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }
  
    /**
     * Returns a string representation of the building.
     * @return a string representation of the building
     */
    public String toString() {
      return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }
  
    /**
     * A test main method for the Building class.
     */
    public static void main(String[] args) {
      System.out.println("------------------------------------");
      System.out.println("Test of Building constructor/methods");
      System.out.println("------------------------------------");
  
      Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
      System.out.println(fordHall);
      fordHall.showOptions();
  
      System.out.println("-----------------------------------");
      System.out.println("Demonstrating enter/exit/navigation");
      System.out.println("-----------------------------------");
      fordHall.enter();
      fordHall.goUp();
      fordHall.goDown();
      fordHall.exit();
    }
  
  }