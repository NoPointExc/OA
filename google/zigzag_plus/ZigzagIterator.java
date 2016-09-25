import java.util.*;

public class ZigzagIterator {
    LinkedList<Iterator<Integer>> queue;
    
    public ZigzagIterator(List<List<Integer>> vectors) {
	queue = new LinkedList<>();

	for(List<Integer> lst:vectors){
	    queue.add( lst.iterator() );
	}
    }

    public int next(){
	int rst = -1;
	if(queue==null || queue.size()==0)
	    throw new  NullPointerException();

	Iterator<Integer> it;
	while( !(it=queue.poll()).hasNext() ){
	    if(queue.size()==0)
		throw new NullPointerException();
	}

	rst = it.next();
	if(it.hasNext())
	    queue.offer(it);
	
	return rst;
    }

    public boolean hasNext(){
	Iterator<Iterator<Integer>> it = queue.iterator();
	
	while(it.hasNext()){
	    if(it.next().hasNext())
		return true;
	}

	return false;
    }

    public static void main(String[] args){
	List<Integer> it1 = new ArrayList<>();
	List<Integer> it2 = new ArrayList<>();

	for(int i=0;i<10;i++){
	    it1.add(2*i);
	    it2.add(2*i+1);
	}

	it2.add(100);
	it2.add(10000);
	List<List<Integer>> vectors = new LinkedList<>();
	vectors.add(it1);
	vectors.add(it2);

	ZigzagIterator  zig = new ZigzagIterator( vectors );

	while( zig.hasNext() ){
	    System.out.print(zig.next()+" ");
	}
	System.out.println();
    }
}

