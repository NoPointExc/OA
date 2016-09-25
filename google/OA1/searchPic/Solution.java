import java.util.*;
import java.io.*;

class Solution{
    private static final int ERR = -1;
    private static final int DIR = 0;
    private static final int FILE = 1;
    private static final int IMG = 2;

    public int solution(String s){
	int rst = 0;
	//dir stack
	LinkedList<String> stack = new LinkedList<>();
	int curSize = 0; //curSize +stack.size() --> size of path
	//String[] lines = s.split(System.getProperty("line.seperator"));
	String[] lines = s.split("\r?\n",-1);
	
	for(String line : lines){
	    int type = getType(line);
	    int level = getLevel(line);
	    //System.out.println(line+" :"+type);	    
	    while(!stack.isEmpty() && getLevel(stack.peek())>=level){
		String tmp = stack.pop();
		curSize -= tmp.trim().length();
	    }

	    switch(type){
		case DIR:
		    //cd into the dir
		    stack.push(line);
		    curSize += line.trim().length();
		    break;
		case IMG:
		    //output path
		    int len = curSize+stack.size()+line.trim().length()+1;
		    rst += len;
		    break;
	    }
	}

	return rst;
    } 
    
    private int getType(String str){
	int rst  = ERR;
	String[] arr = str.trim().split("\\.");
	
	if(arr.length ==2){
	    if(arr[1].equals("jpeg")||arr[1].equals("png")||arr[1].equals("gif"))
		rst = IMG;
	    else 
		rst = FILE;
	}else if(arr.length == 1){
	    rst = DIR;
	}

	return rst;
    }

    private int getLevel(String str){
	int rst = 0;
	
	for(int i=0;i<str.length();i++){
	    if(str.charAt(i)!=' ') 
		break;
	    rst++;
	}

	return rst;
    }

    public static void main(String[] args){
	Solution s = new Solution();
	String pth = "D:\\GoogleDrive\\OJProject\\OA\\google\\searchPic\\testcase";
	String lines="";
	try{
	    File file = new File(pth);
	    FileInputStream in = new FileInputStream(file);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String line;
	    
	    while((line = br.readLine())!=null){
		lines=lines+line+"\n";
	    }

	}catch(IOException e){
	    e.printStackTrace();
	}
	System.out.println(lines);	
	
	System.out.println("rst="+s.solution(lines));
    }
}
