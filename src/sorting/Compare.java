package sorting;

import java.util.*;

public class Compare {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for (int i = 0; i < n; i++) {
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for (int i = 0; i < player.length; i++) {
			System.out.printf("%s %s\n", player[i].name, player[i].score);
		}
	}

	static class Checker implements Comparator<Player> {
		public int compare(Player a, Player b) {
			// DESC by score
			// ASC by Name
			// ASC --> a > b: 1, a = b: 0, a < b: -1

			if (a.score > b.score) {
				return -1;
			} else if (a.score < b.score) {
				return 1;
			}

			int diff = a.name.compareTo(b.name);

			if (diff > 0) {
				return 1;
			} else if (diff < 0) {
				return -1;
			}

			return 0;
		}
	}
}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}