

public class incrementOnGrid
{

	public void gridNodeMovingInto(ant myAnt, gridNode antsGridNode)
	{
		

		String antJob = myAnt.getJob();
		
		
		switch(antJob)
		{
		
		   case "Forger":
			   antsGridNode.setForgerCount(antsGridNode.getForgerCount() + 1);
			   myAnt.setCordinates(antsGridNode.getX(), antsGridNode.getY());
			   break;
			   
		   case "Soldier":
			   antsGridNode.setSoldierCount(antsGridNode.getSoldierCount() + 1);
			   break;
			   
		   case "Scout":
			   antsGridNode.setScoutCount(antsGridNode.getScoutCount() + 1);
			   break;
			   
		   case "Bala":
			   antsGridNode.setBalaCount(antsGridNode.getBalaCount() + 1);
			   myAnt.setCordinates(antsGridNode.getX(), antsGridNode.getY());
			   break;
			   			   
		   case "Queen":
			   antsGridNode.setQueenCount(antsGridNode.getQueenCount() + 1);
			   break;

		}
		
	}
	

	
}
