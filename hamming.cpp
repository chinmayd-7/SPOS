#include<iostream>
using namespace std;
int main(){
	int d1,d2,d3,d4;
	cout<<"Enter 1st bit in data\n";
	cin>>d1;
	cout<<"Enter 2nd bit in data\n";
	cin>>d2;
	cout<<"Enter 3rd bit in data\n";
	cin>>d3;
	cout<<"Enter 4th bit in data\n";
	cin>>d4;
	int p1=0,p2=0,p3=0;
	int send[]={p1,p2,d1,p3,d2,d3,d4};
	
	
	cout<<"p1  p2  d1  p3  d2  d3  d4\n";
	cout<<"Initially: \n";
	cout<<send[0]<<"   "<<send[1]<<"   "<<send[2]<<"   "<<send[3]<<"   "<<send[4]<<"   "<<send[5]<<"   "<<send[6]<<"\n";
	
	if((send[2]+send[4]+send[6])%2==0)
		p1=send[0]=0;
	else
		p1=send[0]=1;
	
	if((send[2]+send[5]+send[6])%2==0)
		p2=send[1]=0;
	else
		p2=send[1]=1;
	
	if((send[4]+send[5]+send[6])%2==0)
		p3=send[3]=0;
	else
		p3=send[3]=1;
		
	cout<<"With parity bits calculated: \n";
	cout<<send[0]<<"   "<<send[1]<<"   "<<send[2]<<"   "<<send[3]<<"   "<<send[4]<<"   "<<send[5]<<"   "<<send[6]<<"\n";
		
	return 0;
}
