import java.io.*;
import java.util.*;

class Solution{
	
	public static void main(String[] args) throws IOException{
		Solution s = new Solution();
		s.printRank();		
	}

	public void printRank() throws IOException{
			String curPath = new File("").getAbsolutePath();
			Scanner scanner = new Scanner(new File(curPath+"/battership.csv"));
			
			HashMap<String, Dinosaur> map = new HashMap<>(); 
			PriorityQueue<Dinosaur> queue = new PriorityQueue<>(new DinosaurComparator());

			try{
				//skip 1st line
				scanner.nextLine();
				while(scanner.hasNextLine()){
					String[] attrs = scanner.nextLine().split(",");
					if(attrs[2].equals("A")){
						Dinosaur dinosaur = new Dinosaur(attrs[0].trim(), Integer.valueOf(attrs[1]) );
						map.put(attrs[0], dinosaur);
					}				
				}

				
				scanner = new Scanner(new File(curPath+"/Habit.csv"));
				scanner.nextLine();
				while(scanner.hasNextLine()){
					String[] attrs = scanner.nextLine().split(",");
					Dinosaur dinosaur = map.get(attrs[0].trim());
					if(dinosaur != null){
						dinosaur.legLength = Integer.parseInt(attrs[1]);
						queue.offer(dinosaur);
					}
				}
			}finally{
				if(scanner !=null){
					scanner.close();
				}
			}

			int rank = 1;
			while(!queue.isEmpty()){
				Dinosaur dinosaur = queue.poll();
				System.out.printf(" %d  %s  %d\n", rank++, dinosaur.name, dinosaur.getSpeed());
			}

	}

	class Dinosaur{
		String name;
		int strideLength;
		int legLength;

		public Dinosaur(String myName, int mystrideLength){
			name = myName;
			strideLength = mystrideLength;
		}

		public int getSpeed(){
			return strideLength * legLength;
		}

		public DinosaurComparator comparator(){
			return new DinosaurComparator();
		}


	}

	class DinosaurComparator implements Comparator<Dinosaur>{

			@Override
			public int compare(Dinosaur d1, Dinosaur d2){
				return d2.getSpeed() - d1.getSpeed();
			}

	}
}