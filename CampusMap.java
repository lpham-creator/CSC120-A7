import java.util.ArrayList;

public class CampusMap {
    
    /*An ArrayList to store all the buildings*/
    ArrayList<Building> buildings;

/**
 * Default constructor that initializes an empty ArrayList.
 */
public CampusMap() {
    buildings = new ArrayList<Building>();
}

/**
 * Adds a Building to the map.
 * @param b the Building to add
 */
public void addBuilding(Building b) {
    System.out.println("Adding building...");
    buildings.add(b);
    System.out.println("-->Successfully added " + b.getName() + " to the map.");
}

/**
 * Adds a Library to the map.
 * @param lib the Library to add
 */
public void addBuilding(Library lib) {
    System.out.println("Adding library...");
    buildings.add(lib);
    System.out.println("-->Successfully added " + lib.getName() + " to the map.");
}

/**
 * Adds a Cafe to the map.
 * @param cafe the Cafe to add
 */
public void addBuilding(Cafe cafe) {
    System.out.println("Adding cafe...");
    buildings.add(cafe);
    System.out.println("-->Successfully added " + cafe.getName() + " to the map.");
}

/**
 * Removes a Building from the map.
 * @param b the Building to remove
 * @return the removed Building
 */
public Building removeBuilding(Building b) {
    System.out.println("Removing building...");
    buildings.remove(b);
    System.out.println("-->Successfully removed " + b.getName() + " to the map.");
    return b;
}

/**
 * Returns a string representation of the map.
 * @return the string representation of the map
 */
public String toString() {
    String mapString = "DIRECTORY of BUILDINGS";

    for (int i = 0; i < this.buildings.size(); i ++) {
        mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
    }
    return mapString;
}

/**
 * The main method that creates a CampusMap and adds various buildings to it.
 */
    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Library("Hillyer Art Library", "20 Elm Street Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Building("Ainsworth Gym", "102 Lower College Ln Northampton, MA 01063", 3));
        myMap.addBuilding(new House("Jordan House", "1 Paradise Road Northampton, MA 01063", 4, false, false));
        myMap.addBuilding(new House("Cutter-Ziskind House", "1 Henshaw Ave Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new House("Northrop House", "49 Elm Street Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive Northampton, MA 01063", 1));
        myMap.addBuilding(new Cafe("Campus Cafe", "Smith College Campus Center, 100 Elm St Northampton, MA 01063", 1));
        System.out.println(myMap);
    }
    
}
