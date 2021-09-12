import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Allows the user to create a simple shopping list of the items they need to buy at the shops
 * Indexing starts from 0
 * @author Drew Baxter
 * @version v1.0.0
 */

public class Shopping {
	// Create the arbitrary length shopping list and the string containing the menu options for user input
	private ArrayList shoppingList;
	private String menuOptions[] = {"List Items", "Add Item", "Show a Particular Item", "Exit Program"};
	
	/**
	 * Performs any initialisation needed for the shopping list
	 */
	public Shopping() {
		shoppingList = new ArrayList();
	}
	
	/**
	 * Add a new item to the shopping list
	 * @param item The item to add to the list
	 */
	public void addItem(String item) {
		shoppingList.add(item);
	}
	
	/**
	 * @return The number of items on the shopping list
	 */
	public int numberOfItems() {
		return shoppingList.size();
	}
	
	/**
	 * Show a particular item from the shopping list
	 * @param itemNumber The index of the item to be displayed from the shopping list.
	 */
	public void showItem(int itemNumber) {
		String output = "Item Number\tItem Name";
		JTextArea outputArea = new JTextArea();
		outputArea.setText(output);		
		if (itemNumber < 0) {
			JOptionPane.showMessageDialog(null, "That's not a valid item number!", "Shopping List Program - Error", JOptionPane.WARNING_MESSAGE);
		}
		else if (itemNumber < numberOfItems()) {
			JOptionPane.showMessageDialog(null, shoppingList.get(itemNumber), "Shopping List Program", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "That's not a valid item number!", "Shopping List Program - Error", JOptionPane.WARNING_MESSAGE);	
		}
	}
	
	/**
	 * List all items on the list
	 */
	public void listItems() {
		int index = 0;
		String output = "Item Number\tItem Name";
		while(index < shoppingList.size()) {
			for (int counter = 0; counter < shoppingList.size(); counter++) {
				output += "\n" + counter + "\t" + shoppingList.get(counter);
			index++;
			}
			// Display the items on a pop-up box		
			JTextArea outputArea = new JTextArea();
			outputArea.setText(output);
			JOptionPane.showMessageDialog(null, outputArea, "Shopping List Program", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	/**
	 * Creates and shows the menu to the user allowing their input on what they would like to do with the program
	 */
	public void showMenu() {
		int option = getChoice();
		while (option != 3) { // Option 3 exits the program
			if (option == 0) { // List items on list
				if (numberOfItems() >0) {
					listItems();
				}
				else  JOptionPane.showMessageDialog(null, "There are no items on this shopping list", "Shopping List Program - Error", JOptionPane.WARNING_MESSAGE);
			}
			else if (option == 1) { //Add item to list
				String newItem = JOptionPane.showInputDialog(null, "Enter item to add to the shopping list", "Item name", JOptionPane.PLAIN_MESSAGE);
				if (newItem != null) {
					addItem(newItem);
				}
			}
			else if (option == 2) { // Display a particular item
				if (numberOfItems() >0) {
					String strNum = JOptionPane.showInputDialog(null, "Enter an item number", "Show item", JOptionPane.PLAIN_MESSAGE);
				//	if (strNum == ""){
				//		JOptionPane.showMessageDialog(null, "Invalid item number", "Shopping List Program - Error", JOptionPane.WARNING_MESSAGE);
				//	}
					if (strNum != null) {
						int num = Integer.parseInt(strNum);
						if (num <= numberOfItems()){
						showItem(num);
						}
					}
					else  JOptionPane.showMessageDialog(null, "Invalid item number", "Shopping List Program - Error", JOptionPane.WARNING_MESSAGE);
				}
				else  JOptionPane.showMessageDialog(null, "There are no items on this shopping list", "Shopping List Program - Error", JOptionPane.WARNING_MESSAGE);
			}
			else JOptionPane.showMessageDialog(null, "Invalid response, please try again! " +option);
				option = getChoice();
			}
		}
	
	
	/**
	 * Get the user's menu choice
	 */
	    public int getChoice()
	    {
	        int choice = JOptionPane.showOptionDialog(null, "Select from the below menu options","Shopping List Program Menu",
	                     JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuOptions, menuOptions[0]);
	        return choice;
	    }
}
