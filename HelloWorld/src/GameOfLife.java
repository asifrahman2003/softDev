
public class GameOfLife {
	public int neighborCount(int row, int col) {
		return 0;
	GameOfLife society = new GameOfLife(6, 5)
		society.growCellAt(0, 0);    
			society.growCellAt(0, 2);   
			society.growCellAt(0, 4);     
			society.growCellAt(5, 2);     
			society.growCellAt(5, 3); 
			society.growCellAt(5, 4);  
			// Write the correct integer to the left of the comma ',' 
			assertEquals( _4_ , society.neighborCount(0, 0));     
			assertEquals( _2_ , society.neighborCount(0, 2));    
			assertEquals( _3_ , society.neighborCount(0, 4));     
			assertEquals( _4_, society.neighborCount(5, 2));     
			assertEquals( _4_ , society.neighborCount(5, 3));     
			assertEquals( _3_ , society.neighborCount(5, 4)); 
		}

}
