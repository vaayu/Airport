package algoritm_ovning1;

public class Puzzle {

	// Data fields
	private int nrOfSolutions = 0; 
	private int[][] matrix = new int[5][5];
	
	// Constructors 
	public Puzzle(int row, int col){
		this.matrix[row][col] = -1; 
	}
	
	
	
	// Methods 
	private void solve(int arr[][], int row, int col, int nb){
		
		// 8 bitar lagda ?
		if(nb == 8){
			nrOfSolutions++;
			printSolution(arr);
			return;
		}
		
		/*if(isSolved()){
			nrOfSolutions++;
			printSolution(arr);
			return;
		}
		*/
		
		if(row > 3){	
			solve(arr, 0, col + 1, nb);
			//return; 
		}
		
		if(col <= 3){
			//solve();
			return; 
		}
		
		if(row == 3 && col == 3){
			return;
		}
		
		/* Kolla om 1, dvs 	****	kan läggas
		 * 					*
		 * 					*	
		 * */
		if(fitPiece(arr, row, col) && fitPiece(arr, row+1, col) && fitPiece(arr, row, col+1)){
			putPiece(arr, row, col, 1);
			putPiece(arr, row+1, col, 1);
			putPiece(arr, row, col+1, 1);
			
			solve(arr, row, col + 1, nb + 1);
		}
		
		/* Kolla om 2, dvs	*		kan läggas in
		 * 					*
		 * 					****
		 * */
		if(fitPiece(arr, row, col) && fitPiece(arr, row+1, col) && fitPiece(arr, row+1, col+1) ){
			putPiece(arr, row, col, 2);
			putPiece(arr, row+1, col, 2);
			putPiece(arr, row+1, col+1, 2);
			
			solve(arr, row, col + 1, nb + 1);
		}
		
	}
	
	// Wrapper method
	public int solve(){
		solve(matrix, 0, 0, 0);
		return nrOfSolutions;
	}
	
	// Put the piecies in the puzzle
	public void putPiece(int arr[][], int row, int col, int type){
		
		switch(type){
			case 1:	arr[row][col] = 1; 
			break; 
			case 2:	arr[row][col] = 2; 
			break; 
			case 3: arr[row][col] =	3; 
			break; 
			case 4: arr[row][col] = 4;
			break; 
			default: arr[row][col] = 0;
		}
		
		
		/*	Different types: 
		 * 
		 * 	1: 	****
		 * 		*
		 * 		*
		 * 
		 * 	2:	*
		 * 		*
		 * 		****
		 * 
		 * 	3:	****
		 *		   *
		 * 		   *
		 * 
		 * 	4:	   *
		 * 		   *
		 * 		****
		 * */
	}
	
	// Check if there is space available for a piece 
	public boolean fitPiece(int arr[][], int row, int col){
		
		if(arr[row][col] > 0)	return false;
		
		return true; 
	}
	
	public void removePiece(int arr[][], int row, int col){
		
		arr[row][col] = 0; 
	}
	
	// Print the solved puzzle
	public void printSolution(int arr[][]){
		
		for(int row = 0; row < arr.length; ++row){
			for(int col = 0; col < arr.length; ++col){
				System.out.printf("%d ", arr[row][col]);
			}
			System.out.println();
		}
		
	}
	
	// Check if the puzzle is solved
	public boolean isSolved(){
		for(int i=0; i < 5; ++i)
			for(int j=0; j < 5; ++j)
				if(matrix[i][j] <= 0)
					return false;
		return true;
	}
}


