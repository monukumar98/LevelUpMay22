package Lec18;

public class Birthday_ParaDox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float k=1048576.9999f;
		System.out.println(k/2.1);
		System.out.println();
		double p = 0.0027;
		double x = 1.0;
		int num = 365;
		int dunm = 365;
		int people = 0;
		while (1 - x < p) {

			x = (x * num) / dunm;
			people++;
			num--;
		}

		System.out.println(people);
	}

}
