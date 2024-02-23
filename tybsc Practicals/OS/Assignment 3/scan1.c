#include<stdio.h>
#include<stdlib.h>

int main(){
  int RQ[100],i,j,n,TotalHeadMoment=0,initial,size,move;
  printf("Enter the number of requests: ");
  scanf("%d",&n);
  printf("Enter the request sequence: ");
  for(i=0;i<n;i++)
    scanf("%d",&RQ[i]);
  printf("Enter initial head position: ");
  scanf("%d",&initial);
  printf("Enter total disk size: ");
  scanf("%d",&size);
  printf("Enter the head movement direction for high 1 and for low 0: ");
  scanf("%d",&move);
  for(i=0;i<n;i++)
  {
    for(j=0;j<n-i-1;j++)
    {
      if(RQ[j]>RQ[j+1])
      {
        int temp;
        temp=RQ[j];
        RQ[j]=RQ[j+1];
        RQ[j+1]=temp;
      }
    }
  }
  
  int index;
  for(i=0;i<n;i++)
  {
    if(initial<RQ[i])
    {
       index=i;
       break;
    }
  }
  
  if(move==1)
  {
    for(i=index;i<n;i++)
    {
      printf("Serving Request: %d\n",RQ[i]);
      TotalHeadMoment=TotalHeadMoment+abs(RQ[i]-initial);
      initial=RQ[i];
    }
     
       TotalHeadMoment=TotalHeadMoment+abs(size-RQ[i-1]-1);
        initial=size-1;  
      for(i=index-1;i>=0;i--)
      {
        printf("Serving Request: %d\n",RQ[i]);
        TotalHeadMoment=TotalHeadMoment+abs(RQ[i]-initial);
        initial=RQ[i];
      }
   }
  
  else
  {
    for(i=index-1;i>=0;i--)
    {
      printf("Serving Request: %d\n",RQ[i]);
      TotalHeadMoment=TotalHeadMoment+abs(RQ[i]-initial);
      initial=RQ[i];
    }
    
    TotalHeadMoment=TotalHeadMoment+abs(RQ[i+1]-0);
    initial=0;
    for(i=index;i<n;i++)
    {
      printf("Serving Request: %d\n",RQ[i]);
      TotalHeadMoment=TotalHeadMoment+abs(RQ[i]-initial);
      initial=RQ[i];
    }
  }
  
  printf("Total head movement is %d",TotalHeadMoment);
  return 0;
  }    
                         
        
/*



           OUTPUT
Enter the number of requests: 8
Enter the request sequence: 98    
183
41
122
14
124
65
67
Enter initial head position: 53
Enter total disk size: 200
Enter the head movement direction for high 1 and for low 0: 1
Serving Request: 65
Serving Request: 67
Serving Request: 98
Serving Request: 122
Serving Request: 124
Serving Request: 183
Serving Request: 41
Serving Request: 14
Total head movement is 331       

*/   
