package Lec20;

public class No_Way_toDivide_Corridor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "SPSPPSSPSSPPSS";
		System.out.println(numberOfWays(str));

	}

	public static int numberOfWays(String corridor) {

		int totalseats = 0;
		int seat = 0;
		int plant = 0;
		long ans = 1;
		int mod = (int) (1e9 + 7);
		
		boolean firstcorridor = false;
		for (int i = 0; i < corridor.length(); i++) {
			if (corridor.charAt(i) == 'S') {
				totalseats++;
				seat++;
			}

			else if (seat == 0) {
				plant++;
			}

			if (seat == 2) {

				if (firstcorridor) {
					ans = (ans * (plant + 1)) % mod;
				}

				firstcorridor = true;
				seat = 0;
				plant = 0;

			}

		}

		if (totalseats == 0 || totalseats % 2 != 0) {
			return 0;
		}
		return (int) (ans);

	}

}
