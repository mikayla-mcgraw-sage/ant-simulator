

import java.util.ArrayList;
import java.util.Random;

public class gridNode 
{
	private int xCoordinate = 0;
	private int yCoordinate = 0;
	private int queenCount = 0;
	private int forgerCount = 0;
	private int scoutCount = 0;
	private int soldierCount=0;
	private int foodCount = 0;
	private int balaCount = 0;
	private int pheromoneCount = 0;
	private boolean visible = false;
	public gridNode(int x, int y)
	{
		xCoordinate = x;
		yCoordinate = y;
	}
	
	public void setFood(int foodSetter)
	{

		
		foodCount = foodSetter;
		
	}
	
	public void setVisability(boolean setVisible)
	{
		visible = setVisible;
	}
	
	public boolean getVisability()
	{
		return visible;
	}
	public int getFood()
	{
		return foodCount;
	}
	
	public int getX()
	{
		return xCoordinate;
	}
	
	public int getY()
	{
		return yCoordinate;
	}
	
	public void setQueenCount(int queenBee)
	{
		queenCount = queenBee;
	}
	
	
	public int getQueenCount()
	{
		setQueenCount(queenCount);
		return queenCount;
	}
	
	public void setForgerCount(int count)
	{
		
		forgerCount = count;
	}
	
	public int getForgerCount()
	{
		
		return forgerCount;
	}
	
	public void setScoutCount(int count)
	{
		scoutCount = count;
	}
	
	public int getScoutCount()
	{
		return scoutCount;
	}
	
	public void setSoldierCount(int count)
	{
		
		soldierCount = count;
	}
	
	public int getSoldierCount()
	{
		
		return soldierCount;
	}
	
	public void setBalaCount(int count)
	{
		balaCount = count;
	}
	
	public int getBalaCount()
	{
		return balaCount;
	}
	
	public void setPheromoneCount(int pheromoneLevel)
	{
		pheromoneCount = pheromoneLevel;
	}
	
	public int getPheromoneCount()
	{
		return pheromoneCount;
	}
}
