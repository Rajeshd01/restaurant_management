import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RestaurantOwner {
	static HashMap<String, Float> menu;

	RestaurantOwner() {
		menu = new HashMap<String, Float>();
	}

	boolean authorize(String username, String password) {
		return username.equals("rajesh") && password.equals("123");
	}

	boolean addItem(String food, float price) {
		if (menu.containsKey(food))
			return false;
		menu.put(food, price);
		return true;
	}

	boolean deleteItem(String food) {
		if (menu.containsKey(food)) {
			menu.remove(food);
			return true;
		} else
			return false;
	}

	boolean update(String food, float price) {
		try {
			deleteItem(food);
			addItem(food, price);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	void displayMenu() {
		if (menu.isEmpty()) {
			System.out.println("Menu empty.");
			return;
		}
		Set<String> foodNames = new HashSet<String>();
		foodNames = menu.keySet();
		System.out.println("-------------------------------------");
		System.out.println("FOOD \t PRICE");
		System.out.println("-------------------------------------");
		for (String food : foodNames) {
			System.out.println(food + "\t" + menu.get(food));
		}
		System.out.println("-------------------------------------");
	}
}
