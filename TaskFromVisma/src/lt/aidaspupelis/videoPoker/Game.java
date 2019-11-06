package lt.aidaspupelis.videoPoker;

public class Game {
		
		private Player player;
		public static Deck deck;
		
		public Game() {
			player = new Player();
			deck = new Deck();
		}
		
		public void play() {

			player.resetCards();


			for(int i = 0; i<5; i++) { // drawing FIVE cards
				Card card = deck.draw();
				player.addCard(card); //adds a card to the array hand (in player class)
			}

			
			System.out.println("Your cards are:");
			System.out.println(player.toString()); //shows player initial cards
			
			player.rejectCards();	// carries out method in player class if player rejects cards.
			
			System.out.println();

			//version_1
			//player.categorizeHandV1();

			//version_2
			//System.out.println(player.categorizeHandV2());

			//version_3
			player.categorizeHandV3();

		}
		
		
			
		
		
		
			
			
		

}
