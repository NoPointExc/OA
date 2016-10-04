
import java.util.*;
import java.io.*;

class Solution{

    public List<String> getRank(String text){
	List<String> rankList = new LinkedList<>();
	Ranker ranker = new Ranker();

	if(text == null){
	    return rankList;
	}

	String[] words = text.split(" ");

	for(String word : words){
	    ranker.add(word);
	}

	rankList = ranker.getRankList();

	return rankList;
    }

    public List<String> getRankFromFile(String fileName) throws IOException{
	//System.out.println(fileName);
	List<String> rankList = new LinkedList<>();
	Ranker ranker = new Ranker();
	if(fileName == null){
	    return rankList;
	}

	String currentPath = new File("").getAbsolutePath();
	File textFile = new File(currentPath + "/" + fileName);
	Scanner scanner = new Scanner(textFile);
	//System.out.println(scanner.hasNext());
	while(scanner.hasNextLine()){
	    String line = scanner.nextLine();
	    String[] words = line.split(" ");
	    for(String word : words){
		ranker.add(word); 
	    }
	}

	rankList = ranker.getRankList();
	return rankList;
    }

    class Ranker{
	WordComparator comparator;
	PriorityQueue<String> rankQueue;

	// comparator input here
	public Ranker(){
	    comparator = new WordComparator();
	    rankQueue = new PriorityQueue<>(comparator);
	}

	public void add(String word){  
	    if(word!=null){          
		comparator.putWord(word);
		rankQueue.remove(word);
		rankQueue.offer(word);
	    }
	}

	public List<String> getRankList(){
	    List<String> rankList = new LinkedList<>();
	    int num = 0;
	    while(!rankQueue.isEmpty() && num < 100){
		rankList.add(rankQueue.poll());
		num++;
	    }

	    return rankList;
	}
    }

    class WordComparator implements Comparator<String>{
	HashMap<String, Integer> map;

	public WordComparator(){
	    map = new HashMap<>();
	}

	@Override
	    public int compare(String word1, String word2){
		int count1 = word1 == null? 0:map.get(word1);
		int count2 = word2 == null? 0:map.get(word2);  
		return count2 - count1;
	    }

	public int putWord(String word){
	    int count = -1;      
	    if(word != null){ 
		if(map.containsKey(word)){
		    count =  map.get(word) + 1;
		    map.put(word, count);
		}else{
		    count = 1;
		    map.put(word, count);
		}       
	    }   
	    return count;
	}

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	try{
	    List<String> rank = s.getRankFromFile("text");
	    System.out.println(rank);
	}catch(IOException e){
	    System.out.println(e);
	}

    }

}
