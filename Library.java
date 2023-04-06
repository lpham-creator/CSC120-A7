import java.util.Hashtable;
/**
 * Constructs a new Library object with no books in its collection.
 */
public class Library extends Building {

  /**
   * The collection of books in the Library, stored as a Hashtable with book titles as keys and availability status as values.
   */
  private Hashtable < String, Boolean > collection;
  private boolean hasElevator;

  /**
   * Constructs a Library object with the specified name, address, and number of floors.
   *
   * @param name the name of the Library
   * @param address the address of the Library
   * @param nFloors the number of floors in the Library
   * @param hasElevator whether the Library has an elevator
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    System.out.println("You have built a library: 📚");
    this.collection = new Hashtable < String, Boolean > ();
    this.hasElevator = hasElevator;
  }

  /**
   * Returns true if the given title appears as a key in the Library's collection, false otherwise.
   *
   * @param title the title of the book to search for
   * @return true if the title appears in the collection, false otherwise
   */
  public boolean containsTitle(String title) {
    if (this.collection.containsKey(title)) {
      return true;
    } else {
      return false;
    }

  } // returns true if the title appears as a key in the Libary's collection, false otherwise

  /**
   * Returns true if the book with the given title is available in the Library, false otherwise.
   *
   * @param title the title of the book to check availability for
   * @return true if the book is available, false otherwise
   */
  public boolean isAvailable(String title) {
    if (this.collection.get(title) == true) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Adds a book's title to the library's collection.
   * 
   * @param title the title of the book to be added
   * @throws RuntimeException if the book is already in the collection
   */
  public void addTitle(String title) {
    if (this.containsTitle(title) == true) {
      throw new RuntimeException(title + " is already in the collection.");
    } else {
      this.collection.put(title, true);
    }
  }

  /**
   * Removes a book from the library's collection.
   * 
   * @param title the title of the book to be removed
   * @return the title of the removed book
   * @throws RuntimeException if the book is not in the collection
   */
  public String removeTitle(String title) {
    if (this.containsTitle(title) != true) {
      throw new RuntimeException(title + " is not in the collection.");
    } else {
      this.collection.remove(title);
      System.out.println("Successfully removed" + title + "from the collection!");
      return title;
    }
  }

  /**
   * Prints the Library's collection of books and their availability status.
   */
  public void printCollection() {
    System.out.println("Library collection:");
    if (this.collection.isEmpty()) {
      System.out.println("There's no book in this collection yet.");
    } else {
      for (String title: collection.keySet()) {
        Boolean status = collection.get(title);
        String availability = (status == null ? "unknown" : (status ? "available" : "checked out"));
        System.out.println("- " + title + " (" + availability + ")");
      }
    }
  }

  /**
   * Checks out the book with the given title from the Library.
   * 
   * @param title the title of the book to be checked out
   * @throws RuntimeException if the book is not in the collection
   */
  public void checkOut(String title) {
    if (this.containsTitle(title) != true) {
      throw new RuntimeException(title + " is not in the collection.");
    } else {
      collection.replace(title, false);
      System.out.println("Successfully checked out" + " " + title);
    }
  }

  /**
   * Checks out two (2) books with the given title from the Library.
   * 
   * @param title the title of the book to be checked out
   * @throws RuntimeException if the book is not in the collection
   */
  public void checkOut(String title1, String title2) {
    if (this.containsTitle(title1) != true && this.containsTitle(title2) != true) {
      throw new RuntimeException("These books are not in the collection.");
    } else {
      collection.replace(title1, false);
      collection.replace(title2, false);
      System.out.println("Successfully checked out" + " " + title1 + " and " + title2);
    }
  }

  /**
   * Returns the book with the given title to the Library.
   * 
   * @param title the title of the book to be returned
   * @throws RuntimeException if the book is not in the collection
   */
  public void returnBook(String title) {
    if (this.containsTitle(title) != true) {
      throw new RuntimeException(title + " is not in the collection.");
    } else {
      collection.replace(title, true);
    }
  }

  /**
   * Returns two (2) books with the given title to the Library.
   * 
   * @param title1 the title of the first book to be returned
   * @param title2 the title of the second book to be returned
   * @throws RuntimeException if the book is not in the collection
   */
  public void returnBook(String title1, String title2) {
    if (!this.containsTitle(title1) && !this.containsTitle(title2)) {
      throw new RuntimeException(title1 + " and " + title2 + " is not in the collection.");
    } else {
      collection.replace(title1, true);
      collection.replace(title2, true);
    }
  }

  /**
   * Displays a list of available options.
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + checkOut()\n + addTitle()\n + returnBook()\n + printCollection()");
  }

  /**
   * Navigates to a specified floor.
   * @param floorNum the floor number to navigate to
   * @throws RuntimeException if the user is not currently inside the building or the specified floor number is invalid
   * @throws RuntimeException if the user wants to go to non-adjacent floor and the building does not have an elevator
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors + ".");
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
   * Main method for testing the Library class.
   */
  public static void main(String[] args) {
    Library Neilson = new Library("Neilson Library", "100 Green Street Northampton, MA 01063", 4, false);
    System.out.println(Neilson);
    Neilson.printCollection();
    Neilson.addTitle("Gone With The Wind");
    Neilson.addTitle("1984");
    Neilson.addTitle("The Great Gatsby");
    Neilson.addTitle("The Hobbit");
    Neilson.addTitle("The Da Vinci Code");
    Neilson.printCollection();
    try {
      Neilson.checkOut("Dracula");
    } catch (Exception e) {
      System.out.println(e); 
    }
    Neilson.checkOut("The Da Vinci Code");
    Neilson.printCollection();
    Neilson.showOptions();
    Neilson.enter();
    Neilson.goToFloor(3);

  }
}