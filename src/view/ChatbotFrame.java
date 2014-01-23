package view;

import javax.swing.JFrame;

import controller.ChatbotController;

/**
 * @author CJ Oman
 * @version 1.4
 * @date 10/23/13
 */
public class ChatbotFrame extends JFrame
{
	
	/*
	 *  gives a name to ChatbotController.
	 */
	private ChatbotController baseController;
	
	/*
	 * Gives a name to ChatbotPanel.
	 */
	private ChatbotPanel basePanel;
	
	/*
	 * Defines ChatbotFrame.
	 */
	public ChatbotFrame(ChatbotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatbotPanel(baseController);
		
		setupFrame();
	}
	
	/*
	 *  Setup for the Frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setVisible(true);
	}
}
