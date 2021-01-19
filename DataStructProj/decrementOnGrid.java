

public class decrementOnGrid
{

	public void gridNodeMovingOutOf(ant myAnt, gridNode antsGridNode)
	{
		
		int x = myAnt.getXCordinate();
		int y = myAnt.getYCordinate();
		String antJob = myAnt.getJob();
		
		
		switch(antJob)
		{
		
		   case "Forger":		   
			   antsGridNode.setForgerCount(antsGridNode.getForgerCount() - 1);
			   break;
			   
		   case "Soldier":
			   antsGridNode.setSoldierCount(antsGridNode.getSoldierCount() - 1);
			   break;
			   
		   case "Scout":
			   antsGridNode.setScoutCount(antsGridNode.getScoutCount() - 1);
			   break;
			   
		   case "Bala":
			   antsGridNode.setBalaCount(antsGridNode.getBalaCount() - 1);
			   break;
			   			   
		   case "Queen":
			   antsGridNode.setQueenCount(antsGridNode.getQueenCount() - 1);
			   break;

		}
		
	}
	
	
	public void antEats(ant myAnt, gridNode antsGridSquare)
	{
		
		antsGridSquare.setFood(antsGridSquare.getFood()-1);
		
		
	}
	
	
}
