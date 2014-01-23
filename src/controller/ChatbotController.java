package controller;

import java.util.ArrayList;

import model.Chatbot;
import view.ChatbotFrame;
import view.ChatbotView;
/**
 * Controller class for the Chatbot project
 * @author CJ Oman
 * @version 1.3
 * @date 10/23/13 removed old popups, Adding realGUI, reference to Chatbot.
 */
public class ChatbotController
{
	private Chatbot myChatbot;
	private ChatbotFrame appFrame;
	
	public ChatbotController()
	{
		myChatbot = new Chatbot();
	}
	
	public Chatbot getMyChatbot()
	{
		return myChatbot;
	}
	
	public void start()
	{
		appFrame = new ChatbotFrame(this);
		
	}
	
	private String conversationHelper(ArrayList<String> currentList)
	{
		String currentConversationPiece = "";
		
		if(currentList.size() > 0)
		{
			currentConversationPiece = currentList.remove(0);
		}
		
		return currentConversationPiece;
	}
	
	public String processConversation()
	{
		String currentConversation = "";
		
		currentConversation = conversationHelper(myChatbot.topicConversation1());
		
		return currentConversation;
	}
	
	public String processMeme(String currentInput)
	{
		String memeResponse = "you don't like memes?";
		
		if(myChatbot.memeChecker(currentInput))
		{
			memeResponse = currentInput + " is a cool meme";
		}
		
		return memeResponse;
	}
}
