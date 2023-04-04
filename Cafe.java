/**
 * A class representing a cafe.
*/
public class Cafe extends Building {

    /**
     * The number of coffee ounces, sugar packets, splashes of cream, and cups remaining in the inventory.
     * */
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructs a Cafe object with the given name, address, and number of floors.
     * Initializes the inventory with default values.
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors the number of floors in the cafe
     * */

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = 15;
        this.nSugarPackets = 15;
        this.nCreams = 15;
        this.nCups = 20;
    }
    
    /**
     * Sells coffee to a customer with the given size, number of sugar packets, and number of cream splashes.
     * If the cafe is out of any inventory items, restocks them before fulfilling the order.
     * If the cafe is out of cups, the order cannot be fulfilled.
     * @param size the size of the coffee (in ounces)
     * @param nSugarPackets the number of sugar packets in the coffee
     * @param nCreams the number of cream splashes in the coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(size, nSugarPackets, nCreams, 1);
            System.out.println("Restock needed! Please wait a minute.");
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Here's your order! Enjoy.");
    }

    /*Overload method for non-dairy options */
    public void sellCoffee(int size, int nSugarPackets, boolean nonDairyOption) {
        int nCreams = nonDairyOption ? 0 : 1; // Set number of creams based on nonDairyOption flag
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(size, nSugarPackets, nCreams, 1);
            System.out.println("Restock needed! Please wait a minute.");
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Here's your non-dairy order! Enjoy.");
    }

    /*Overload method for non-sweetened options */
    public void sellCoffee(int size, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(size, nSugarPackets, nCreams, 1);
            System.out.println("Restock needed! Please wait a minute.");
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Here's your non-sweetened order! Enjoy.");
    }
    


    /**
     * Restocks the cafe's inventory with the given number of coffee ounces, sugar packets, cream splashes, and cups.
     * @param nCoffeeOunces the number of coffee ounces to restock
     * @param nSugarPackets the number of sugar packets to restock
     * @param nCreams the number of cream splashes to restock
     * @param nCups the number of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces*10;
        this.nSugarPackets += nSugarPackets*10;
        this.nCreams += nCreams*10;
        this.nCups += nCups*10;
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + buyCoffee()");
    }
    
    /**
   * Main method for testing the Library class.
   */
    public static void main(String[] args) {
        Cafe campusCafe = new Cafe("Campus Cafe", "100 Green Street Northampton, MA 01063", 1);
        System.out.println(campusCafe);
        campusCafe.sellCoffee(15, 6, 9);
        campusCafe.sellCoffee(15, 6, false);
        campusCafe.sellCoffee(15, 6, 9);
        campusCafe.sellCoffee(15, 6, 9);
        campusCafe.sellCoffee(15, 6);
        campusCafe.showOptions();
        campusCafe.enter();
    }
    
}
