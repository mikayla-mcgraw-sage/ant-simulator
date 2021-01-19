
import java.util.ArrayList;
import java.util.Random;

public class queenAnt extends ant
{
    public queenAnt(int width, int length, int idEntered)
    {
       super.setID(idEntered);
       super.setJob("Queen");
       super.setCordinates(width,length);
       super.setTurnsAllowed(73000);
    }
    
    public ant hatch(int IdEntered)
    {
        ant myNewAnt = null;
    
        int lowerBound = 0;
        int upperBound = 2;
        ArrayList <String> jobList = new ArrayList<String>();
        jobList.add("Forger");
        jobList.add("Scout");
        jobList.add("Soldier");
        
        int n = new Random().nextInt((upperBound-lowerBound+1))+lowerBound;

        
        String randomJob = jobList.get(n);
        
        switch(randomJob)
        {
            case"Forger":
            forgerAnt newForgerAnt = new forgerAnt(IdEntered);
            myNewAnt = newForgerAnt;            
            break;
            
            
            case"Scout":
            scoutAnt newScoutAnt = new scoutAnt(IdEntered);
            myNewAnt = newScoutAnt;
            break;
            
            
            case"Soldier":
            soldierAnt newSoldierAnt = new soldierAnt(IdEntered);
            myNewAnt = newSoldierAnt;
            break;
        }
       
        myNewAnt.setCordinates(2, 2);
       
        return myNewAnt;
    }
}
