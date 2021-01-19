

import java.util.ArrayList;
import java.util.Random;

public class balaAnt extends ant
{
	probability myProbability = new probability();

	public balaAnt(int IdEntered)
	{
		super.setJob("Bala");
		super.setTurnsAllowed(3650);
		super.setID(IdEntered);
	}
	
	
	public ant balaAttackMode(ant currentBala, ArrayList<ant> antColonyCopy)
	{
		int x = currentBala.getXCordinate();
		int y = currentBala.getYCordinate();
		
		ArrayList<ant> filteredAntList = new ArrayList<ant>();
		
		for(int i = 0; i < antColonyCopy.size(); i++)
		{
			if (antColonyCopy.get(i).getJob()!= "Bala")
			{
				if(currentBala.getXCordinate() == antColonyCopy.get(i).getXCordinate()) 
				{
					if(currentBala.getYCordinate() == antColonyCopy.get(i).getYCordinate())
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

