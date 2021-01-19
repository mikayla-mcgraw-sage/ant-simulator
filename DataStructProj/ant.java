import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

public class ant 
{
	private int age = 0;
	private int cordinateX = 0;
	private int cordinateY = 0;
    private String job = null;
    private int ID = 0;
    private String status = null;
    private long turnsAllowed = 0;
    
    public ant()
    {
    	
    	
    	setStatus("alive");
    }
    
    public void setTurnsAllowed(long turns)
    {
    	turnsAllowed = turns;
    }
    
    public long getTurnsAllowed()
    {
    	return turnsAllowed;
    }
    
    public void setStatus(String statusTemp)
    {
    	status = statusTemp;
    }
    
    public String getStatus()
    {
    	return status;
    }
    
    public void setCordinates(int x, int y)
    {
    	cordinateX = x;
    	cordinateY = y;
    }
    
    public int getXCordinate()
    {
    	return cordinateX;
    }
    
    public int getYCordinate()
    {
    	return cordinateY;
    }
    public void setAge(ant antAging, int turnsAliveFor)
    {
    	
    	age = turnsAliveFor/10;
    	
    	if (antAging.getJob()=="Queen" && age == 73000)
    	{
    		antAging.setStatus("dead");
    	}
    	else 
    	{
    		if (age == 3650)
    		{
        		antAging.setStatus("dead");
    		}
    	}
    
    }
    
    public int getAge()
    {
        return age;
    }

    public void setJob(String jobEntered)
    {
        job = jobEntered;
    }
    
    public String getJob()
    {
        return job;
    }
    
    public int getID()
    {
        return ID;
    }
    
    public void setID(int id)
    {
        ID = id;
    }
    
    public ant move(ant myAnt)
    {
        int lowerBound = 0;
        int upperBound = 2;
        int newX = 0;
        int newY=0;
        int indexX=-1;
        int indexY=-1;
        boolean flag = true;
    	int currentX = myAnt.getXCordinate();
    	int currentY = myAnt.getYCordinate();
    	
    	ArrayList <Integer> xCordinateOptions = new ArrayList<Integer>();
    	xCordinateOptions.add(currentX - 1);
    	xCordinateOptions.add(currentX);
    	xCordinateOptions.add(currentX+1);
    	
    	ArrayList <Integer> yCordinateOptions = new ArrayList<Integer>();
    	yCordinateOptions.add(currentY - 1);
    	yCordinateOptions.add(currentY);
    	yCordinateOptions.add(currentY + 1);
    	
    	while (flag)
    	{
        	 indexX = new Random().nextInt((upperBound-lowerBound+1))+lowerBound;
        	 indexY = new Random().nextInt((upperBound-lowerBound+1))+lowerBound;
    		
         	 newX = xCordinateOptions.get(indexX);
        	 newY = yCordinateOptions.get(indexY);
        	 
        	
        	 
        	 if (newX>= 0 && newX <27)
        	{
        		if(newY >= 0 && newY<27)
        		{
        			flag= false;
        			
        			if(currentX == newX && currentY == newY) //making sure ant actually moves
        			{
        				flag = true;
        			}        			
        			
        		}
        	}
    	}
	
    	myAnt.setCordinates(newX, newY);
    	
    	return myAnt;
    
    }

    public int eat(int foodLevelCurrent)
    {
   
    	int foodLeft = foodLevelCurrent - 1;
    	return foodLeft;
    }
}
