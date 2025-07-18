import java.util.*;
class Process{
	int AT,WT,TAT,BT,CT,updatedBT;
	String name;
	boolean isCompleted=false;
	
	public String toString(){
		// Format the output with fixed width fields for alignment
		return String.format("%-5s %-5d %-5d %-5d %-5d %-5d", name, AT, BT, TAT, CT, WT);
	}
}
class SJF1{
	static void shortJobFirst(){
		
		Scanner sc=new Scanner(System.in);
		int n=0;
		System.out.println("Enter no. of processes");
		n=sc.nextInt();
		Process processQueue[]=new Process[n];
		for(int i=0;i<n;i++){
			Process process=new Process();
			process.name="P"+(i+1);
			System.out.println("Enter AT of process P"+(i+1));
			process.AT=sc.nextInt();
			System.out.println("Enter BT of process P"+(i+1));
			process.BT=process.updatedBT=sc.nextInt();
			processQueue[i]=process;
		}
		int completed=0;
		int currTime=0;
		float totalTAT=0;
		float totalWT=0;
		int idx=n,max=Integer.MAX_VALUE;

		// Print header with formatted columns
		System.out.printf("%-5s %-5s %-5s %-5s %-5s %-5s\n", "PID", "AT", "BT", "TAT", "CT", "WT");
		while(completed<n){
			max=Integer.MAX_VALUE;
			idx = n; // reset idx every cycle
			for(int i=0;i<n;i++){
				if(processQueue[i].AT <= currTime && !processQueue[i].isCompleted){
					if(processQueue[i].updatedBT < max){
						max=processQueue[i].updatedBT;
						idx=i;
					}
				}
			}
			currTime++;
			if(idx<n){
				processQueue[idx].updatedBT--;
				if(processQueue[idx].updatedBT==0){
					processQueue[idx].isCompleted=true;
					processQueue[idx].CT=currTime;
					processQueue[idx].TAT=processQueue[idx].CT - processQueue[idx].AT;
					processQueue[idx].WT = processQueue[idx].TAT - processQueue[idx].BT;
					completed++;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.println(processQueue[i]);
			totalTAT+=processQueue[i].TAT;
			totalWT+=processQueue[i].WT;
		}
		System.out.printf("Average TAT : %.2f\n", totalTAT/n);
		System.out.printf("Average WT : %.2f\n", totalWT/n);
		
	}
	
	public static void main(String args[]){
		shortJobFirst();
	}
}

