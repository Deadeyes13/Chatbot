package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 * Explanation of the class: Chatbot model to test String manipulation and use.
 * @author CJ Oman
 * @version 1.5
 * @date 10/30/13
 */
public class Chatbot
{

	
	/**
	 * An ArrayList of Strings that holds the memes for the program.
	 */
	private ArrayList<String> myMemes;
	
	/**
	 *  An ArrayList of Strings that holds the Dogs for the program.
	 */
	private ArrayList<String> myDogs;

	/**
	 *  An ArrayList of Strings that holds the Monkeys for the program.
	 */
	private ArrayList<String> myMonkeys;
	
	/**
	 * An ArrayList of Strings to hold random objects.
	 */
	private ArrayList<String> randomList;
	
	private ArrayList<String> conversationList;
	
	public Chatbot()
	{
		myMemes = new ArrayList<String>();
		myDogs = new ArrayList<String>();
		myMonkeys = new ArrayList<String>();
		randomList = new ArrayList<String>();
		conversationList = new ArrayList<String>();
		
		fillTheMemeList();
		fillTheDogList();
		fillTheMonkeyList();
		fillTheRandomList();
		fillTheConversationList();
	}
	
	public String contentBased(String currentInput)
	{
		String processed = "";
		
		if(currentInput.contains("boo"))
		{
			processed = "oooh scary";
		}
		else
		{
			processed = "boooring";
		}
		return processed;
	}
/*
 *  Will put your name into alphabetical order.
 */
	public String alphabetizeYourName(String first, String middle, String last)
	{
		String nameInOrder = "";
		
		if(first.compareTo(middle)<0)
		{
			if(first.compareTo(last)<0)
			{
				if(middle.compareTo(last)<0)
				{
					nameInOrder = first + ", " + middle + ", " + last;
				}
				else
				{
					nameInOrder = first + "," + last + ", " + middle;
				}
			}
			else
			{
				nameInOrder = last + "," + first + ", " + middle;
			}
		}
		else
		{
			if(middle.compareTo(last)<0)
			{
				if(first.compareTo(last)<0)
				{
					nameInOrder = middle + ", " + first + ", " + last;
				}
				else
				{
					nameInOrder = middle + ", " + last + ", " + first;
				}
			}
			else
			{
				nameInOrder = last + ", " + middle + ", " + first;
			}
		}
		
		return nameInOrder;
	}
	
	/**
	 * Fills the randomList with various Strings for the chatbot.
	 */
	public void fillTheRandomList()
	{
	randomList.add("I like cheese");
	randomList.add("I hate essays");
	randomList.add("I like cereal");
	randomList.add("This is random");
	randomList.add("I like typing");
	}
	
	/**
	 * This method chooses a random item from the randomList.
	 * @return A random element from the randomList.
	 */
	public String getRandomTopic()
	{
		String randomTopic = "";
		
		double myRandom = Math.random();
		int myRandomListPosition = (int) (myRandom * randomList.size());
		randomTopic = randomList.get(myRandomListPosition);
		
		return randomTopic;
	}
	
	/**
	 * Returns the users answer with a new statement.
	 */
	public void topicConversation2()
	{
		String answer;
//		must have at least 3 JOptionPane.showMessageDialog statements about a single topic of your choice.
		answer = JOptionPane.showInputDialog("Do you like RPG?");
		JOptionPane.showInputDialog(answer + " OH, How about pokemon?");
		JOptionPane.showMessageDialog(null, answer + " Oh, I see");
		answer = JOptionPane.showInputDialog("How about Final Fantasy");
		JOptionPane.showMessageDialog(null, answer + " Its my favorite");
		answer = JOptionPane.showInputDialog("Which RPG do you like?");
		JOptionPane.showMessageDialog(null, answer + ", Oh, I like that one to.");	
	}
	
	/**
	 * Fills the MonkeyList with the comments in parenthesis.
	 */
	private void fillTheMonkeyList()
	{
		myMonkeys.add("monkey see");
		myMonkeys.add("monkey hear");
		myMonkeys.add("monkey do");
	}
	
	/**
	 * Fills the DogList with the comments in parenthesis.
	 */
	private void fillTheDogList()
	{
		myDogs.add("Dog");
		myDogs.add("Dogs");
		myDogs.add("I like dogs.");
		myDogs.add("Do you have a dog?");
		myDogs.add("Where is my dog?");
		myDogs.add("Woof");
		myDogs.add("I need to let my dog out.");
	}
	
	/**
	 * Fills the memeList with the comments in parenthesis.
	 */
	private void fillTheMemeList()
	{
		myMemes.add("nicolas cage");
		myMemes.add("arrow to the knee");
		myMemes.add("one does not simply");
		myMemes.add("y u no");
	}
	
	private void fillTheConversationList()
	{
		conversationList.add("hey I want to talk about fdhdfhdgh");
		conversationList.add("no that was not keyboard mashing");
		conversationList.add("what do you know now");
		
	}
	
	public ArrayList<String> topicConversation1()
	{	
		return conversationList;
	}
	
	/**
	 * Checks the currentInput from the user and checks if it is a member of the MonkeyList.
	 * It returns true if the input is a member of the list.
	 * @param currentInput The current phrase typed by the user.
	 * @return Returns whether or not the users input is related to Monkeys.
	 */
	public boolean monkeyChecker(String currentInput)
	{
		boolean hasMonkey = false;
//		Loop over all the items in the list,  if the input matches a meme, change hasMeme to true.
		
		if(currentInput != null)
		{
			for(String currentPhrase : myMonkeys)
			{
				if(currentPhrase.equalsIgnoreCase(currentInput))
				{
				hasMonkey = true;
				}
			}
		}
		
		return hasMonkey;
	}
	
	/**
	 * Checks the currentInput from the user and checks if it is a member of the dogList.
	 * It returns true if the input is a member of the list.
	 * @param currentInput The current phrase typed by the user.
	 * @return Returns whether or not the users input is related to dogs.
	 */
	public boolean dogChecker(String currentInput)
	{
		boolean hasDog = false;
//		Loop over all the items in the list,  if the input matches a meme, change hasMeme to true.
		
		if(currentInput != null)
		{
			for(String currentPhrase : myDogs)
			{
				if(currentPhrase.equalsIgnoreCase(currentInput))
				{
				hasDog = true;
				}
			}
		}
		
		return hasDog;
	}
	/**
	 * One to two sentence explanation of the method. Full sentences with punctuation. Checks the current input from the user to see if it is a member of the memeList.
	 * It returns true if the input is a member of the list.
	 * @param currentInput Explanation of the variable. The current phrase typed by the user.
	 * @return What it returns by the method. In this case the method returns whether or not the input is a meme from the memeList
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
//		Loop over all the items in the list,  if the input matches a meme, change hasMeme to true.
		
		if(currentInput != null)
		{
			for(String currentPhrase : myMemes)
			{
				if(currentPhrase.equalsIgnoreCase(currentInput))
				{
				hasMeme = true;
				}
			}
		}
		
		return hasMeme;
	}
}
