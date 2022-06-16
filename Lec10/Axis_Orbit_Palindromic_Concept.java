package Lec10;

public class Axis_Orbit_Palindromic_Concept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "nitin";
		System.out.println(countPalindromic(str));

	}

	public static int countPalindromic(String str) {
		int count = 0;
		// odd length palindromic Substring count krega
		for (int axis = 0; axis < str.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else {
					break;
				}
			}
		}

		// even length palindromic Substring count krega
		for (double axis = 0.5; axis < str.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else {
					break;
				}
			}
		}

		return count;
	}

}
