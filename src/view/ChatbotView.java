package view;

import javax.swing.JOptionPane;

import model.Chatbot;

/**
 * 
 * @author CJ Oman
 * @version 1.4
 * @date 10/23/13
 */
public class ChatbotView
{
	/**
	 * Defines the Chatbot.
	 */
	private Chatbot myChatbot;
	
 
	public ChatbotView()
	{
		myChatbot = new Chatbot();
	}

	/**
	 * Determines whether the input is yes or no and will keep going till user inputs no.
	 */
	public void showApp()
	{
		String answer = "keep going";

		while (answer == null || !answer.equals("no"))
		{
			JOptionPane.showMessageDialog(null, myChatbot.getRandomTopic());
			answer = getInput();
			useInput(answer);
		}

		myChatbot.topicConversation1();
		
	}

	/**
	 * Gets the users first input.
	 * @return The current phrase typed by the user.
	 */
	private String getInput()
	{
		String userInput = "";

		userInput = JOptionPane.showInputDialog("Do you want to talk?");

		return userInput;
	}

	/**
	 * Replies with a message based on what the user inputs.
	 * @param currentInput The current phrase typed by the user.
	 */
	private void useInput(String currentInput)
	{
		JOptionPane.showMessageDialog(null, "seriously");

		if (myChatbot.memeChecker(currentInput))
		{
			JOptionPane.showMessageDialog(null, "you like memes huh");
		}
		
		if(myChatbot.dogChecker(currentInput))
		{
			JOptionPane.showMessageDialog(null, "you like dogs huh");
		}
		
		if(myChatbot.monkeyChecker(currentInput))
		{
			JOptionPane.showMessageDialog(null, "you like monkeys");
		}
	}
	
}