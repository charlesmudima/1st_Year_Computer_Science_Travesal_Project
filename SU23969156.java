
public class SU23969156 {

	public static void main(String[] args) {
		// read in board
		In board = new In(args[0]);
		String line = board.readLine();
		int R = board.readInt();
		int C = board.readInt();
		String board1[][] = new String[R][C];
		for (int r = 0; r < R; r++) {
			String dummy = board.readString();
			for (int c = 0; c < C; c++) {
				board1[r][c] = dummy.substring(c, c + 1);

			}
		}
		// allocating the starting position of player
		int rowpos = playerR(board1, R, C);
		int colpos = playerC(board1, R, C);
		if (args.length == 2) {
			In moves = new In(args[1]);
			String movesLine = moves.readString();
			String moves1[] = new String[movesLine.length()];
			for (int m = 0; m < movesLine.length(); m++) {
				moves1[m] = movesLine.substring(m, m + 1);

				if (moves1[m] == "h" || moves1[m] == "l") {

					Hmovers(board1);
					board1 = moves(board1, moves1[m]);
					// outputboard(board1);
				} else if (moves1[m] == "j" || moves1[m] == "k") {
					Vmovers(board1);
				}

			}

			outputboard(board1);
		}

		// GUI
		if (args.length == 1) {
			StdDraw.setCanvasSize(C * 110, R * 110);
			StdDraw.setXscale(0, C);
			StdDraw.setYscale(0, R);
			// StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			// StdDraw.filledRectangle(C/2, R/2, C/2, R/2);
			double x = rowpos;
			double y = colpos;

			while (true) {

				StdDraw.enableDoubleBuffering();
				// StdDraw.clear(StdDraw.LIGHT_GRAY);
				// StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
				draw(board1, R, C);
				// StdDraw.show();
				// StdDraw.pause(20);
				// StdDraw.picture(colpos+0.5, rowpos-0.5, "tvl_s.png");
				// read key
				// wait until there is a key!!
				// StdDraw.picture(x, y, "tvl_s.png");
				while (!StdDraw.hasNextKeyTyped()) {
					// wait

				}

				char key = StdDraw.nextKeyTyped();

				if (key == 'h') {
					DrawMoversH(board1);
					x = x - 1;
					if (x < 1) {
						x = 0.5;
					}

					StdDraw.picture(x, y, "tvl_s.png");
					System.out.println("Move left");
				} else if (key == 'l') {

					DrawMoversH(board1);
					x = x + 1;
					if (x >= C) {
						x = C - 0.5;
					}
					StdDraw.picture(x, y, "tvl_s.png");
					System.out.println("Move right");
				} else if (key == 'k') {
					DrawMoversV(board1);
					y = y + 1;
					if (y == R) {
						y = 0.5;
					}

					StdDraw.picture(x, y, "tvl_s.png");
					System.out.println("up");
				} else if (key == 'j') {
					DrawMoversV(board1);
					y = y - 1;
					if (y < 0) {
						y = R - 0.5;

					}
					System.out.println("down");
					StdDraw.picture(x, y, "tvl_s.png");

				} else {
					System.out.println("Illegal key!");
				}

			}
		}

	}

	public static String[][] moves(String board[][], String moves) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].contentEquals("s")) {

					if (moves == "h") {
						Hmovers(board);
						board[i][j - 1] = "s";
						board[i][j] = ".";
					} else if (moves == "j") {
						board[i + 1][j] = "s";
						board[i][j] = ".";
					} else if (moves == "l") {
						board[i][j + 1] = "s";
						board[i][j] = ".";
					} else if (moves == "k") {
						board[i - 1][j] = "s";
						board[i][j] = ".";
					} else if (moves == "x") {
						return board;
					} else if (moves == "o") {
						System.out.println("incorrect move");
					}
				}
				break;
			}
		}
		return board;

	}

	public static void draw(String[][] board, int R, int C) {
		StdDraw.clear();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				StdDraw.picture(i + 0.5, j + 0.5, "tvl_e.png");
				// StdDraw.picture(i + 0.5, j - 0.5, "tvl_s.png");
				if (board[i][j].contentEquals("s")) {
					StdDraw.picture(i + 0.5, j - C - 0.5, "tvl_s.png");

				}
				if (board[i][j].contentEquals("s")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_s.png");

				} else if (board[i][j].contentEquals("x")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_x.png");

				} else if (board[i][j].contentEquals("t")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_t.png");
				} else if (board[i][j].contentEquals("u")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_uh.png");
				} else if (board[i][j].contentEquals("d")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_dh.png");
				} else if (board[i][j].contentEquals("l")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_lh.png");
				} else if (board[i][j].contentEquals("r")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_rh.png");
				} else if (board[i][j].contentEquals("U")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_uv.png");
				} else if (board[i][j].contentEquals("D")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_dv.png");
				} else if (board[i][j].contentEquals("L")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_lv.png");
				} else if (board[i][j].contentEquals("R")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_rv.png");
				} else if (board[i][j].contentEquals("h")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_sh0.png");
				} else if (board[i][j].contentEquals("H")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_sh1.png");
				} else if (board[i][j].contentEquals("v")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_sv0.png");
				} else if (board[i][j].contentEquals("V")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_sv1.png");
				} else if (board[i][j].contentEquals("k") || board[i][j].contentEquals("K")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_k1.png");
				} else if (board[i][j].contentEquals("p")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_p1.png");
				} else if (board[i][j].contentEquals("P")) {
					StdDraw.picture(i + 0.5, j - 0.5, "tvl_p0.png");
				}
				StdDraw.show();
				// StdDraw.show();
			}
		}

		return;
	}

	public static void DrawMoversH(String board[][]) {
		StdDraw.clear();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].contentEquals("u")) {
					StdDraw.picture(i, (j++) + 0.5, "tvl_uh.png");
				} else if (board[i][j].contentEquals("d")) {
					StdDraw.picture(i, j - 0.5, "tvl_dh.png");

				} else if (board[i][j].contentEquals("l")) {
					StdDraw.picture(i - 0.5, j, "tvl_lh.png");

				} else if (board[i][j].contentEquals("r")) {
					StdDraw.picture(i + 0.5, j, "tvl_rh.png");

				}
				;
				StdDraw.show();
			}
		}
	}

	public static void DrawMoversV(String board[][]) {
		StdDraw.clear();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].contentEquals("U")) {
					StdDraw.picture(i, j + 0.5, "tvl_uv.png");
				} else if (board[i][j].contentEquals("D")) {
					StdDraw.picture(i, j - 0.5, "tvl_dv.png");

				} else if (board[i][j].contentEquals("L")) {
					StdDraw.picture(i - 0.5, j, "tvl_lv.png");
				} else if (board[i][j].contentEquals("R")) {
					StdDraw.picture(i, j + 0.5, "tvl_rv.png");
				}
				StdDraw.show();
			}
		}
	}

	public static void outputboard(String[][] board) {
		// printing the board in txt mode
		for (int i = 0; i < board.length; i++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[i][c].contentEquals("s")) {
					System.out.print("Y");
				} else if (board[i][c].contentEquals(".")) {
					System.out.print(".");
				} else if (board[i][c].contentEquals("t")) {
					System.out.print("t");
				} else if (board[i][c].contentEquals("u") || board[i][c].contentEquals("U")) {
					System.out.print("m");
				} else if (board[i][c].contentEquals("x")) {
					System.out.print("x");
				} else if (board[i][c].contentEquals("d") || board[i][c].contentEquals("D")) {
					System.out.print("m");
				} else if (board[i][c].contentEquals("l") || board[i][c].contentEquals("L")) {
					System.out.print("m");
				} else if (board[i][c].contentEquals("r") || board[i][c].contentEquals("R")) {
					System.out.print("m");
				} else if (board[i][c].contentEquals("vD") || board[i][c].contentEquals("vR")
						|| board[i][c].contentEquals("vL") || board[i][c].contentEquals("vU")) {
					System.out.print("m");
				} else if (board[i][c].contentEquals("hD") || board[i][c].contentEquals("hR")
						|| board[i][c].contentEquals("hL") || board[i][c].contentEquals("hU")) {
					System.out.print("m");
				}
			}
			System.out.println("");
		}
	}

	public static String[][] Vmovers(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].contentEquals("D") || board[i][j].contentEquals("vD")) {
					if (board[i][j] == board[board.length - 1][j]) {
						board[0][j] = "vD";
						board[i][j] = ".";

					} else {
						board[i + 1][j] = "vD";
						board[i][j] = ".";
					}
					break;
				} else if (board[i][j].contentEquals("L") || board[i][j].contentEquals("vL")) {
					if (board[i][j] == board[i][0]) {
						board[i][board[0].length - 1] = "vL";
						board[i][0] = ".";

					} else {
						board[i][j - 1] = "vL";
						board[i][j] = ".";
					}
					break;
				} else if (board[i][j].contentEquals("R") || board[i][j].contentEquals("vR")) {
					if (board[i][j] == board[i][board[0].length - 1]) {
						board[i][board[0].length - 1] = ".";
						board[i][0] = "vR";

					} else {
						board[i][j + 1] = "vR";
						board[i][j] = ".";
					}
					break;
				} else if (board[i][j].contentEquals("U") || board[i][j].contentEquals("vU")) {
					if (board[i][j] == board[0][j]) {
						board[board.length - 1][j] = "vU";
						board[i][j] = ".";

					} else {
						board[i - 1][j] = "vU";
						board[i][j] = ".";

					}

				}

			}
		}
		return board;
	}

	public static int playerR(String board[][], int R, int C) {
		int row = 0;
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (board[i][j].contentEquals("s"))
					row = i;

		return row;

	}

	public static int playerC(String board[][], int R, int C) {
		int col = 0;
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (board[i][j].contentEquals("s"))
					col = j;

		return col;

	}

	public static String[][] Hmovers(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].contentEquals("d") || board[i][j].contentEquals("hD")) {
					if (board[i][j] == board[board.length - 1][j]) {
						board[0][j] = "hD";
						board[i][j] = ".";
						// break;
					} else {
						board[i + 1][j] = "hD";
						board[i][j] = ".";
					}
					break;
				} else if (board[i][j].contentEquals("l") || board[i][j].contentEquals("hL")) {
					if (board[i][j] == board[i][0]) {
						board[i][board[0].length - 1] = "hL";
						board[i][0] = ".";
						// break;
					} else {
						board[i][j - 1] = "hL";
						board[i][j] = ".";
					}
					break;
				} else if (board[i][j].contentEquals("r") || board[i][j].contentEquals("hR")) {
					if (board[i][j] == board[i][board[0].length - 1]) {
						board[i][board[0].length - 1] = ".";
						board[i][0] = "hR";

						// break;
					} else {
						board[i][j + 1] = "hR";
						board[i][j] = ".";
					}
					break;
				} else if (board[i][j].contentEquals("u") || board[i][j].contentEquals("hU")) {
					if (board[i][j] == board[0][j]) {
						board[board.length - 1][j] = "hU";
						board[i][j] = ".";

						// break;
					} else {
						board[i - 1][j] = "hU";
						board[i][j] = ".";

					}

				}

			}
		}
		return board;

	}

	public static String win(String[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if ((board[i][j].contains("t"))) {
					System.out.println("You lost!");
				}
				// System.out.println("you won!");

			}
		}
		return null;
	}

}
