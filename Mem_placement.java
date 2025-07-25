import java.util.*;
class Mem_placement{
	static int processes=0;
	static int blocks=0;
	
	static int required[];
	
	static void firstFit(int memory[]){
		System.out.println("\n\nusing first fit");
		for(int i=0;i<processes;i++){
			boolean flag=false; 
			for(int j=0;j<blocks;j++){
				if(memory[j] >= required[i]){
					System.out.println("Memory allocated for process P"+(i+1)+" in block "+(j+1));
					memory[j]-=required[i];
					flag=true;
					break;
				}
			}
			if(!flag){
				System.out.println("Memory not allocated for process P"+(i+1));
			}
		}
		System.out.println("\nFragmented blocks:");
		for(int i=0;i<blocks;i++){
			System.out.println("Memory block "+(i+1)+" : "+memory[i]);
		}
	}
	
	static void bestFit(int memory[]){
		System.out.println("\n\nusing best fit");
		for(int i=0;i<processes;i++){
			int best=Integer.MAX_VALUE;
			int bestIdx=-1;
			boolean flag=false; 
			for(int j=0;j<blocks;j++){
				if(memory[j] >= required[i] && (memory[j] - required[i]) < best){
					best=memory[j] - required[i];
					bestIdx=j;
					//System.out.println("Memory allocated for process P"+(i+1)+" in block "+(j+1));
					//memory[j]-=required[i];
					flag=true;
					//break;
				}
			}
			if(!flag){
				System.out.println("Memory not allocated for process P"+(i+1));
			}else{
				System.out.println("Memory allocated for process P"+(i+1)+" in block "+(bestIdx+1));
				memory[bestIdx]-=required[i];
			}
		}
		System.out.println("\nFragmented blocks:");
		for(int i=0;i<blocks;i++){
			System.out.println("Memory block "+(i+1)+" : "+memory[i]);
		}
	}
	public static void main(String args[]){
		int memory[];
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of processes");
		processes=sc.nextInt();
		System.out.println("Enter no. of memory blocks");
		blocks=sc.nextInt();
		required=new int[processes];
		memory=new int[blocks];
		
		for(int i=0;i<processes;i++){
			System.out.println("Enter memory requirement for process P"+(i+1));
			required[i]=sc.nextInt();
		}
		
		for(int i=0;i<blocks;i++){
			System.out.println("Enter size of memory block "+(i+1));
			memory[i]=sc.nextInt();
		}
		System.out.println("\nInitially");
		for(int i=0;i<blocks;i++){
			System.out.println("Memory block "+(i+1)+" : "+memory[i]);
		}
		int[] memoryForFirstFit = Arrays.copyOf(memory, blocks);
		int[] memoryForBestFit = Arrays.copyOf(memory, blocks);

		firstFit(memoryForFirstFit);		
		bestFit(memoryForBestFit);
	}
}
