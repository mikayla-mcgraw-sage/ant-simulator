
import java.util.ArrayList;

public class colonyView 
{
	
	public ArrayList<gridNode> adjacentNodes(gridNode[][] gridArray, ant currentAnt)
	{
		int min = 0;
		int max = 26;
		
		ArrayList<gridNode> gridNodeAdjacent = new ArrayList<gridNode>();
		ArrayList<gridNode> filteredList = new ArrayList<gridNode>();
 		
		gridNodeAdjacent.add(gridArray[currentAnt.getXCordinate()][currentAnt.getYCordinate()-1]);
		gridNodeAdjacent.add(gridArray[currentAnt.getXCordinate()][currentAnt.getYCordinate()+1]);
		gridNodeAdjacent.add(gridArray[currentAnt.getXCordinate()+1][currentAnt.getYCordinate()-1]);
		gridNodeAdjacent.add(gridArray[currentAnt.getXCordinate()+1][currentAnt.getYCordinate()+1]);
		gridNodeAdjacent.add(gridArray[currentAnt.getXCordinate()+1][currentAnt.getYCordinate()]);
		gridNodeAdjacent.add(gridArray[currentAnt.getXCordinate()-1][currentAnt.getYCordinate()-1]);
		gridNodeAdjacent.add(gridArray[currentAnt.getXCordinate()-1][currentAnt.getYCordinate()+1]);
		gridNodeAdjacent.add(gridArray[currentAnt.getXCordinate()-1][currentAnt.getYCordinate()]);
	
		for(int i = 0; i < gridNodeAdjacent.size(); i++)
		{
			if (gridNodeAdjacent.get(i).getX() >= min && gridNodeAdjacent.get(i).getX() <= max)
			{
				if(gridNodeAdjacent.get(i).getY() >= min && gridNodeAdjacent.get(i).getY() <= max)
				{
					if (gridNodeAdjacent.get(i).getVisability() == true)
					{
						filteredList.add(gridNodeAdjacent.get(i));
					}
					
				}
			}

		}
	
		return filteredList;
	}

}
