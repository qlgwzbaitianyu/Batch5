import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println( ml.search(n5));
		Lock lock = new ReentrantLock(true);
		
		Mylist ml2 = new Mylist();
		Listwrite lw = new Listwrite(ml2, lock);
		Thread t1 = new Thread(lw);
		
		Listread lr = new Listread(ml2, lock);
		Thread t2 = new Thread(lr);
		
		t1.start();
		t2.start();
		
		
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println( ml2.search(n5));
		

	}

}

class Listread implements Runnable{
	Mylist ml;
	Lock lock;
	
	Listread(Mylist ml, Lock lock){
		this.ml = ml;
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Node[] nodeArray = new Node[50];
		
		for(int i = 0; i < 50; i++) {
			nodeArray[i] = new Node(i);
			
			
			try {
				if (lock.tryLock(1, TimeUnit.SECONDS)) {
				
					try {
						System.out.println("from read: " + nodeArray[i].data);
						ml.search(nodeArray[i]);
					}
					finally {
						lock.unlock();
					}
				
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}	
}




class Listwrite implements Runnable{
	Mylist ml;
	  Lock lock;
	
	Listwrite(Mylist ml, Lock lock){
		this.ml = ml;
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Node[] nodeArray = new Node[50];
		
		for(int i = 0; i < 50; i++) {
			nodeArray[i] = new Node(i);
			
			try {
				if (lock.tryLock(1, TimeUnit.SECONDS)) {
					 
					System.out.println("from writeer: " + nodeArray[i].data);
					ml.add(nodeArray[i]);
				
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			finally {
				lock.unlock();
			}
			
		}
		
	}	
}


class Mylist{
	Node head;
	
	Mylist(){
		head = null;
	}
	
	// write if write no one can write or search
	public void add(Node n) {
		Node x;
		
		if(head == null) {
			head = n;
		}
		else {
			x = head;
			while( x.next != null) {
				x = x.next;
			}
			x.next = n;
		}
		
		
	}
	
	
	// read if read, no one can write but others can read
	public Node search(Node n) {
		Node x = head;
		if(x == null) {
			return x;
		}
		
		while(x != null) {
			//System.out.println(x.data);
			if(x.data == n.data) {
				return x;
			}
			x = x.next;
		}
		x = null;
		return x;
	}
	
	public void print() {
		
	}
	
}


class Node{
	int data;
	Node next;
	
	Node(){
		
	}
	
	Node(int data){
		this.data = data;
	}
	
	
}