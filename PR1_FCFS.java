import java.util.*;
class Task implements Comparable<Task>{
	public int AT,BT,TAT,CT,ST,WT;
	public String name;
	
	public int compareTo(Task other){
		return Integer.compare(this.AT,other.AT);
	}
	
	public String toString() {
        	return name+"     "+AT+"    "+BT+"    "+TAT+"    "+CT+"    "+WT;
    	}
	
}
class sample{
	static void FCFS(){
		PriorityQueue<Task> taskQueue=new PriorityQueue<>();
		Scanner sc=new Scanner(System.in);
		int n=0;
		System.out.println("Enter no. of tasks");
		n=sc.nextInt();
		for(int i=0;i<n;i++){
			Task task=new Task();
			task.name="P"+(i+1);
			System.out.println("Enter AT of task P"+(i+1));
			task.AT=sc.nextInt();
			System.out.println("Enter BT of task P"+(i+1));
			task.BT=sc.nextInt();
			taskQueue.add(task);
		}
		//System.out.println(taskQueue);
		int currTime=0;
		float totalTAT=0,totalWT=0;
		System.out.println("Name   AT   BT   TAT   CT   WT");
		while(!taskQueue.isEmpty()){
			Task currTask=taskQueue.peek();
			if(currTask.AT <= currTime){
				currTask.ST=currTime;
				currTask.CT=currTime+currTask.BT;
				currTask.TAT=currTask.CT-currTask.AT;
				currTask.WT=currTask.TAT-currTask.BT;
				totalTAT+=currTask.TAT;
				totalWT+=currTask.WT;
				currTime+=currTask.BT;
				System.out.println(currTask);
				taskQueue.poll();
			}else
				currTime++;
		}
		System.out.println("Average TAT : "+totalTAT/n);
		System.out.println("Average WT : "+totalWT/n);
	}
	public static void main(String args[]){
		FCFS();
	}
}
