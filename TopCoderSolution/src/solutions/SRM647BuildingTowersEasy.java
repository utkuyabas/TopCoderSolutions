package solutions;

public class SRM647BuildingTowersEasy {


		public static int maxHeight(int N, int[] x, int[] t) {
			int[] maxFloors = new int[N + 1];
			int iterator = 2;
			maxFloors[0] = 0;
			maxFloors[1] = 0;
			if (x.length == 0)
				return N - 1;
			for (int i = 0; i < x.length; i++) {
				int nextIndex = x[i];
				while (iterator <= nextIndex) {
					maxFloors[iterator] = maxFloors[iterator - 1] + 1;
					iterator++;
				}

				if (t[i] >= maxFloors[iterator - 1]) {
					;
				} else {
					maxFloors[iterator - 1] = t[i];
					for (int j = x[i] - 1; j > 0; j--) {
						if (Math.abs(maxFloors[j] - maxFloors[j + 1]) <= 1) {
							break;
						} else
							maxFloors[j] = maxFloors[j + 1] + 1;
					}
				}

			}

			int max = 0;
			for (int i = 0; i < x[x.length - 1]; i++)
				max = Math.max(max, maxFloors[i]);

			int last = maxFloors[x[x.length - 1]];
			int index = N - x[x.length - 1];
			return Math.max(max, last + index);
		}

	}

