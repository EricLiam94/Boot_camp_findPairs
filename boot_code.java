import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
			Scanner scan = new Scanner(System.in);
			sum = scan.nextInt();
		} catch (Exception e) {
			System.out.println("please enter a positive Integer!!!");
		}
		System.out.println("please input a list of Integer in form of a,b,c,d ! ");
		try {
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
			if (!(lists.get(len - 1) + lists.get(len - 2) < sum || lists.get(0) + lists.get(1) > sum)) {
				while (min < max) {
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
