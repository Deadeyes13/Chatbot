package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.ChatbotController;
import model.Chatbot;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author CJ Oman
 * @version 1.4
 * @date 10/23/13
 */
public class ChatbotPanel extends JPanel
{
	/*
	 * The thing that controls the Chatbot.
	 */
	private ChatbotController baseController;
	
	/*
	 *  The button that submits info to chatbot.
	 */
	private JButton submitButton;
	
	/*
	 * The field users input data to.
	 */
	private JTextField userInputField;
	
	/*
	 *  The area that user inputs to.
	 */
	private JTextArea chatArea;

	/*
	 * layout of the Chatbot.
	 */
	private SpringLayout baseLayout;
	
	/*
	 *  The Pane that Chabot comments are on.
	 */
	private JScrollPane textPane;
	
	/*
	 * The Chatbot.
	 */
	private Chatbot appBot;
	
	private int clickCount;
	
	/*
	 *  Defines the Chatbot Panel.
	 */
	public ChatbotPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		this.appBot = baseController.getMyChatbot();
		
		submitButton = new JButton("Submit this to Chatbot!");
		userInputField = new JTextField(30);
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 17, SpringLayout.SOUTH, userInputField);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 153, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, userInputField, 102, SpringLayout.WEST, this);
		chatArea = new JTextArea(10,30);
		textPane = new JScrollPane(chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, userInputField, 17, SpringLayout.SOUTH, textPane);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 17, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 92, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -93, SpringLayout.EAST, this);
		
		clickCount = 0;
		
		setupPanel();
		setupLayout();
		setupListeners();
		
		startChat();
	}
	
	/*
	 *  Starts up the chat.
	 */
	private void startChat()
	{
		chatArea.setText(appBot.getRandomTopic());
	}
	
	/*
	 *  Used to setup the Panel.
	 */
	private void setupPanel()
	{
		setBackground(Color.BLUE);
		this.setLayout(baseLayout);
		this.add(submitButton);
		this.add(userInputField);
		this.add(textPane);
		
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		
		
	}
	
	/*
	 *  Used to setup the layout.
	 */
	private void setupLayout()
	{
		
		chatArea.setBackground(Color.CYAN);
		userInputField.setBackground(Color.CYAN);
		submitButton.setBackground(Color.CYAN);
	
	}

	/*
	 *  Sets up the listeners.
	 */
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			/*
			 * this is what happens when I click the button.
			 */
			public void actionPerformed(ActionEvent click)
			{
				clickCount ++;
				
				String currentInput = userInputField.getText();
				
				if(clickCount % 7 == 0)
				{
					String currentConversation = baseController.processConversation();
					
					if(currentConversation.length() != 0)
					{
						chatArea.append(currentConversation);
						clickCount--;
					
					}
				}
				else if(clickCount % 11 == 0)
				{
					chatArea.append(baseController.processMeme(currentInput));
				}
				else
				{
					
					chatArea.append("\n" + currentInput);
					chatArea.append("\n" + appBot.getRandomTopic());
				}	
			}
		});
	}
}
