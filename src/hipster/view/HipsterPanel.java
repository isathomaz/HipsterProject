package hipster.view;

import hipster.controller.HipsterController;
import hipster.model.Hipster;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
/**
 * Panel Class for hipster project. Extends JPanel.
 * @author Isabella Thomaz
 *@version 1.2 added spring layout to panel and add a background color.
 */
public class HipsterPanel extends JPanel
{
	/*
	 * the reference to the HipsterController to maintain a MVC paradigm in the code.
	 */
	private HipsterController baseController;
	
	private JButton addHipsterButton;
	private JButton showRandomButton;
	private JButton showSpecificButton;
	private JButton showSelfButton;
	private JButton resetButton;
	private JLabel nameLabel;
	private JLabel phraseLabel;
	private JLabel typeLabel;
	private JLabel booksLabel;
	private JComboBox selectedHipsterComboBox;
	private JTextField nameField;
	private JTextField phraseField;
	private JTextField typeField;
	private JTextArea booksArea;
	private PicturePanel picturePanel;
	private URL imageURL;
	private JScrollPane textPane;
	private SpringLayout baseLayout;
	private String [] baseArray;

	/**
	 * Constructior for the HipsterPanel object. Uses a HipsterController to link to the MVC paradigm.
	 * @param baseController the reference to the controller for the project.
	 */
	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		
		addHipsterButton = new JButton("Add a hipster");
		showRandomButton =  new JButton("Show a Random Hipster");
		showSpecificButton =  new JButton("Show a Certain Hipster");
		showSelfButton =  new JButton("Show the Original Hipster");
		resetButton = new JButton("Reset!");
		nameLabel = new JLabel("Hipster's Name: ");
		phraseLabel = new JLabel("Hipster's Phrase: ");
		typeLabel = new JLabel("Hipster's Type: ");
		booksLabel = new JLabel("Hipster's Books: ");
		nameField = new JTextField(25);
		phraseField = new JTextField(25);
		typeField = new JTextField(25);
		booksArea = new JTextArea(5,25);
		baseArray = new String[10];
		textPane = new JScrollPane(booksArea);

		imageURL = getClass().getResource("/hipster/view/images/hipsterwolf2.jpg");
		picturePanel = new PicturePanel(imageURL, 300, 300);
		
		baseLayout = new SpringLayout();
		
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	/**
	 * helper method to get the contents of the Hipster array and extracting the names of the Hipster's in it.
	 * @return
	 */
	private String[] getNamesForComboBox()
	{
		int realValues = 0;
		for (int count = 0; count < baseController.getCubbyHipsters().length; count++)
		{
			if (baseController.getCubbyHipsters()[count] != null)
			{
				realValues++;
			}
		}
		String [] tempNames = new String[realValues];
		
		for(int realSize = 0; realSize< realValues; realSize++)
		{
			tempNames[realSize] = baseController.getCubbyHipsters()[realSize].getName();
		}
		return tempNames;
	}
	/**
	 * helper method to repopulate the JComboBox after adding Hipster's to the array.
	 */
	private void updateHipsterComboBox()
	{
		String [] comboValues = getNamesForComboBox();
		selectedHipsterComboBox.setModel(new DefaultComboBoxModel(comboValues));
	}

	private void setupComboBox()
	{
		baseArray[0] = "Me";
		baseArray[1] = "Myself";
		baseArray[2] = "I";
		
		selectedHipsterComboBox = new JComboBox(baseArray);
	}
	/**
	 * populates the fields based on the current hipster object.
	 * @param currentHipster
	 */
	private void populateFields(Hipster currentHipster)
	{
		nameField.setText(currentHipster.getName());
		typeField.setText(currentHipster.getHipsterType());
		phraseField.setText(currentHipster.getHipsterPhrase());
		for(String temp : currentHipster.getHipsterBooks())
		{
			booksArea.append(temp + ", ");
		}
	}
	
	private void blankFields(boolean poorInput)
	{
		nameField.setText("");
		typeField.setText("");
		phraseField.setText("");
		booksArea.setText("");
		if(poorInput)
		{
			JOptionPane.showMessageDialog(this, "please use valid options");
		}
	}
	
	/**
	 * sends information to the HipsterController.
	 */
	private void sendHipsterInfoToController()
	{
		String [] books = booksArea.getText().split("' ");
		baseController.addHipster(books, nameField.getText(), typeField.getText(), phraseField.getText());
		JOptionPane.showMessageDialog(this,  "hipster added to the array");
	}
	
	/**
	 * helper method to add components to the panel as well as set the secondary values for GUI components.
	 */
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(addHipsterButton);
		this.add(showRandomButton);
		this.add(showSpecificButton);
		this.add(showSelfButton);
		this.add(resetButton);
		this.add(nameLabel);
		this.add(phraseLabel);
		this.add(typeLabel);
		this.add(booksLabel);
		this.add(nameField);
		this.add(phraseField);
		this.add(typeField);
		this.add(picturePanel);
		this.add(textPane);
		this.add(selectedHipsterComboBox);
		
		this.setBackground(new Color(72, 61, 139));
		this.setSize(1000,500);
		booksArea.setWrapStyleWord(true);
		booksArea.setLineWrap(true);			
	}
	
		
	public void setupLayout()
	{	
		baseLayout.putConstraint(SpringLayout.NORTH, resetButton, -4, SpringLayout.NORTH, nameLabel);
		baseLayout.putConstraint(SpringLayout.WEST, resetButton, 150, SpringLayout.EAST, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, -6, SpringLayout.NORTH, booksLabel);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, 0, SpringLayout.EAST, nameField);
		booksLabel.setForeground(Color.WHITE);
		typeLabel.setForeground(Color.WHITE);
		phraseLabel.setForeground(Color.WHITE);
		nameLabel.setForeground(Color.WHITE);
		baseLayout.putConstraint(SpringLayout.NORTH, picturePanel, 188, SpringLayout.NORTH, addHipsterButton);
		baseLayout.putConstraint(SpringLayout.WEST, picturePanel, -296, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, picturePanel, -45, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, showSelfButton, 65, SpringLayout.SOUTH, showRandomButton);
	    baseLayout.putConstraint(SpringLayout.WEST, showSpecificButton, 263, SpringLayout.WEST, this);
	    baseLayout.putConstraint(SpringLayout.SOUTH, showSpecificButton, -83, SpringLayout.SOUTH, this);
	    baseLayout.putConstraint(SpringLayout.WEST, showSelfButton, 0, SpringLayout.WEST, nameLabel);
	    baseLayout.putConstraint(SpringLayout.WEST, showRandomButton, 0, SpringLayout.WEST, nameLabel);
	    baseLayout.putConstraint(SpringLayout.NORTH, addHipsterButton, 22, SpringLayout.SOUTH, booksArea);
	    baseLayout.putConstraint(SpringLayout.WEST, addHipsterButton, 0, SpringLayout.WEST, nameLabel);
	    baseLayout.putConstraint(SpringLayout.NORTH, selectedHipsterComboBox, 18, SpringLayout.SOUTH, showRandomButton);
	    baseLayout.putConstraint(SpringLayout.WEST, selectedHipsterComboBox, 0, SpringLayout.WEST, addHipsterButton);
	    baseLayout.putConstraint(SpringLayout.NORTH, booksLabel, 0, SpringLayout.NORTH, booksArea);
	    baseLayout.putConstraint(SpringLayout.WEST, booksLabel, 0, SpringLayout.WEST, nameLabel);
	    baseLayout.putConstraint(SpringLayout.NORTH, nameField, 22, SpringLayout.NORTH, this);
	    baseLayout.putConstraint(SpringLayout.NORTH, nameLabel, 6, SpringLayout.NORTH, nameField);
	    baseLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, phraseLabel);
	    baseLayout.putConstraint(SpringLayout.NORTH, typeLabel, 6, SpringLayout.NORTH, typeField);
	    baseLayout.putConstraint(SpringLayout.WEST, typeLabel, 0, SpringLayout.WEST, phraseLabel);
	    baseLayout.putConstraint(SpringLayout.NORTH, phraseLabel, 6, SpringLayout.NORTH, phraseField);
	    baseLayout.putConstraint(SpringLayout.WEST, phraseLabel, 10, SpringLayout.WEST, this);
	    baseLayout.putConstraint(SpringLayout.NORTH, booksArea, 18, SpringLayout.SOUTH, phraseField);
	    baseLayout.putConstraint(SpringLayout.WEST, booksArea, 0, SpringLayout.WEST, nameField);
	    baseLayout.putConstraint(SpringLayout.NORTH, phraseField, 17, SpringLayout.SOUTH, typeField);
	    baseLayout.putConstraint(SpringLayout.NORTH, typeField, 11, SpringLayout.SOUTH, nameField);
	    baseLayout.putConstraint(SpringLayout.WEST, typeField, 0, SpringLayout.WEST, nameField);
	    baseLayout.putConstraint(SpringLayout.WEST, phraseField, 0, SpringLayout.WEST, nameField);
	    baseLayout.putConstraint(SpringLayout.WEST, nameField, 175, SpringLayout.WEST, this);
	    baseLayout.putConstraint(SpringLayout.EAST, picturePanel, -20, SpringLayout.EAST, this);
	    baseLayout.putConstraint(SpringLayout.NORTH, showRandomButton, 18, SpringLayout.SOUTH, addHipsterButton);
	}
	
	/**
	 * helper method for creating all the needed listeners for the GUI.
	 */
	public void setupListeners()
	{
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				JOptionPane.showMessageDialog(null, "Resetting...Resetting...Resetting...");
				for(int i = 0; i < baseController.getCubbyHipsters().length; i++)
				{
					baseController.resetHipster(i);
				}
				updateHipsterComboBox();
				blankFields(false);
				
			}
		});
		addHipsterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sendHipsterInfoToController();
				updateHipsterComboBox();
				blankFields(false);
			} 
		});
		showSelfButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Hipster selfHipster = baseController.getSelfHipster();
				populateFields(selfHipster);
			}
		});
		showSpecificButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Hipster selectedHipster = baseController.getSpecifiedHipster(0);
				if (selectedHipster != null)
				{
					populateFields(selectedHipster);
				}
				else
				{
					blankFields(true);
				}
			}
		});
		showRandomButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Hipster randomHipster =baseController.getRandomHipster();
				if(randomHipster != null)
				{
					populateFields(randomHipster);
				}
				else
				{
					blankFields(true);
				}
			}
		});
		selectedHipsterComboBox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent itemSelected)
			{
				int currentSelection = selectedHipsterComboBox.getSelectedIndex();
				if(currentSelection>= 0)
				{
					Hipster selectedHipster = baseController.getSpecifiedHipster(currentSelection);
					if(selectedHipster != null)
					{
						populateFields(selectedHipster);
					}
					else
					{
						blankFields(true);
					}
				}
			}

			
		});
	}
}
