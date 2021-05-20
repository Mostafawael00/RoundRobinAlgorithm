import java.io.*;

class RoundRobinAlgorithm{ 
    
	public static void main(String args[])throws IOException{
		DataInputStream in=new DataInputStream(System.in);
		int i,j,k,q,sum=0;
                
		System.out.println("Enter The Number of Process:");
		int n=Integer.parseInt(in.readLine());
                
		int brust_Time[]=new int[n];
		int Waiting_Time []=new int[n];
		int Turn_around_time[]=new int[n];
		int a[]=new int[n];
                
		System.out.println("Enter brust Time:");
		for(i=0;i<n;i++){
			System.out.println("Enter brust Time for "+(i+1));
			brust_Time[i]=Integer.parseInt(in.readLine());
		}
                
		System.out.println("Enter Time quantum:");
		q=Integer.parseInt(in.readLine());
		for(i=0;i<n;i++)
			a[i]=brust_Time[i];
		for(i=0;i<n;i++)
			Waiting_Time[i]=0;
		do{
		for(i=0;i<n;i++){
			if(brust_Time[i]>q){
				brust_Time[i]-=q;
				for(j=0;j<n;j++){
					if((j!=i)&&(brust_Time[j]!=0))
					Waiting_Time[j]+=q;
				}
			}
			else{
				for(j=0;j<n;j++){
					if((j!=i)&&(brust_Time[j]!=0))
					Waiting_Time[j]+=brust_Time[i];
				}
				brust_Time[i]=0;
			}
		}
		sum=0;
		for(k=0;k<n;k++)
			sum=sum+brust_Time[k];
		}
		while(sum!=0);
                
		for(i=0;i<n;i++)
			Turn_around_time[i]=Waiting_Time[i]+a[i];
		System.out.println("Processes\t\tBrust Time\tWaiting Time\tTAT");
		for(i=0;i<n;i++){
			System.out.println("Process"+(i+1)+"\t\t"+a[i]+"\t\t"+Waiting_Time[i]+"\t\t"+Turn_around_time[i]);
		}
		float avg_wt=0;
		float avg_tat=0;
		for(j=0;j<n;j++){
			avg_wt+=Waiting_Time[j];
		}
		for(j=0;j<n;j++){
			avg_tat+=Turn_around_time[j];
		}
		System.out.println("Average Waiting Time "+(avg_wt/n)+"\nAverage Turn Around Time"+(avg_tat/n));
	}
}