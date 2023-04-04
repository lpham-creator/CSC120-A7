import java.util.ArrayList;
/**
 * A class representing a house.
 */
public class House extends Building {

  /**
   * ArrayList containing the names of the residents of the house.
   */
  private ArrayList<String> residents;
  /**
   * A boolean indicating whether or not the house has a dining room.
   */
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Constructor for a House object.
   * 
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors the number of floors in the house
   * @param hasDiningRoom a boolean indicating whether or not the house has a dining room
   * @param hasElevator a boolean indicating whether or not the house has an elevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
  }

  /**
   * Accessor method for hasDiningRoom.
   * 
   * @return a boolean indicating whether or not the house has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Accessor method for the number of residents in the house.
   * 
   * @return the number of residents in the house
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Method to add a new resident to the house.
   * 
   * @param name the name of the new resident
   * @throws RuntimeException if the resident is already in the house
   */
  public void moveIn(String name) {
    // check if this.residents contains name
    if (this.residents.contains(name)) {
      //   if so: throw and exception
      throw new RuntimeException(name + " is already a resident of " + this.getName());
    }
    // if we're good to go, add to roster
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.getName() + "! Go say hello :-)");
  }


  /*Overload method for roomates */
  public void moveIn(String name1, String name2) {
    // check if this.residents contains name
    if (this.residents.contains(name1) && this.residents.contains(name2)) {
      //   if so: throw and exception
      throw new RuntimeException(name1 + " and " + name2 + " are already residents of " + this.getName());
    }
    // if we're good to go, add to roster
    this.residents.add(name1);
    this.residents.add(name2);
    System.out.println(name1 + " and " + name2 + " have just moved into " + this.getName() + "! Go say hello :-)");
  }

  /*Overload method for suites */
  public void moveIn(String name1, String name2, String name3) {
    // check if this.residents contains name
    if (this.residents.contains(name1) && this.residents.contains(name2) && this.residents.contains(name3)) {
      //   if so: throw and exception
      throw new RuntimeException(name1 + ", " + name2 + " and " + name3 + " are already residents of " + this.getName());
    }
    // if we're good to go, add to roster
    this.residents.add(name1);
    this.residents.add(name2);
    this.residents.add(name3);
    System.out.println(name1 + ", " + name2 + " and " + name3 + " have just moved into " + this.getName() + "! Go say hello :-)");
  }

  /**
   * Returns a String representation of the House object.
   * 
   * @return a String representation of the House object
   */
  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }

  /**
   * Method to check if a given person is a resident of the house.
   * 
   * @param person the name of the person to check
   * @return true if the person is a resident, false otherwise
   */
  public boolean isResident(String person){
    // check if this.residents contains name
    if (this.residents.contains(person)) {
      return true;
    } else {
      return false;
    }
  }

  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn()");
  }

  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (this.hasElevator == true) {
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
  } else {
      if (Math.abs(this.activeFloor - floorNum) == 1) {
          System.out.println("You are now on floor #" + floorNum + " of " + this.name);
          this.activeFloor = floorNum;
      } else {
          throw new RuntimeException("The building does not have an elevator. You can only move between adjacent floors.");
      }
  }
}

  /**
   * Main method to create and test House objects.
   */
  public static void main(String[] args) {
    House morrow = new House("Morrow", "The Quad", 4, false, true);
    System.out.println(morrow);
    morrow.moveIn("Jordan");
    morrow.moveIn("Linh", "Alex", "Cho");
    System.out.println(morrow);
    House king = new House("King", "The Quad", 3, true, false);
    System.out.println(king);
    System.out.println(king.isResident("Jordan"));
    king.showOptions();
    morrow.enter();
    morrow.goToFloor(4);
    king.enter();
    king.goToFloor(3);
  }

}