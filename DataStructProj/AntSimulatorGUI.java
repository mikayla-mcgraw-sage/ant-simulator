

import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class AntSimulatorGUI {
JFrame frame = new JFrame("Ant Simulator"); // create frame
static JButton[][] grid; // name grid
JLabel cordinates = new JLabel();
static JButton runButton = new JButton();
static JButton forgerButton = new JButton();
static JTextField dayCount = new JTextField();
static JTextField turnCount = new JTextField();
static ArrayList <ant> antColony = new ArrayList<ant>();
static int ID = 0;
static gridNode[][] myGridNode;
	
	String foodLabel = "Food: ";
	String soilderLabel = "Soldier: ";
	String queenLabel = "Queen: ";
	String scoutLabel = "Scout: ";
	String forgerLabel = "Forger: ";
	String balaLabel = "Bala: ";
	String pheromoneLabel = "Pheromone: ";
// constructor
public AntSimulatorGUI (int widthCopy, int lengthCopy) {

	int middleWidth = widthCopy/2;
	int middleLength = lengthCopy/2;
	JPanel panel = new JPanel(new GridLayout(widthCopy, lengthCopy));	
	panel.setBackground(Color.lightGray);	
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    frame.add(panel);
    
    // create grid
   grid = new JButton[widthCopy][lengthCopy]; // allocate size
   final JScrollPane sp = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   frame.add(sp);
   JLabel turnCounter = new JLabel();
   turnCounter.setText("Turn:");
   JMenuBar menuBar = new JMenuBar();
   frame.setJMenuBar(menuBar);
   runButton.setText("Run");
   menuBar.add(runButton);
   
   JButton stepButton = new JButton();
  
   stepButton.setText("Step");
   menuBar.add(stepButton);
   
   JLabel dayLabel = new JLabel();
   JLabel turnLabel = new JLabel();

   dayCount.setText("0");
   turnCount.setText("0");
   
   dayLabel.setText("Day:");
   turnLabel.setText("Turn:");
   menuBar.add(dayLabel);
   menuBar.add(dayCount);
   menuBar.add(turnLabel);
   menuBar.add(turnCount);
   
   for (int y = 0; y < lengthCopy; y++) 
   {
       for (int x = 0; x < widthCopy; x++) 
       {

       	
       	String cordinates = "("+x+","+y+")";
       	String foodLabel = "Food: ";
       	String soilderLabel = "Soilder: ";
       	String queenLabel = "Queen: ";
       	String scoutLabel = "Scout: ";
       	String forgerLabel = "Forger: ";
       	String balaLabel = "Bala: ";
       	String pheromoneLabel = "Pheromone: ";
       		
       	
       	grid[x][y] = new JButton();
      
       	myGridNode[x][y] = new gridNode(x,y);
       	
       	panel.add(grid[x][y]);
       	
		int upperBound = 3;
		int lowerBound = 0;
		
		int[] foodArray = new int[]{0,100,200,400};
		int n = new Random().nextInt((upperBound-lowerBound+1))+lowerBound;
       	int foodCount = foodArray[n];     
       	
       	myGridNode[x][y].setFood(foodCount);               
         grid[x][y].setBackground(Color.cyan);  
         grid[x][y].setVisible(false);  
         
         if (x > 11 && x < 15)
         {
        	 if (y > 11 && y < 15)
        	 {
        		 grid[x][y].setVisible(true);
        		 myGridNode[x][y].setVisability(true);
        	 }
         }
         
           if (x == middleWidth && y == middleLength)
           {
        	   grid[x][y].setBackground(Color.gray);  
           }
           
        grid[x][y].setForeground(Color.BLACK); //to change text color you cant disable button
        
       	grid[x][y].setText( "<html>" 
       					+ cordinates + "<br>"
                           + foodLabel +  myGridNode[x][y].getFood() + "<br>"
                           + soilderLabel + myGridNode[x][y].getSoldierCount() +  "<br>"
                           + queenLabel + myGridNode[x][y].getQueenCount() + "<br>"
                           + scoutLabel + myGridNode[x][y].getScoutCount() + "<br>"
                           + forgerLabel + myGridNode[x][y].getForgerCount() + "<br>"
                           + balaLabel + myGridNode[x][y].getBalaCount() + "<br>"
                           + pheromoneLabel + myGridNode[x][y].getPheromoneCount() + "<br>"
                           + "</html>");
       
       	
       	
       } 
   }
    
}

public  void refresh(int x, int y) throws InterruptedException
{
	String cordinates = "("+x+","+y+")";
   	
	
	grid[x][y].setText( "<html>" 
				+ cordinates + "<br>"
               + foodLabel +  myGridNode[x][y].getFood() + "<br>"
               + soilderLabel + myGridNode[x][y].getSoldierCount() + "<br>"
               + queenLabel + myGridNode[x][y].getQueenCount() + "<br>"
               + scoutLabel + myGridNode[x][y].getScoutCount() + "<br>"
               + forgerLabel + myGridNode[x][y].getForgerCount() + "<br>"
               + balaLabel + myGridNode[x][y].getBalaCount() + "<br>"
               + pheromoneLabel + myGridNode[x][y].getPheromoneCount() + "<br>"
               + "</html>");
   
}


public void initalizeAntPopulation(int length, int width)  
{
	int middleWidth = width/2;
	int middleLength = length/2;
 
    //adding soldiers
    for (int i = 0; i < 10; i++)
    {
    	ID++;
    	soldierAnt mySoldier = new soldierAnt(ID);
    	mySoldier.setCordinates(middleWidth,middleLength);
    	myGridNode[middleWidth][middleLength].setSoldierCount(myGridNode[middleWidth][middleLength].getSoldierCount()+1);
    	antColony.add(mySoldier);
    }	    
 
    
    //adding Forgers
    for (int i = 0; i < 50; i++)
    {
    	ID++;
    	forgerAnt myForger = new forgerAnt(ID);
    	myForger.setCordinates(middleWidth,middleLength);
    	myGridNode[middleWidth][middleLength].setForgerCount(myGridNode[middleWidth][middleLength].getForgerCount()+1);
    	antColony.add(myForger);
    }

	
    //adding Scouts
    for (int i = 0; i < 4; i++)
    {
    	ID++;
    	scoutAnt myScout= new scoutAnt(ID);
    	myScout.setCordinates(middleWidth,middleLength);
    	myGridNode[middleWidth][middleLength].setScoutCount(myGridNode[middleWidth][middleLength].getScoutCount()+1);
    	antColony.add(myScout);
    }

    
    //setting food

	    myGridNode[middleWidth][middleLength].setFood(1000);
    
}
  

//driver running ant simulator
	public static void main (String[] args) throws InterruptedException 
	{

	    
	    
		//initializing variables
		int length = 27;//length of grid
		int width = 27;//width of grid
		int middleLength = length/2;
		int middleWidth = width/2;		
		int turnCounter = 0;
		int dayCounter = 0;
		probability myProbabilityClass = new probability();
		incrementOnGrid incrementTool = new incrementOnGrid();
		decrementOnGrid decrementTool = new decrementOnGrid();
		colonyView myColonyView = new colonyView();
		
		//creating 2 dimensional array of grid node objects
		myGridNode = new gridNode[width][length]; 	 
		
		
		// create new ant simulator instance and passing grid params
	    AntSimulatorGUI myAnt = new AntSimulatorGUI(length,width); 

		//initializing queen
	    
	    queenAnt myQueen = new queenAnt(middleWidth, middleLength, ID); 
	    incrementTool.gridNodeMovingInto(myQueen, myGridNode[myQueen.getXCordinate()][myQueen.getYCordinate()]);
	    //adding queen as first ant in colony
	    antColony.add(myQueen); 
	    
	    
	  
	    myAnt.initalizeAntPopulation(length, width);
	    myAnt.refresh(middleLength, middleWidth);
	    
	    
	    //TimeUnit.MINUTES.sleep(1);
		//begin while loop of program

		while (myQueen.getStatus().equals("alive"))
		{
				
			if (turnCounter == 10 )
			{
				dayCounter++;
				turnCounter = 1;		
			}
			
			dayCount.setText(Integer.toString(dayCounter));
			turnCount.setText(Integer.toString(turnCounter));
			
		    int n = myProbabilityClass.balaAntProbability(); //3% chance bala ants can hatch  	    
			if (n == 1)
			{
				ID++;
				balaAnt myBalaAnt = new balaAnt(ID);
				myBalaAnt.setCordinates(0, 0);
			    incrementTool.gridNodeMovingInto(myBalaAnt, myGridNode[0][0]);
				antColony.add(myBalaAnt);
				myAnt.refresh(0, 0);
			}
			
			
			if (turnCounter == 10)//hatch new ant every 10 turns
			{
				ID++;
				//hatching new ant
		    	ant newAnt = myQueen.hatch(ID);
		    	//adding new ant to colony
		    	antColony.add(newAnt);
		    	incrementTool.gridNodeMovingInto(newAnt, myGridNode[newAnt.getXCordinate()][newAnt.getYCordinate()]);		    	  	    
		        myAnt.refresh(2, 2);
			}
			
			
			//now each ant moves
			
	    	for (int i = 0; i < antColony.size(); i++) //moving all ants in ant colony
	    	{
	    		ant tempAnt = antColony.get(i); //selecting the ant
	    		
	    		if(i == 0)//queen eats each turn
	    		{
	    			int oldFood = myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()].getFood();
	    			if (oldFood == 0 )
	    			{
	    				tempAnt.setStatus("dead");
	    			}
	    			else
	    			{
	    				decrementTool.antEats(tempAnt, myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()]);
	    				myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
	    			}

	    			i++;//incrementing so queen doesn't move
	    			tempAnt = antColony.get(i);//selecting next ant for move
	    		}
	    		
	    		
	
	    		//scout actions
	    		if (tempAnt.getJob().contentEquals("Scout"))
	    		{
		    		decrementTool.gridNodeMovingOutOf(tempAnt, myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()]);
		    		myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
		    		tempAnt = tempAnt.move(tempAnt);
		    		incrementTool.gridNodeMovingInto(tempAnt, myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()]);
		    		myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
	    			
	    			if(myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()].getVisability() == false)
	    			{
	    				myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()].setVisability(true);
	    				grid[tempAnt.getXCordinate()][tempAnt.getYCordinate()].setVisible(true);
	    			}
	    		}
	    		
	    		//bala ant action	    		
	    		if (tempAnt.getJob().contentEquals("Bala"))
	    		{
		    		/*decrementTool.gridNodeMovingOutOf(tempAnt, myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()]);
		    		myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
		    		tempAnt = tempAnt.move(tempAnt);
		    		incrementTool.gridNodeMovingInto(tempAnt, myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()]);
		    		myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
*/
	    			balaAnt myBala = (balaAnt) tempAnt;
			        ant attackedAnt = myBala.balaAttackMode(tempAnt, antColony);
  
			        if (attackedAnt != null)
			        {
			        	
				        decrementTool.gridNodeMovingOutOf(attackedAnt, myGridNode[attackedAnt.getXCordinate()][attackedAnt.getYCordinate()]);	
				        attackedAnt.setStatus("dead");	
				        if (attackedAnt.getJob().contentEquals("Forger"))
				        {
				        	forgerAnt deadForger = (forgerAnt) attackedAnt;
				        	if (deadForger.getCarryingFoodFlag() == true)
				        	{
				        		gridNode attackLocation = myGridNode[deadForger.getXCordinate()][deadForger.getYCordinate()];
				        		attackLocation.setFood(attackLocation.getFood()+1);
				        	}
				        }
			        }
			        else
			        {
			        	decrementTool.gridNodeMovingOutOf(tempAnt, myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()]);
			        	tempAnt = tempAnt.move(tempAnt);
			        	incrementTool.gridNodeMovingInto(tempAnt, myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()]);
			    		myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
			        }
			        myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
			    }
	    		
	    		//soldier ant moves
	    		if (tempAnt.getJob().contentEquals("Soldier"))
	    		{
	    			soldierAnt mySoldier = new soldierAnt(tempAnt.getID());
	    			
	    			if (myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()].getBalaCount() > 0) //attack mode
	    			{
	    				ant attackedAnt = mySoldier.soldierAttackMode(tempAnt, antColony);
	 			       
		    			if (attackedAnt != null)
				        {
				        	
					        decrementTool.gridNodeMovingOutOf(attackedAnt, myGridNode[attackedAnt.getXCordinate()][attackedAnt.getYCordinate()]);	
					        attackedAnt.setStatus("dead");	
				        }
				        myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
	    				
	    			}
	    			else//scout mode
	    			{
	    				decrementTool.gridNodeMovingOutOf(tempAnt, myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()]);
    					myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
	    				
	    				gridNode newGridNode = mySoldier.soldierScoutMode(tempAnt, myGridNode);
	    				if (newGridNode == null)
	    				{
	    		    		tempAnt = tempAnt.move(tempAnt);
	    		    		incrementTool.gridNodeMovingInto(tempAnt, myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()]);
	    		    		myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
	    				}
	    				else
	    				{
	    					
	    		    		incrementTool.gridNodeMovingInto(tempAnt, newGridNode);
	    		    		myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
	    				}
	    			}
	    			
	    		}
	       
	    		if(tempAnt.getJob().contentEquals("Forger"))
	    		{
	    			gridNode middleNode = myGridNode[13][13];
	    			forgerAnt myForger = (forgerAnt) tempAnt;
   			
	    			if (myForger.getCarryingFoodFlag() == false)//enter forage mode
	    			{
	    				myForger.pushStack(myGridNode[myForger.getXCordinate()][myForger.getYCordinate()]);
	    				ArrayList<gridNode> gridsAdjacent = myColonyView.adjacentNodes(myGridNode, tempAnt);
	    				gridNode newGridNode = myForger.forageMode(tempAnt, gridsAdjacent,myGridNode[myForger.getXCordinate()][myForger.getYCordinate()]);

	    				if (newGridNode == null)
	    				{
	    		    		tempAnt = tempAnt.move(tempAnt);
	    		    		incrementTool.gridNodeMovingInto(tempAnt, myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()]);
	    		    		myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
	    		    		newGridNode = myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()];
	    		    		
	    				}
	    				else
	    				{
	    					
	    		    		incrementTool.gridNodeMovingInto(tempAnt, newGridNode);
	    		    		myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
	    		    		
	    				}
	    				
	    				if (newGridNode.getFood() > 0 && newGridNode != middleNode)
						{

								decrementTool.antEats(tempAnt, newGridNode);
								myForger.setCarryingFoodFlag(true);		

						}

	    			}
	    			else//return to nest mode
	    			{
	    				
	    				gridNode newGridNode = myForger.returnToNestMode(tempAnt, myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()], middleNode);
    		    		incrementTool.gridNodeMovingInto(tempAnt, newGridNode);
    		    		myAnt.refresh(tempAnt.getXCordinate(), tempAnt.getYCordinate());
	    				
	    			}

	    			
	    		}

					tempAnt.setTurnsAllowed(tempAnt.getTurnsAllowed()-1);
					
					if (tempAnt.getTurnsAllowed() == 0)
					{
						tempAnt.setStatus("dead");
					}

					if (tempAnt.getStatus().contentEquals("dead"))
					{
						decrementTool.gridNodeMovingOutOf(tempAnt, myGridNode[tempAnt.getXCordinate()][tempAnt.getYCordinate()]);
						antColony.remove(i);
					}
					

					
					
	    	//end for loop for moving	
	    	}
	
	    	
	    	for (int i = 0; i < antColony.size(); i++) //removing dead ants
	    	{
	    		if(antColony.get(i).getStatus().contentEquals("dead"))
	    		{
	    			antColony.remove(i);
	    		}
	    	}
			//end while	
	    	
	    	turnCounter++;
			   
	    	
	    	   for (int y = 0; y < length; y++) 
			   {
			       for (int x = 0; x < width; x++) 
			       {
			    	   if (myGridNode[x][y].getBalaCount()>0)
			    	   {
			    		   grid[x][y].setBackground(Color.red);//this is to show bala trail
			    	   }
			    	   if (turnCounter == 10)
			    	   {
			    		   myGridNode[x][y].setPheromoneCount(myGridNode[x][y].getPheromoneCount()/2);
			    	   }
			    	   
			    	   myAnt.refresh(x, y);
			       }
			   }
	    	   TimeUnit.SECONDS.sleep(1);
	  }
						
	System.out.println(antColony.size());		
			
	    
   }


}		
	



