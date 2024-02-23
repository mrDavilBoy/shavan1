#include<stdio.h>
#include<stdlib.h>

int main()
{
    int initial_head_pos, direction, num_requests,temp,total_seek=0,current_head_pos,n=0;
    float avg_seek_time;
    
    printf("Enter initial head position : ");
    scanf("%d",&initial_head_pos);
    
    printf("Enter the direction (0 for left 1 for right) : ");
    scanf("%d",&direction);
    
    printf("Enter the number of disk requests : ");
    scanf("%d",&num_requests);
    
    int request_queue[num_requests];
    
    printf("Enter the disk queue : ");
    for (int i=0;i<num_requests;i++)
    {
         scanf("%d",&request_queue[i]);
    }    
    for (int i=0;i<num_requests-1;i++)
    {
         for (int j=0;j<num_requests-1;j++)
         {
              if (request_queue[j]>request_queue[j+1])
              {
                  temp = request_queue[j];
                  request_queue[j]=request_queue[j+1];
                  request_queue[j+1]=temp;
              }
         }
    }
    
    int i;
    for (i=0;i<num_requests;i++)
    {
         if (request_queue[i]>=initial_head_pos)
         {
             n=i;
             break;

         }
    }
    
    current_head_pos=initial_head_pos;
    
    if (direction==1)
    {
        printf("Initial Head Position : %d\n",current_head_pos);
        for (int j=i;j<num_requests;j++)
        {
             total_seek+=abs(request_queue[j]-current_head_pos);
             current_head_pos = request_queue[j];
             printf("Head Moving towards %d\n",current_head_pos);
        }
        current_head_pos = request_queue[0];
        
        for (int j=1;j<n;j++)
        {
             printf("Head Moving towards %d\n",current_head_pos);
             total_seek+=abs(request_queue[j]-current_head_pos);
             current_head_pos=request_queue[j];
             
        }
        printf("Head Moving towards %d\n",current_head_pos);
    }
    else
    {
        printf("Initial Head Position : %d\n",current_head_pos);
        for (int j=i-1;j>=0;j--) 
        {
             printf("Head Moving towards %d\n",current_head_pos);
             total_seek+=abs(request_queue[j]-current_head_pos);
             current_head_pos=request_queue[j];
             
        }
        current_head_pos = request_queue[num_requests-1];
        for (int j=num_requests-1;j>=n;j--)
        {
             printf("Head Moving towards %d\n",current_head_pos);
             total_seek+=abs(request_queue[j]-current_head_pos);
             current_head_pos = request_queue[j];
             
        }
        printf("Head Moving towards %d\n",current_head_pos);
        
    }
    printf("Total seek movement : %d\n",total_seek);
    
    return 0;
}


/**

ty56@pc16:~/ty56/ty_OS2_56/Assignment 3$ cc clook.c
ty56@pc16:~/ty56/ty_OS2_56/Assignment 3$ ./a.out 
Enter initial head position : 53
Enter the direction (0 for left 1 for right) : 0
Enter the number of disk requests : 7
Enter the disk queue : 82
170
43
140
24
16
190
Initial Head Position : 53
Head Moving towards 53
Head Moving towards 43
Head Moving towards 24
Head Moving towards 190
Head Moving towards 190
Head Moving towards 170
Head Moving towards 140
Head Moving towards 82
Total seek movement : 145
ty56@pc16:~/ty56/ty_OS2_56/Assignment 3$ 


ty56@pc16:~/ty56/ty_OS2_56/Assignment 3$ cc clook.c
ty56@pc16:~/ty56/ty_OS2_56/Assignment 3$ ./a.out 
Enter initial head position : 53
Enter the direction (0 for left 1 for right) : 1
Enter the number of disk requests : 7
Enter the disk queue : 82
170
43
140
24
16
190
Initial Head Position : 53
Head Moving towards 82
Head Moving towards 140
Head Moving towards 170
Head Moving towards 190
Head Moving towards 16
Head Moving towards 24
Head Moving towards 43
Total seek movement : 164


**/
