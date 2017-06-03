package matrix;

import java.util.ArrayList;
import java.util.List;

public class questions {

	/* Given a boolean matrix, update it so that if any 
	 * cell is true, all the rows in that cell are true
	 */
	
	/*
	 * 
	 */
	
		public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
			 ArrayList<Integer> result = new ArrayList<Integer>();
			 
			 int row = a.size();
			 int col = a.get(0).size();
		
			 int R = col - 1;
			 int L = 0;
			 int B = row - 1; 
			 int T = 0;
			 
			 int i = 0; 
			 int mode = 0;
			 
			 while(T<=B && L<=R){
			      if(mode == 0){
			          for(int j = L; j <=R; j++){
	    		         result.add(i, a.get(T).get(j));
	    		         i++;
	    		      }
	    		      T++;
	    		      mode++;
			      }
			      else if(mode == 1){
			          for(int j = T; j <=B; j++){
	    		         result.add(i, a.get(j).get(R));
	    		         i++;
	    		      }
	    		      R--;
	    		      mode++;
	    		      
			      }
			      else if(mode == 2){
			          for(int j = R; j >=L; j--){
	    		         result.add(i, a.get(B).get(j));
	    		         i++;
	    		      }
	    		      B--;
	    		      mode++;
			      }
			      else if(mode == 3){
			          for(int j = B; j >= T; j--){
	    		         result.add(i, a.get(j).get(L));
	    		         i++;
	    		      }
	    		      L++;
	    		      mode=0;
			      }
			 }
			 // Populate result;
			 return result;
		}
		
		
			public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
			    ArrayList <ArrayList<Integer>> array = new ArrayList <ArrayList<Integer>>();
			    ArrayList<Integer> subArray = new ArrayList<Integer>();
			    ArrayList<Integer> newSubArray1;
			    ArrayList<Integer> newSubArray2;
			    
			    int num = a;
			    int meadle = a - 1;
			    int size =  2*a-1;
			    
			    for(int i = 0; i < size; i++){
			        subArray.add(i, Math.abs(num));
			        num--;
			        if(num==0)
			            num = -2;
			    }
			    
			    array.add(meadle,subArray);
			    
			    int j = 1;
			    int min = 2;
			    while(meadle - j >= 0){
			        newSubArray1 = new ArrayList<Integer>();
			        newSubArray2 = new ArrayList<Integer>();
			        for(int i = 0; i < size; i++){
			            if(subArray.get(i) < min){
			                newSubArray1.add(i, subArray.get(i)+1);
			                newSubArray2.add(i, subArray.get(i)+1);
			            } 
			            else {
			                newSubArray1.add(i, subArray.get(i));
			                newSubArray2.add(i, subArray.get(i));
			            }
			        }
			        array.add(meadle-j, newSubArray1);
			        array.add(meadle+j, newSubArray2);
			        subArray = newSubArray1;
			        j++;
			        min++;
			    }
			    return array;
			}

	public static void main(String[] args) {
		int matrix [][] = {{1, 2, 3}, {6, 5, 4}, {7, 8, 9}};
		//System.out.println(questions.largestOnesSubarray(matrix));
		//questions.spiralOrder(matrix);
	}

}
