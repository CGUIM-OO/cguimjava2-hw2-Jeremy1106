import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author TODO: B0444238 詹子霆
 * 					    在Class Deck裡面要請人輸入有給副牌
 * 					  x是想要看幾副牌的個數，nDeck是使用人輸入的給副牌的數量
 * 					    然後再利用一副牌有四種花色，用y來表示
 * 					  z想要表示的是每一種花色都有13個數字
 * 					    以上都是用for迴圈去進行迴圈。 
 * 					    設立一個Card的型態,變數的名稱叫做card。在這裡面的y以及z的型態和Class Card裡面的s跟r是一樣的
 * 					    如果想要新增牌，就是在ArrayList這個裡面以card這個型態去新增。
 * 					    在printDeck()裡面是從i開始去取到整個牌組，所以利用cards.size來確定他的長度
 * 					    利用一個變數j去取裡面的數值從每副牌組的第一位取到最後，
 * 					    最後再把j取到的數值print出來。
 * 
 * 					    在Class Card裡面
 * 					    在Card裡面確立s以及r的型態
 * 					    在getSuit()和getRank()裡面是在進行回傳，把suit以及rank拿到的值儲存起來
 * 					    最後在printCard()裡面把兩個getSuit()以及getRank()拿到的東西print出來。(methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: 要請人輸入有給副牌
 * 					  x是想要看幾副牌的個數，nDeck是使用人輸入的給副牌的數量
 * 					    然後再利用一副牌有四種花色，用y來表示
 * 					  z想要表示的是每一種花色都有13個數字
 * 					    以上都是用for迴圈去進行迴圈。 
 * 					    設立一個Card的型態,變數的名稱叫做card。在這裡面的y以及z的型態和Class Card裡面的s跟r是一樣的
 * 					    如果想要新增牌，就是在ArrayList這個裡面以card這個型態去新增。
 * 
 * 					    在printDeck()裡面是從i開始去取到整個牌組，所以利用cards.size來確定他的長度
 * 					    利用一個變數j去取裡面的數值從每副牌組的第一位取到最後，
 * 					    最後再把j取到的數值print出來。
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		
		for(int x=1;x<=nDeck;x++){
			for(int y=1;y<5;y++){
				for(int z=1;z<14;z++){
					Card card=new Card(y,z);
					cards.add(card);
				}
			}
		}

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		for(int i=0;i<cards.size();i++){
			Card j=cards.get(i);
			j.printCard();
		}
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: 在Card裡面確立s以及r的型態
 * 					    在getSuit()和getRank()裡面是在進行回傳，把suit以及rank拿到的值儲存起來
 * 					    最後在printCard()裡面把兩個getSuit()以及getRank()拿到的東西print出來。
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13

	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;	
	}
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		
		System.out.println(getSuit()+","+getRank());
		
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
