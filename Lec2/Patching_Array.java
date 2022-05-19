package Lec2;

public class Patching_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 3 };
		int n = 20;
		System.out.println(CountMissingnumber(arr, n));

	}

	public static int CountMissingnumber(int[] arr, int n) {

		int miss = 1;
		int i = 0;
		int count = 0;
		while (miss <= n) {

			if (i < arr.length && miss >= arr[i]) {

				miss += arr[i];
				i++;
			} else {
				miss += miss;
				count++;
			}

		}
		return count;

	}

}
