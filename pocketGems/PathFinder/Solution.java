import java.io.*;
import java.util.*;


class Solution{
	static String[] graph = new String[26];
	static boolean[] visited = new boolean[26];
	static List<String> pathes = new LinkedList<>();

	public static void main (String[] args){
		//String[] lines = {"ABC","BCEG","CAF","DCJ","FBH","GCD","HABFI","IB"};
		String[] fileNames = {"input_1.txt",  "input_2.txt",  "input_3.txt"};
		try{
			for(String fileName : fileNames){		
				String[] lines = FileParser.parseLines(fileName);
				
				//if(lines.length > 1){
					String[] line0 = lines[0].split(" ");
					//if(line0.length == 2){
							char from = line0[0].charAt(0);
							char to = line0[1].charAt(0);	

							System.out.println(lines[0]);
							Arrays.fill(graph,"");
							for(int i=1; i<lines.length; i++){
								graph[lines[i].charAt(0) - 'A'] = lines[i];
							}

							pathes = new LinkedList<>();
							Arrays.fill(visited,false);

							findPath(from,to, new StringBuilder());
							System.out.println(pathes);																	
					//}
				//}

			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	static void findPath(char from, char to, StringBuilder path){
	    path.append(from);
	    if(from == to){
			pathes.add(path.toString());	
	    }else{
			visited[from - 'A'] = true;
			char[] nodes = graph[from - 'A'].toCharArray();
				
			for(char c : nodes){
			    if(!visited[c-'A']){
				findPath(c,to,path);
			    }    
			}
		
	    }
	}


}
