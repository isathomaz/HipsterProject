package hipster.view;

import javax.swing.JFrame;

import hipster.controller.HipsterController;
import hipster.view.HipsterPanel;
/**
 * Frame class for hipster project. Extends JFrame.
 * @author Isabella Thomaz
 *@version 1.1 created frame and set it up.
 */
public class HipsterFrame extends JFrame
{
	private HipsterController baseController;
	private HipsterPanel basePanel;
		
	public HipsterFrame(HipsterController baseController)
	{
		this.baseController = baseController;
		basePanel = new HipsterPanel(baseController);
			
		setupFrame();
	}
		
	private void setupFrame()
	 {
		this.setContentPane(basePanel);
		this.setSize(800, 800);
		this.setVisible(true);
	}
}
