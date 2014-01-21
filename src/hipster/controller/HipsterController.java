package hipster.controller;

import javax.swing.JOptionPane;

import hipster.model.Hipster;
import hipster.view.HipsterFrame;

/**
 * Controller for hipster project.
 * @author Isabella Thomaz
 * @version 1.1 11/19/2013 Added Constructor information. Added methods for retrieval of Hipsters and documentation.
 */
public class HipsterController
{
	/**
	 * The hipster frame reference for MVC
	 */
	private HipsterFrame appFrame;
	/**
	 * The hipster object representing me.
	 */
	private Hipster selfHipster;
	/**
	 * the array of hipsters for the class.
	 */
	private Hipster [] cubbyHipsters;
	/**
	 * the current inserted Hipster in the array.
	 */
	private int hipsterCount;
		
	public HipsterController()
	{
		selfHipster = new Hipster();
		cubbyHipsters = new Hipster [4];
		hipsterCount = 0;
	}
	public Hipster[] getCubbyHipsters()
	{
		return cubbyHipsters;
	}
	/**
	 * getter method for the hipster representing myself.
	 * @return
	 */
	public Hipster getSelfHipster()
	{
		return selfHipster;
	}
	/**
	 * replacing the current hipster
	 * @param selfHipster
	 */
	public void setSelfHipster(Hipster selfHipster)
	{
		this.selfHipster = selfHipster;
	}

	public void start()
	{
		appFrame = new HipsterFrame(this);
	}
	/**
	 * retrieves the hipster from the specified position in the array.
	 * @param position
	 * @return
	 */
	public Hipster getSpecifiedHipster(int position)
	{
		Hipster currentHipster = null;
		
		if(position < cubbyHipsters.length)
		{
			currentHipster = cubbyHipsters[position];
		}
		
		return currentHipster;
	}
	
	/**
	 * Used to retriece a random hipster object form the array of the Class Hipsters.
	 * @return
	 */
	public Hipster getRandomHipster()
	{
		Hipster currentHipster = null;
		
		int randomIndex = 0;
		double random = Math.random();
		randomIndex = (int) (random * cubbyHipsters.length);
		currentHipster = cubbyHipsters[randomIndex];
		
		return currentHipster;
	}
	
	public void resetHipster(int position)
	{
		cubbyHipsters[position] = null;
	}
	
	public void setHipster(int position, String [] books, String name, String type, String phrase)
	{
		cubbyHipsters[position] = new Hipster(name, type, phrase, books);
	}
	
	/**
	 * Creates and adds a hipster to the array of class hipsters from the specified values.
	 * @param books
	 * @param name
	 * @param type
	 * @param phrase
	 */
	public void addHipster(String [] books, String name, String type, String phrase)
	{
		if(hipsterCount < cubbyHipsters.length)
		{
			Hipster tempHipster = new Hipster(name, type, phrase, books);
			cubbyHipsters[hipsterCount] = tempHipster;
			hipsterCount++;
		}
		else
		{
			JOptionPane.showMessageDialog(appFrame, "The cubby is full. You are too mainstream to be included.");
		}
	}
}
