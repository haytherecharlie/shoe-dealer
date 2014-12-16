/**
 * ShoeDealer -- A Java experience that allows you 
 * to buy and sell shoes for a profit. 
 * 
 * @author Charlie Hay
 */
import java.applet.*;
import java.awt.*;

public class ShoeDealer extends Applet {

	private static final long serialVersionUID = 1L;

	// Instance variables here
	Panel panelTestBG = new Panel();
	Image BG;
	Graphics gPanelTestBG;
	static Button[][] btnBuySell = new Button[2][6];
	static Button[] btnVenue = new Button[5];
	static Button btnHelp, btnAbout, btnHighScores, btnPay, btnNewGame;
	static int shoe[] = new int[6], days = 0, store = -1;
	static double money = 200, owed = 500, payment = 0;
	static boolean game = true;
	static Label lblShoe[] = new Label[6], lblPrice[] = new Label[6],
			lblShoes[] = new Label[6], lblHelp, lblCash, lblDays, lblOwe,
			lblDaysLeft;
	static TextField[] txtQuantity = new TextField[6];
	static TextField txtPayment;

	public void init() {

		// Set the width and height of the applet window
		setSize(800, 513);

		// Tells the applet not to use a layout manager.
		setLayout(null);
		setBackground(Color.black);

		// Initialze the button and give it a label.
		for (int i = 0; i < 6; i++) {
			btnBuySell[0][i] = new Button("Buy");
			btnBuySell[0][i].setBackground(Color.red);
			btnBuySell[1][i] = new Button("Sell");
			btnBuySell[1][i].setBackground(Color.red);
			lblShoe[i] = new Label("Shoe " + (i + 1));
			lblShoe[i].setBackground(Color.orange);
			lblPrice[i] = new Label("      ");
			lblPrice[i].setBackground(Color.orange);
			txtQuantity[i] = new TextField("0", 100);
			txtQuantity[i].setBackground(Color.yellow);
			shoe[i] = 0;
			lblShoes[i] = new Label("" + shoe[i]);
			lblShoes[i].setBackground(Color.orange);

		}

		lblHelp = new Label("");
		lblHelp.setBackground(Color.black);
		lblHelp.setForeground(Color.white);

		btnHelp = new Button("Help");
		btnHelp.setBackground(Color.red);
		btnAbout = new Button("About");
		btnAbout.setBackground(Color.red);
		btnNewGame = new Button("New Game");
		btnNewGame.setBackground(Color.red);
		btnHighScores = new Button("High Scores");
		btnHighScores.setBackground(Color.red);
		btnPay = new Button("Make a payment");
		btnPay.setBackground(Color.red);
		lblCash = new Label("" + money);
		lblCash.setBackground(Color.lightGray);
		lblDays = new Label("" + days);
		lblDays.setBackground(Color.lightGray);
		lblOwe = new Label("You still owe " + (owed - payment)
				+ " to your boss");
		lblOwe.setBackground(Color.blue);
		lblOwe.setForeground(Color.orange);
		lblDaysLeft = new Label("You have " + (30 - days)
				+ " left to pay off your debt");
		lblDaysLeft.setBackground(Color.blue);
		lblDaysLeft.setForeground(Color.orange);
		txtPayment = new TextField("0");
		txtPayment.setForeground(Color.white);
		txtPayment.setBackground(Color.black);

		btnVenue[0] = new Button("Wal-Mart");
		btnVenue[1] = new Button("K-Mart");
		btnVenue[2] = new Button("Foot Locker");
		btnVenue[3] = new Button("Athlete\'s World");
		btnVenue[4] = new Button("Payless Shoe Sorce");

		for (int i = 0; i < 5; i++) {
			btnVenue[i].setBackground(Color.red);
		}

		// initialize label contents

		// initialize the radio buttons group

		// now we will specify the positions of the GUI components.
		// this is done by specifying the x and y coordinate and
		// the width and height.

		for (int i = 0; i < 6; i++) {
			btnBuySell[0][i].setBounds(310, 65 + 30 * i, 25, 25);
			btnBuySell[1][i].setBounds(340, 65 + 30 * i, 25, 25);
			lblShoe[i].setBounds(370, 68 + 30 * i, 126, 15);
			lblPrice[i].setBounds(250, 65 + 30 * i, 55, 25);
			txtQuantity[i].setBounds(496, 65 + 30 * i, 40, 20);
			lblShoes[i].setBounds(540, 68 + 30 * i, 15, 15);

		}

		for (int i = 0; i < 5; i++) {

			btnVenue[i].setBounds(120, 105 + 20 * i, 125, 20);
		}
		for (int i = 0; i <= 17; i++) {
			lblHelp.setBounds(570, 60, 300, 509);
		}

		btnHelp.setBounds(330, 330, 75, 20);
		btnAbout.setBounds(330, 360, 75, 20);
		btnNewGame.setBounds(410, 330, 75, 20);
		btnHighScores.setBounds(410, 360, 75, 20);
		lblCash.setBounds(210, 325, 40, 20);
		lblDays.setBounds(550, 35, 15, 15);
		btnPay.setBounds(50, 420, 190, 30);
		lblOwe.setBounds(253, 419, 350, 20);
		lblDaysLeft.setBounds(253, 439, 350, 20);
		txtPayment.setBounds(50, 450, 190, 30);

		// now that all is set we can add these components to the applet
		for (int i = 0; i < 6; i++) {
			add(btnBuySell[0][i]);
			add(btnBuySell[1][i]);
			add(lblShoe[i]);
			add(lblPrice[i]);
			add(txtQuantity[i]);
			add(lblShoes[i]);

		}

		for (int i = 0; i < 5; i++) {

			add(btnVenue[i]);

		}

		add(lblHelp);

		add(btnHelp);
		add(btnAbout);
		add(btnPay);
		add(btnNewGame);
		add(lblCash);
		add(lblDays);
		add(lblOwe);
		add(lblDaysLeft);
		add(txtPayment);

		setLayout(null);
		panelTestBG.setBackground(Color.white);
		panelTestBG.setBounds(0, 0, 649, 512);
		add(panelTestBG);
		BG = getImage(getDocumentBase(), "DealerBG.JPG");

		validate();
	} // init method

	// Draw the panel and set cursor
	public void drawPanel() {
		gPanelTestBG = panelTestBG.getGraphics();
		gPanelTestBG.drawImage(BG, 0, 0, panelTestBG);
		repaint();

		btnHelp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAbout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHighScores.setCursor(new Cursor(Cursor.HAND_CURSOR));
		for (int i = 0; i < 6; i++) {
			btnBuySell[0][i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnBuySell[1][i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		for (int i = 0; i < 5; i++) {
			btnVenue[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

	}

	// paint the graphics
	public void paint(Graphics g) {
		drawPanel();
	} 

	// handle actions
	public boolean action(Event e, Object o) {

		if (e.target == btnPay) {
			payment = Double.valueOf(txtPayment.getText()).doubleValue();

			if (payment >= 0 && payment <= money) {
				money = money - payment;
				owed = owed - payment;
				if (owed <= 0) {
					owed = 0;

				} else {
					game = gameOver(money, days, shoe);
					if (game == false) {
						lblHelp.setText("GAME OVER");

					}
				}

				if (owed == 0) {
					winner();

				}

				lblCash.setText("" + money);
				lblOwe.setText("You still owe " + owed + " to your boss");

			} else {
				lblOwe.setText("You don't have the money");
			}
		} else if (e.target == btnHelp) {
			help();
		}
		if (e.target == btnAbout) {
			about();
		}
		if (e.target == btnNewGame) {
			newGame();
		}

		for (int i = 0; i < 5; i++) {

			if (e.target == btnVenue[i]) {

				venue(i);
			}
		}
		for (int j = 0; j <= 5; j++) {
			if (e.target == btnBuySell[0][j]) {
				buy(j);
			}
		}

		for (int m = 0; m <= 5; m++) {
			if (e.target == btnBuySell[1][m]) {
				sell(m);
			}
		}

		return true;
	}

	// generates values from random numbers 
	public static int randomNumber(int i) {
		int lowerBound = 0;
		int upperBound = 0;
		int randomNumber;
		double rawRandomNumber;

		if (i == 5) {
			lowerBound = 25;
			upperBound = 50;

		}

		else if (i == 4) {
			lowerBound = 50;
			upperBound = 75;

		}

		else if (i == 3) {
			lowerBound = 75;
			upperBound = 100;

		}

		else if (i == 2) {
			lowerBound = 100;
			upperBound = 150;

		}

		else if (i == 1) {
			lowerBound = 150;
			upperBound = 200;

		}

		else {
			lowerBound = 250;
			upperBound = 325;

		}

		// generates a random number between 0.0 an 1.0
		rawRandomNumber = Math.random();

		// translates the number into a number between 1 and 10 inclusive
		randomNumber = (int) ((rawRandomNumber * (upperBound - lowerBound)) + lowerBound);

		// Place the body of the drawing method here
		return randomNumber;
	}

	// handles cost of purchase
	public static double buy_Sell(int quantity, int i) {
		double money;
		double price;
		String price2;
		price2 = lblPrice[i].getText();
		price = Double.valueOf(price2).doubleValue();

		money = price * quantity;
		return money;
	}

	// ends game at 30 days or 0 money
	public static boolean gameOver(double money, int days, int[] shoe) {
		int num = 0;
		boolean game = true;
		for (int i = 0; i <= 5; i++) {
			if (shoe[i] == 0) {
				num++;
			}
		}

		if (money == 0 && num == 6) {

			game = false;
		}

		if (days > 30) {
			game = false;

		}

		return game;
	}

	// ends game if won
	public static void winner() {

		lblHelp.setText("");
		lblHelp.setText("YOU WON\n Your score: " + days + " days");
	}

	// prints help menu
	public static void help() {
		lblHelp.setText("***HOW TO PLAY THIS GAME*** \n\n GOAL:\n\n "
				+ "1. The goal of this game is to pay\n "
				+ "off your loan as fast as possible\n\n "
				+ "2. To make money, you must buy\nand sell shoes.\n\n "
				+ "3. To buy shoes type a quanity\n(up to 7) and press \"buy\"\n\n "
				+ "4. To sell shoes type quanitity and \nclick \"Sell\"\n\n "
				+ "5. Each store has different prices \n"
				+ "click on the button with the store \n"
				+ "name to change the store.\n\n "
				+ "6. Each time you visit a new store \n"
				+ "a day will pass.\n\n " + "7. You have 30 days to pay off \n"
				+ "your $500 loan from your boss.");
	}

	// prints about menu
	public static void about() {
		lblHelp.setText("********************************\n"
				+ "Created by Charlie Hay\n" + "Copyright 2009\n"
				+ "********************************");
	}

	// creates new game
	public static void newGame() {

		lblHelp.setText("");

		for (int i = 0; i <= 5; i++) {
			shoe[i] = 0;
			lblShoes[i].setText("" + shoe[i]);
			txtQuantity[i].setText("0");
			txtPayment.setText("0");
			lblShoe[i].setText("Shoe " + i);
			lblPrice[i].setText("");
		}

		days = 0;
		money = 200;
		owed = 500;
		store = -1;
		lblOwe.setText("You still owe " + owed + " to your boss");
		lblDaysLeft
				.setText("You have " + (30 - days) + " to pay off your debt");
		lblDays.setText("" + days);
		lblCash.setText("" + money);
	}

	// the venue organization ie Wal-mart, etc.
	public static void venue(int i) {
		int store2 = i;
		if (store2 != store) {
			days = days + 1;
			if (days == 30) {
				lblDaysLeft.setText("last day");
			} else if (days > 30) {
				disables();
				lblDays.setText("" + days);
				lblDaysLeft.setText("You have 0 days left");

			} else {
				lblDays.setText("" + days);
				lblDaysLeft.setText("You have " + (30 - days) + " days left");
			}
			for (int j = 0; j <= 5; j++) {
				int randomNum;
				randomNum = randomNumber(j);
				lblPrice[j].setText("" + randomNum + ".99");
			}
		}

		store = store2;
		game = gameOver(money, days, shoe);
		if (game == false) {
			lblHelp.setText("GAME OVER");

		}
	}

	// buy shoes and handle cost
	public static void buy(int j) {
		lblShoe[j].setText("Shoe " + (j + 1));
		int quantity;
		double money2;
		quantity = Integer.parseInt(txtQuantity[j].getText());
		if (quantity > 7 || quantity + shoe[j] > 7) {
			lblShoe[j].setText("Can only have 7 shoes");
		}

		else {
			money2 = buy_Sell(quantity, j);
			if (money2 <= money) {
				money = money - money2;
				lblCash.setText("" + money);
				shoe[j] = shoe[j] + quantity;
				lblShoes[j].setText("" + shoe[j]);
			} else {
				lblShoe[j].setText("don't have the money");
			}
		}

		game = gameOver(money, days, shoe);
		if (game == false) {
			lblHelp.setText("GAME OVER");

		}
	}

	// sell inventory
	public static void sell(int m) {
		lblShoe[m].setText("Shoe " + (1 + m));
		int quantity;
		double money2;
		quantity = Integer.parseInt(txtQuantity[m].getText());
		money2 = buy_Sell(quantity, m);
		if (quantity <= shoe[m]) {
			money = money + money2;
			lblCash.setText("" + money);
			shoe[m] = shoe[m] - quantity;
			lblShoes[m].setText("" + shoe[m]);
		}

		else {
			lblShoe[m].setText("don't have the shoes");
		}

		game = gameOver(money, days, shoe);
		if (game == false) {
			lblHelp.setText("GAME OVER");

		}
	}

	// handle button enable/disable
	public static void disables() {
		for (int i = 0; i <= 5; i++) {
			btnBuySell[0][i].setEnabled(false);
			btnBuySell[1][i].setEnabled(false);
		}
		for (int i = 0; i <= 4; i++) {
			btnVenue[i].setEnabled(false);
		}
		btnPay.setEnabled(false);
		btnHelp.setEnabled(false);
		btnAbout.setEnabled(false);
		btnHighScores.setEnabled(false);
	}
}
