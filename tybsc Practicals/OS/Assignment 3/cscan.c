#include<stdio.h> 
#include<stdlib.h>

int main()
{
    int RQ[100],i,j,n,TotalHeadMoment=0,initial,size,move;
    printf("Enter the Number of Requests : ");
    scanf("%d",&n);
    printf("Enter the request sequence : ");
    for (i=0;i<n;i++)
         scanf("%d",&RQ[i]);
    printf("Enter initial head position : ");
    scanf("%d",&initial);
    printf("Enter total disk size : ");
    scanf("%d",&size);
    printf("Enter the head movement direction for high 1 and for low 0 : ");
    scanf("%d",&move);
    for (i=0;i<n;i++)
    {
        for (j=0;j<n-i-1;j++)
        {
            if (RQ[j]>RQ[j+1])
            {
               int temp;
               temp=RQ[j];
               RQ[j]=RQ[j+1];
               RQ[j+1]=temp;
            }
        }
    }
  
    int index;
    for (i=0;i<n;i++)
    {
        if (initial<RQ[i])
        {
           index=i;
           break;
        }
    }
  
    if (move==1)
    {
        for (i=index;i<n;i++)
        {
            printf("Servicing request : %d\n",RQ[i]);
            TotalHeadMoment=TotalHeadMoment+abs(RQ[i]-initial);
            initial=RQ[i];
        }
        printf("Servicing request : %d\n",size);
        TotalHeadMoment=TotalHeadMoment+abs(size-RQ[i-1]-1);
        TotalHeadMoment=TotalHeadMoment+abs(size-1-0);
        initial=0;  
        for (i=0;i<index;i++)
        {
            printf("Servicing request : %d\n",RQ[i]);
            TotalHeadMoment=TotalHeadMoment+abs(RQ[i]-initial);
            initial=RQ[i];
        }
    }
    else
    {
        for (i=index-1;i>=0;i--)
        {
             printf("Servicing request : %d\n",RQ[i]);
             TotalHeadMoment=TotalHeadMoment+abs(RQ[i+1]-0);
             TotalHeadMoment+=abs(size-1-0);
             initial=size-1;
        }
       
        for (i=n-1;i>=0;i--)
        {
             printf("Servicing request : %d\n",RQ[i]);
             TotalHeadMoment=TotalHeadMoment+abs(RQ[i]-initial);
             initial=RQ[i];
        }
    }
  
    printf("\nTotal head movement is %d\n",TotalHeadMoment);
    return 0;
}    

/**
ty56@pc16:~/ty56/ty_OS2_56/Assignment 3$ cc cscan.c
ty56@pc16:~/ty56/ty_OS2_56/Assignment 3$ ./a.out 
Enter the Number of Requests : 8
Enter the request sequence : 98 
183
41
122
14
124
65
67
Enter initial head position : 53
Enter total disk size : 200
Enter the head movement direction for high 1 and for low 0 : 1
Servicing request : 65
Servicing request : 67
Servicing request : 98
Servicing request : 122
Servicing request : 124
Servicing request : 183
Servicing request : 200
Servicing request : 14
Servicing request : 41

Total head movement is 386

**/                 
        
    
