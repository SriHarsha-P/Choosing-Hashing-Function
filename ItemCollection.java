import java.io.*;
import java.util.*;

class Item {
	String itemColor;
	String itemShape;
	String itemBrand;
	int barcode;

	public Item(String itemColor, String itemShape, String itemBrand, int barcode) {
		this.itemColor = itemColor;
		this.itemShape = itemShape;
		this.itemBrand = itemBrand;
		this.barcode = barcode;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public String getItemColor() {
		return itemColor;
	}

	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}

	public String getItemShape() {
		return itemShape;
	}

	public void setItemShape(String itemShape) {
		this.itemShape = itemShape;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}
}

class CustomHashMap {
	List<List<Chain>> key_ls;

	class Chain {
		int key;
		Item value;

		public Chain(int key, Item value) {
			super();
			this.key = key;
			this.value = value;
		}
	}

	public CustomHashMap(int capacity) {
		// Created custom hashMap.
		key_ls = new ArrayList<List<Chain>>();
		for (int size = 0; size < capacity; size++) {
			key_ls.add(null);
		}
	}

	public int hashfct1(int barcode) {
		return barcode / 1000000;
	}

	public int hashfct2(int barcode) {
		int digit = 0;
		for (int count = 0; count <= 5; count++) {
			digit = barcode % 10;
			barcode /= 10;
		}
		return digit;
	}

	public int hashfct3(int barcode) {
		int digit = 0;
		for (int count = 0; count <= 4; count++) {
			digit = barcode % 10;
			barcode /= 10;
		}
		return digit;
	}

	public int hashfct4(int barcode) {
		int digit = 0;
		for (int count = 0; count <= 3; count++) {
			digit = barcode % 10;
			barcode /= 10;
		}
		return digit;
	}

	public int hashfct5(int barcode) {
		int digit = 0;
		for (int count = 0; count <= 2; count++) {
			digit = barcode % 10;
			barcode /= 10;
		}
		return digit;
	}

	public int hashfct6(int barcode) {
		int digit = 0;
		for (int count = 0; count <= 1; count++) {
			digit = barcode % 10;
			barcode /= 10;
		}
		return digit;
	}

	public int hashfct7(int barcode) {
		return barcode % 10;
	}

	public void put(int index, Item item) {
		// Method to put/add to hashMap
		List<Chain> ls = key_ls.get(index);
		Chain chain = new Chain(item.barcode, item);
		if (ls == null) {
			ls = new ArrayList<Chain>();
			ls.add(chain);
			key_ls.set(index, ls);
		} else {
			ls.add(chain);
			key_ls.set(index, ls);
		}
	}

	public void remove(int index, int barcode) {
		// Method to remove from hashMap
		List<Chain> ls = key_ls.get(index);
		int size = ls.size();
		for (int count = 0; count < size; count++) {
			if (ls.get(count).key == barcode) {
				ls.remove(count);
				return;
			}
		}
	}
}

public class ItemCollection {
	CustomHashMap ht1, ht2, ht3, ht4, ht5, ht6, ht7;
	int size;
	int[] map = new int[8];

	public ItemCollection(CustomHashMap ht1, CustomHashMap ht2, CustomHashMap ht3, CustomHashMap ht4, CustomHashMap ht5,
			CustomHashMap ht6, CustomHashMap ht7) {
		super();
		this.ht1 = ht1;
		this.ht2 = ht2;
		this.ht3 = ht3;
		this.ht4 = ht4;
		this.ht5 = ht5;
		this.ht6 = ht6;
		this.ht7 = ht7;
		size = 0;
	}

	public void readTextFile(String fileName) throws IOException {
		// Method for reading the input files from computer drive.
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
			String[] str = line.split(" ");
			addItem(str[0], str[1], str[2], Integer.parseInt(str[3]));
		}
	}

	private void addItem(String itemColor, String itemShape, String itemBrand, int barcode) {
		// Method for adding item and used switch case to navigate based on index.
		Item item = new Item(itemColor, itemShape, itemBrand, barcode);
		size++;
		for (int index = 1; index <= 7; index++) {
			switch (index) {
			case 1: {
				int digit = ht1.hashfct1(barcode);
				ht1.put(digit, item);
				break;
			}

			case 2: {
				int digit = ht2.hashfct2(barcode);
				ht2.put(digit, item);
				break;
			}

			case 3: {
				int digit = ht3.hashfct3(barcode);
				ht3.put(digit, item);
				break;
			}

			case 4: {
				int digit = ht4.hashfct4(barcode);
				ht4.put(digit, item);
				break;
			}

			case 5: {
				int digit = ht5.hashfct5(barcode);
				ht5.put(digit, item);
				break;
			}

			case 6: {
				int digit = ht6.hashfct6(barcode);
				ht6.put(digit, item);
				break;
			}

			case 7: {
				int digit = ht7.hashfct7(barcode);
				ht7.put(digit, item);
				break;
			}
			}
		}
	}

	public void removeItem(int barcode) {
		// Method for removing item and used switch case to navigate based on barcode.
		size--;
		for (int index = 1; index <= 7; index++) {
			switch (index) {
			case 1: {
				int digit = ht1.hashfct1(barcode);
				ht1.remove(digit, barcode);
				break;
			}

			case 2: {
				int digit = ht2.hashfct2(barcode);
				ht2.remove(digit, barcode);
				break;
			}

			case 3: {
				int digit = ht3.hashfct3(barcode);
				ht3.remove(digit, barcode);
				break;
			}

			case 4: {
				int digit = ht4.hashfct4(barcode);
				ht4.remove(digit, barcode);
				break;
			}

			case 5: {
				int digit = ht5.hashfct5(barcode);
				ht5.remove(digit, barcode);
				break;
			}

			case 6: {
				int digit = ht6.hashfct6(barcode);
				ht6.remove(digit, barcode);
				break;
			}

			case 7: {
				int digit = ht7.hashfct7(barcode);
				ht7.remove(digit, barcode);
				break;
			}
			}
		}
	}

	public void calculateLowFactor() {
		// Method for calculating low factor 
		for (int index = 1; index <= 7; index++) {
			int max = 0;
			int min = Integer.MAX_VALUE;
			switch (index) {
			case 1: {
				List<List<CustomHashMap.Chain>> ls = ht1.key_ls;
				for (int digit = 0; digit <= 9; digit++) {
					if (ls.get(digit) != null) {
						max = Math.max(ls.get(digit).size(), max);
						min = Math.min(ls.get(digit).size(), min);
					} else
						min = 0;
				}
				map[index] = max - min;
				break;
			}

			case 2: {
				List<List<CustomHashMap.Chain>> ls = ht2.key_ls;
				for (int digit = 0; digit <= 9; digit++) {
					if (ls.get(digit) != null) {
						max = Math.max(ls.get(digit).size(), max);
						min = Math.min(ls.get(digit).size(), min);
					} else
						min = 0;
				}
				map[index] = max - min;
				break;
			}

			case 3: {
				List<List<CustomHashMap.Chain>> ls = ht3.key_ls;
				for (int digit = 0; digit <= 9; digit++) {
					if (ls.get(digit) != null) {
						max = Math.max(ls.get(digit).size(), max);
						min = Math.min(ls.get(digit).size(), min);
					} else
						min = 0;
				}
				map[index] = max - min;
				break;
			}

			case 4: {
				List<List<CustomHashMap.Chain>> ls = ht4.key_ls;
				for (int digit = 0; digit <= 9; digit++) {
					if (ls.get(digit) != null) {
						max = Math.max(ls.get(digit).size(), max);
						min = Math.min(ls.get(digit).size(), min);
					} else
						min = 0;
				}
				map[index] = max - min;
				break;
			}

			case 5: {
				List<List<CustomHashMap.Chain>> ls = ht5.key_ls;
				for (int digit = 0; digit <= 9; digit++) {
					if (ls.get(digit) != null) {
						max = Math.max(ls.get(digit).size(), max);
						min = Math.min(ls.get(digit).size(), min);
					} else
						min = 0;
				}
				map[index] = max - min;
				break;
			}

			case 6: {
				List<List<CustomHashMap.Chain>> ls = ht6.key_ls;
				for (int digit = 0; digit <= 9; digit++) {
					if (ls.get(digit) != null) {
						max = Math.max(ls.get(digit).size(), max);
						min = Math.min(ls.get(digit).size(), min);
					} else {
						min = 0;
					}
				}
				map[index] = max - min;
				break;
			}

			case 7: {
				List<List<CustomHashMap.Chain>> ls = ht7.key_ls;
				for (int digit = 0; digit <= 9; digit++) {
					if (ls.get(digit) != null) {
						max = Math.max(ls.get(digit).size(), max);
						min = Math.min(ls.get(digit).size(), min);
					} else
						min = 0;
				}
				map[index] = max - min;
				break;
			}
			}
		}
	}

	public int bestHashing() {
		// Method calculating best hashing 
		calculateLowFactor();
		int ans = 0;
		int lowFactor = Integer.MAX_VALUE;
		for (int pos = 1; pos <= 7; pos++) {
			if (map[pos] < lowFactor) {
				lowFactor = map[pos];
				ans = pos;
			}
		}
		return ans;
	}

	static void input1File(ItemCollection ic1) {
		try {
			ic1.readTextFile("C:\\in1.txt");
			System.out.println("Size after reading in1.txt: " + ic1.size);
			System.out.println("Best Hashing for in1.txt is: " + ic1.bestHashing());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	static void input2File(ItemCollection ic1) {
		try {
			ic1.readTextFile("C:\\in2.txt");
			System.out.println("Size after reading in2.txt is: " + ic1.size);
			System.out.println("Best Hashing for in2.txt is: " + ic1.bestHashing());
			System.out.println("-----------------------------");

			ic1.removeItem(8890123);
			System.out.println("Size after removing 8890123 is: " + ic1.size);
			System.out.println("Best Hashing after removing 8890123 is: " + ic1.bestHashing());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	static void forAddItem(ItemCollection ic1) {
		try {
			ic1.addItem("red", "butterfly", "smooth", 1234567);
			ic1.addItem("pink", "butterfly", "smooth", 2345678);
			System.out.println("Size after adding two bows is : " + ic1.size);
			System.out.println("Best Hashing is: " + ic1.bestHashing());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CustomHashMap ht1 = new CustomHashMap(10);
		CustomHashMap ht2 = new CustomHashMap(10);
		CustomHashMap ht3 = new CustomHashMap(10);
		CustomHashMap ht4 = new CustomHashMap(10);
		CustomHashMap ht5 = new CustomHashMap(10);
		CustomHashMap ht6 = new CustomHashMap(10);
		CustomHashMap ht7 = new CustomHashMap(10);
		
		// Creating object for Itemcollection
		ItemCollection ic1 = new ItemCollection(ht1, ht2, ht3, ht4, ht5, ht6, ht7);
		
		// Test case method for input 1 file text i.e., in1.txt 
			input1File(ic1);
			
		//Test case method for input 2 file text i.e., in2.txt
			//input2File(ic1);
			
		// Test case method for addItem 	
			//forAddItem(ic1);
	}
}
