/*
 * Name     : Derreck Mansheim
 * Depaul#  : 4457125
 * Class    : SE 450
 * Homework : #2
 * Problem  : LectureTwo
 * Due Date : 09/29/2016
 *
 * class LectureTwo
 *
 */

import java.awt.Container;
import java.awt.Dimension;
//ActionEvents
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

//for various J'Controls'
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class HomeworkTwoTemplate extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;//I added this to remove the warning the Eclipse generates

	private Container   content;//used for the content pane
	
	private JPanel      movePanel;//l,u,r,d buttons
	
	private JButton     upButton; //up button
	private JButton     leftButton; //let button
	private JButton     rightButton; //right button
	private JButton     downButton; //down button
	
	private JCustomPanel  shapeOutput; //the output for the shape data
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public HomeworkTwoTemplate()
	{
		setSize(400, 600);//set the size of the window to 300 x 300
		setTitle("LectureTwo");//set the applications title
		
		//Now create a panel to hold the move combo box and move description
		movePanel = new JPanel();
		
		//create the move buttons
		upButton = new JButton("Up");
		leftButton = new JButton("Left");
		rightButton = new JButton("Right");
		downButton = new JButton("Down");
		
		upButton.setPreferredSize(new Dimension(100, 50));
		leftButton.setPreferredSize(new Dimension(100, 50));
		rightButton.setPreferredSize(new Dimension(100, 50));
		downButton.setPreferredSize(new Dimension(100, 50));
		
		//the spring layout will handle the move panels controls spacing 
		//when the window is initialized and sized/resized
		SpringLayout movePanelLayout = new SpringLayout();

		//now lets set up the controls and how they will be position
		//in accordance to one another
		
		//up button is 5 below panel
		movePanelLayout.putConstraint(SpringLayout.NORTH, upButton, 5, 
									  SpringLayout.NORTH, movePanel);
		
		//up button top adjust horizontally
		movePanelLayout.putConstraint(SpringLayout.WEST, upButton, 115, 
									  SpringLayout.WEST, movePanel);
		
		//down buttons left side with up button left side
		movePanelLayout.putConstraint(SpringLayout.WEST, downButton, 0, 
									  SpringLayout.WEST, upButton);
		
		//left button top side 5 away from up button bottom side
		movePanelLayout.putConstraint(SpringLayout.NORTH, leftButton, -20, 
									  SpringLayout.SOUTH, upButton);

		//right button top side aligned with left button top side
		movePanelLayout.putConstraint(SpringLayout.NORTH, rightButton, 0, 
									  SpringLayout.NORTH, leftButton);
		
		//left button left side 5 away from panel left side
		movePanelLayout.putConstraint(SpringLayout.WEST, leftButton, 5, 
									  SpringLayout.WEST, movePanel);
		
		//left button top side 5 away from up button bottom side
		movePanelLayout.putConstraint(SpringLayout.NORTH, downButton, 10, 
									  SpringLayout.SOUTH, upButton);
		
		//left button top side 5 away from up button bottom side
		movePanelLayout.putConstraint(SpringLayout.SOUTH, movePanel, 5, 
									  SpringLayout.SOUTH, downButton);
		
		//fix move boxes east border -5 pixels away from move texts west border
		movePanelLayout.putConstraint(SpringLayout.EAST, rightButton, -5, 
									  SpringLayout.EAST, movePanel);

		
		//the panel dependencies has been configured so here we set it
		movePanel.setLayout(movePanelLayout);
		
		//add the buttons to the panel
		movePanel.add(leftButton);
		movePanel.add(rightButton);
		movePanel.add(upButton);
		movePanel.add(downButton);
		
		//create the text area for displaying the shape(s) location
		shapeOutput  = new JCustomPanel();
		
		//the output could be lengthy so we'll need a scroll bar
	    JScrollPane scrollPane = new JScrollPane(shapeOutput);
		
		//give the panel an nice etched and titled border with the heading of "Move"
		movePanel.setBorder(new TitledBorder(new EtchedBorder(), "Move"));
		
		//get the content pane, as it is were we'll place our controls
		content = getContentPane();

		//Attach the move panel to the content pane
		content.add(movePanel);
		
		//Attach the scroll pane button to the content pane
		//the scroll pane wrap the move panel, so it will
		//by default include it as well
	    content.add( scrollPane );
		
	    //lets create a final spring layout to include the other layout
	    //and add the rest of the controls
		SpringLayout contentLayout = new SpringLayout();
		
		//move panel setup
		//set move  panels west border 30 pixels away from content panes west border
		contentLayout.putConstraint(SpringLayout.WEST, movePanel, 20, 
									SpringLayout.WEST, content);

		//fix move panels east border -30 pixels away from content panes east border
		contentLayout.putConstraint(SpringLayout.EAST, movePanel, -20, 
									SpringLayout.EAST, content);
		
		//fix move panels north border 10 pixels away from content panes north border
		contentLayout.putConstraint(SpringLayout.NORTH, content, 10, 
									SpringLayout.SOUTH, movePanel);
		
		//fix scroll panes north border 10 pixels away from down buttons south border
		contentLayout.putConstraint(SpringLayout.NORTH, scrollPane, 100, 
									SpringLayout.SOUTH, downButton);
		
		//fix scroll panes south border -10 pixels away from content panes south border
		contentLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, 
									SpringLayout.SOUTH, content);
		
		//fix scroll panes west border 30 pixels away from content panes west border
		contentLayout.putConstraint(SpringLayout.WEST, scrollPane, 30, 
									SpringLayout.WEST, content);
		
		//fix scroll panes east border -30 pixels away from content panes east border
		contentLayout.putConstraint(SpringLayout.EAST, scrollPane, -30, 
									SpringLayout.EAST, content);
		
	    //set the content panes layout 
		content.setLayout( contentLayout );
		
	    //add button click listener to up, left, right, down
		upButton.addActionListener(this);
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		//downButton.addActionListener(this);
		
		downButton.addActionListener(new ActionListener() 
		{
	        public void actionPerformed(ActionEvent arg0) 
	        {
	        	moveShapes(0.0f, 1.0f);
				//shapeOutput.setText("downButton pressed in Anonymous Class");
	        	shapeOutput.repaint();
	        }
	    });
	}
	
	//the main entry point for the application
	public static void main(String[] args) throws BadShapeException
	{
		//create a new homework application
		HomeworkTwoTemplate lectureTwoframe = new HomeworkTwoTemplate();
		
		//set the app to exit when the user presses the close button
		lectureTwoframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the app to be visible
		lectureTwoframe.setVisible(true);
		
		ArrayList<Shape> shapes = ShapeParser.loadShapes("shapes.json");
	 
        lectureTwoframe.setShapes(shapes);
        lectureTwoframe.shapeOutput.repaint();
	}

    public void setShapes(final ArrayList<Shape> newShapes)
    {
    	shapes = newShapes;

    	shapeOutput.setShapes(shapes);//please note ...I will address this problem of where we should put this in next class
    }
    
  	// Inner class for the listener which responds to the move button press.
  	public void actionPerformed(ActionEvent e)
	{
  		//get the action object and test to see where it came from
		Object sourceObject = e.getSource();
		
		//see which button was pressed
		if (sourceObject == leftButton)
		{
			moveShapes(-1.0f, 0.0f);
		}
		else if (sourceObject == upButton)
		{
			moveShapes(0.0f, -1.0f);
		}
		else if (sourceObject == rightButton)
		{
			moveShapes(1.0f, 0.0f);
		}
		else if (sourceObject == downButton)
		{
			//moveShapes(0.0f, 1.0f);
			//shapeOutput.setText("downButton pressed in ActionPerformed");
		}
  		
		shapeOutput.repaint();//trigger the paint routine
	}
  	
  	public void moveShapes(float x, float y)
	{
  		Iterator<Shape> iShapes = shapes.iterator();
  		while (iShapes.hasNext())
  		{
  			Shape shape = iShapes.next();
  			shape.move(x, y);	
  		}
	}	
}
      