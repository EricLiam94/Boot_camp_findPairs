import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// ask the user to input a number and a list of number, then find the pairs that sum of them equal to the first number
public class boot_code {
	private int sum;
	private ArrayList<Integer> lists;

	public boot_code() {
		sum = 0;
		lists = new ArrayList<>();
	}

	public void askInput() {
		System.out.println("Please enter a Number.");
		try {
			//read first number from the user
			Scanner scan = new Scanner(System.in);
			sum = scan.nextInt();
		} catch (Exception e) {
			System.out.println("please enter a positive Integer!!!");
		}
		System.out.println("please input a list of Integer in form of a,b,c,d ! ");
		try {
			//read a list from a user in form of a,b,c,d
			Scanner scan = new Scanner(System.in);
			String strList = scan.nextLine();
			String[] temp = strList.split(",");
			for (String item : temp) {
				lists.add(Integer.parseInt(item));
			}
			Collections.sort(lists); // sort the list
			scan.close();
		} catch (Exception e) {
			System.out.println("please input right form of list");
		}
	}

	public void findPairs() {
		int min = 0;
		int len = lists.size();
		int max = lists.size() - 1;
		boolean found = false;
		if (len >= 2) {
			// if the sum of the first two elements is bigger than the require one 
			// or the sum of the last two elements is smaller than the require one. then no need to check forward. 
			if (!(lists.get(len - 1) + lists.get(len - 2) < sum || lists.get(0) + lists.get(1) > sum)) {
				while (min < max) {
					//kinda like quick sort
					int temp = lists.get(min) + lists.get(max);
					if (temp > sum)
						max--;
					else if (temp < sum)
						min++;
					else {
						found = true;
						System.out.println("(" + lists.get(min) + "," + lists.get(max) + ")");
						max--;
						min++;
					}
				}
			}
			if (found == false) {
				System.out.println("there is no such a pair");
			}
		} else {
			System.out.println("array size is not biger enough");
		}
	}

	public static void main(String[] args) {
		boot_code test = new boot_code();
		test.askInput();
		test.findPairs();

	}

}
