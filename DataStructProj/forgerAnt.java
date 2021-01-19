
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class forgerAnt extends ant
{
	private boolean carryingFoodFlag = false;
	private Stack<gridNode> gridNodeStack = new Stack<gridNode>();
	
	public forgerAnt(int IdEntered)
	{
		super.setJob("Forger");
		super.setTurnsAllowed(3650);
		super.setID(IdEntered);
	}
	
	public void setCarryingFoodFlag(boolean answer)
	{
		carryingFoodFlag = answer;
	}
	
	public boolean getCarryingFoodFlag()
	{
		return carryingFoodFlag;
	}
	
	public void setStack(Stack<gridNode> tempStack)
	{
		gridNodeStack = tempStack;
	}

	public void pushStack(gridNode currentGridNode)
	{
		gridNodeStack.push(currentGridNode);
	}
	
	public Stack<gridNode> getStack()
	{
		return gridNodeStack;
	}
	
	public gridNode forageMode(ant currentForger, ArrayList <gridNode> gridsAdjacent, gridNode currentGridNode)
	{
		decrementOnGrid decrementAbility = new decrementOnGrid();
	
		decrementAbility.gridNodeMovingOutOf(currentForger, currentGridNode);
		
		ArrayList <gridNode> gridsContainingPheromone = new ArrayList <gridNode>();
	
		for (int i = 0; i < gridsAdjacent.size(); i++)
		{
			if(gridsAdjacent.get(i).getPheromoneCount() > 0 && gridsAdjacent.get(i).getFood()>0)
			{
				gridsContainingPheromone.add(gridsAdjacent.get(i));
			}
		}
		
		
		if (gridsContainingPheromone.size() == 0)
		{
			 return null; //no grids adjacent have pheromone levels
		}
		else if (gridsContainingPheromone.size() == 1)
		{
			//currentForger.setCordinates(gridsContainingPheromone.get(0).getX(), gridsContainingPheromone.get(0).getY());
			return gridsContainingPheromone.get(0); //returning only grid with pheromone levels
			
			
		}
		else
		{
			 Collections.sort(gridsContainingPheromone, new Comparator<gridNode>() {
			        @Override public int compare(gridNode grid1, gridNode grid2) {
			            return grid1.getPheromoneCount() - grid2.getPheromoneCount(); // Ascending
			        }

			    });
			 
			 return gridsContainingPheromone.get(gridsContainingPheromone.size()-1); //returning highest contents of pheromone
		}
 
		
	}
	
	public gridNode returnToNestMode(ant currentForger, gridNode currentGridNode, gridNode middleNode)
	{
		decrementOnGrid decrementAbility = new decrementOnGrid();
		decrementAbility.gridNodeMovingOutOf(currentForger, currentGridNode);

		
		int currentPheromone = currentGridNode.getPheromoneCount();
	
		if (currentPheromone < 1000 && currentGridNode != middleNode)
		{
			int newPheromone = currentPheromone+10;
			currentGridNode.setPheromoneCount(newPheromone);
		}
		
		forgerAnt myForger = (forgerAnt) currentForger;
		Stack<gridNode> forgerStack = myForger.getStack();
		gridNode backTrackNode = forgerStack.pop();	
		//currentForger.setCordinates(backTrackNode.getX(), backTrackNode.getY());
		myForger.setStack(forgerStack);		
		if(myForger.getStack().size() == 0)
		{
			myForger.setCarryingFoodFlag(false);
			int newFoodLevel = backTrackNode.getFood()+1;
			backTrackNode.setFood(newFoodLevel);
		}
		
		return backTrackNode;
		
	}
	
	
}
