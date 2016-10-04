import java.io.*;
import java.util.*;

class Solution{
	
	public static void main(String[] args) throws IOException{
		Solution s = new Solution();
		s.printRank();		
	}

	public void printRank() throws IOException{
			String curPath = new File("").getAbsolutePath();
			
			HashMap<String, Integer> strideLenMap = new HashMap<>(); 
			PriorityQueue<Dinosaur> queue = new PriorityQueue<>(new DinosaurComparator());
			Scanner scanner = null;
			try{
				//skip 1st line
				scanner = new Scanner(new File(curPath+"/battership.csv"));			
				scanner.nextLine();
				while(scanner.hasNextLine()){
					String[] attrs = scanner.nextLine().split(",");
					if(attrs[2].equals("A")){
						String name = attrs[0].trim();
						int legLen = Integer.valueOf(attrs[1]);
						//System.out.println(name);

						strideLenMap.put(name, legLen);
					}				
				}

				
				scanner = new Scanner(new File(curPath+"/Habit.csv"));
				scanner.nextLine();
				
				while(scanner.hasNextLine()){
					String[] attrs = scanner.nextLine().split(",");
					String name = attrs[0].trim();
					if(strideLenMap.containsKey(name)){
						int strideLen = strideLenMap.get(name);
						int legLen = Integer.parseInt(attrs[1]);
						Dinosaur dinosaur = new Dinosaur(name, strideLen, legLen);							
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

		public Dinosaur(String name, int strideLength, int legLength){
			this.name = name;
			this.strideLength = strideLength;
			this.legLength = legLength;
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