

import java.util.ArrayList;
import java.util.Random;

public class probability 
{

	public int balaAntProbability()
	{
		int upperBound = 99;
		int lowerBound = 0;
		
        ArrayList <Integer> balaChance = new ArrayList<Integer>();
        
        for (int i = 0; i <= 99; i++)
        {
        	if (i< 97) 
        	{
        		balaChance.add(0);
        	}
        	else
        	{
        		balaChance.add(1);
        	}
        }
        
        int n = new Random().nextInt((upperBound-lowerBound+1))+lowerBound;

        
        int balaProbability = balaChance.get(n);
        
        return balaProbability;
	}
	
	public String deathProbability()
	{
		int upperBound = 1;
		int lowerBound = 0;
		
		String[]death;
		
		death = new String[]{"yes","no"};
		
		int n = new Random().nextInt((upperBound-lowerBound+1))+lowerBound;
		
		String result = death[n];
		
		return result;
		
	}
	
	
	
}
