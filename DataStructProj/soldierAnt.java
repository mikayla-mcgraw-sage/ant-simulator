

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class soldierAnt extends ant
{
	probability myProbability = new probability();
	public soldierAnt(int IdEntered)
	{
		super.setJob("Soldier");
		super.setTurnsAllowed(3650);
		super.setID(IdEntered);
	}
	
	public gridNode soldierScoutMode(ant currentSoldier, gridNode[][] gridArray)
	{
		ArrayList<gridNode> gridNodeAdjacent = new ArrayList<gridNode>();
		
		int currentX = currentSoldier.getXCordinate();
		int currentY = currentSoldier.getYCordinate();
		
		for (int y = 0; y < 27; y++) //saving all adjacent squares to arrayList to find out who has the most bala ants
		{
			for (int x = 0; x < 27; x++)
			{
				if (y> (currentY-2) && y < (currentY+2))
				{
					if(x > currentX-2 && x < (currentX+2))
					{	
							if (gridArray[x][y].getVisability() == true)
							{
								if(gridArray[x][y].getBalaCount()>0)
								{
									gridNodeAdjacent.add(gridArray[x][y]);
								}
								
							}													
					}
				}
			}
		}
	
		
		if(gridNodeAdjacent.size() == 0)
		{
			
			return null;
		}
		else 
		{
			if (gridNodeAdjacent.size() == 1)
			{
				currentSoldier.setCordinates(gridNodeAdjacent.get(0).getX(), gridNodeAdjacent.get(0).getY());
				return gridNodeAdjacent.get(0);
				
			}
			
			else
			{
		        int lowerBound = 0;
		        int upperBound = gridNodeAdjacent.size()-1;
		        
		        int n = new Random().nextInt((upperBound-lowerBound+1))+lowerBound;
				currentSoldier.setCordinates(gridNodeAdjacent.get(n).getX(), gridNodeAdjacent.get(n).getY());

		        return gridNodeAdjacent.get(n);
		        
			}
		}
		
	}
	
	
	public ant soldierAttackMode(ant currentSoldier, ArrayList<ant> antColonyCopy)
	{
		int x = currentSoldier.getXCordinate();
		int y = currentSoldier.getYCordinate();
		
		ArrayList<ant> filteredAntList = new ArrayList<ant>();
		
		for(int i = 0; i < antColonyCopy.size(); i++)
		{
			if (antColonyCopy.get(i).getJob()== "Bala")
			{
				if(currentSoldier.getXCordinate() == antColonyCopy.get(i).getXCordinate()) 
				{
					if(currentSoldier.getYCordinate() == antColonyCopy.get(i).getYCordinate())
					{
						filteredAntList.add(antColonyCopy.get(i));
					}
				}
			}
		}
		

        if(filteredAntList.size() == 0)
        {
        	return null;
        }
        else
        {
        	String deathResult =  myProbability.deathProbability();
        	
        	if (deathResult == "no")
        	{
        		return null;
        	}
        	
        	if (filteredAntList.size() == 1)
        	{
        		return filteredAntList.get(0);
        	}
        	else
        	{
                int upperBound = filteredAntList.size()-1;
                int lowerBound = 0;
                
                int n = new Random().nextInt((upperBound-lowerBound+1))+lowerBound;

                
                return filteredAntList.get(n);
        	}
        			
        	
        }
		
	}
}
