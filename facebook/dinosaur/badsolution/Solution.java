import java.util.*;
import java.io.*;


class Solution{
	public void printRank() throws IOException{
		HashMap<String,Dinosaur> map = new HashMap<>();

		String curPath = new File("").getAbsolutePath();
		List<List<String>> lines = readInLines(curPath+"/battership.csv");
		
		for(List<String> line: lines){
			
			String name = line.get(0);
			//TODO: exception
			int strideLength = Integer.parseInt(line.get(1));
			boolean isStanding = line.get(2).equals("a");
			
			if(isStanding){
				Dinosaur newDinosaur = new Dinosaur(name, strideLength);
				map.put(name,newDinosaur);
			}
		}

		DinosaurComparator comparator = new DinosaurComparator();
		PriorityQueue<Dinosaur> queue = new PriorityQueue(comparator);

		lines = readInLines(curPath+"/Habit.csv");

		for(List<String> line: lines){
			String name = line.get(0);
			int legLength = Integer.parseInt(line.get(1));			
			Dinosaur dinosaur = map.get(name);
			if(dinosaur != null){

				dinosaur.legLength = legLength;
				queue.add(dinosaur);
			}
		}

		//output
		int rank = 0;
		while(!queue.isEmpty()){
			Dinosaur dinosaur = queue.poll();
			System.out.printf("rank %d : %s speed = %d \n",rank,dinosaur.name,dinosaur.getSpeed());
			rank++;
		}
	}

	public static void main(String[] args) throws IOException{
		Solution s = new Solution();
		s.printRank();
	}

	class DinosaurComparator implements Comparator<Dinosaur>{

		@Override
		public int compare(Dinosaur d1, Dinosaur d2){
			return d2.getSpeed() - d1.getSpeed();
		}
	}

	class Dinosaur{
		String name;
		int legLength;
		int strideLength;

		public 	Dinosaur(String name, int strideLength){
			this.name = name;
			this.strideLength = strideLength;
		}

		public int getSpeed(){
			return strideLength*legLength;
		}

	}

	//TODO: should throw IO Exception here
	//TODO: add buffer for big file
	private static void readFile(String filename, StringBuilder strBuilder) throws IOException{
	    File file = new File(filename); //for ex foo.txt
	    FileReader reader = null;
	    try{
	        reader = new FileReader(file);
	        char[] chars = new char[(int) file.length()];
	        reader.read(chars);
	        strBuilder.append(chars);
	        reader.close();
	   } finally {
	        if(reader !=null){
	        	reader.close();
	        }
	    }
	}
	
	public static List<List<String>> readInLines(String filename) throws IOException{
		List<List<String>> synonymsList= new LinkedList<List<String>>();
		StringBuilder strBuilder = new StringBuilder();
		readFile(filename,strBuilder);	
		String[] lines = strBuilder.toString().split(System.getProperty("line.separator"));
		
		for(int i=1; i<lines.length; i++){
			String line = lines[i];
			if(line.trim().length()!=0){
				String[] words = line.split(",");
				List<String> wordsList = new LinkedList<String>();
				
				for(String word:words){
					wordsList.add(word.trim().toLowerCase());
				}
				
				synonymsList.add(wordsList);
			}
		}
		
		return synonymsList;
	}
	
}	