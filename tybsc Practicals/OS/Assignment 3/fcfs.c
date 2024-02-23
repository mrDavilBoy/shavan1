#include<stdio.h>
#include<math.h>
#include<stdlib.h>

int main()
{
    int queue[20],n,head,i,j,k,seek=0,max,diff;
    printf("\nEnter the max range of disk : ");
    scanf("%d",&max);
    printf("Enter the size of queue request : ");
    scanf("%d",&n);
    printf("Enter the queue of disk positions to be read : ");
    for (i=1;i<=n;i++)
        scanf("%d",&queue[i]);
    printf("Enter the initial head position : ");
    scanf("%d",&head);
    queue[0]=head;
    for (j=0;j<=n-1;j++)
    {
         diff = abs(queue[j+1]-queue[j]);
         seek+=diff;
         printf("\nDisk head moves from %d to %d with head movement of %d",queue[j],queue[j+1],diff);
    }
    printf("\n\nTotal Head Movement is %d\n",seek);
    return 0;
}

/**
ty56@pc16:~/ty56/ty_OS2_56/Assignment 3$ cc fcfs.c
ty56@pc16:~/ty56/ty_OS2_56/Assignment 3$ ./a.out 

Enter the max range of disk : 200
Enter the size of queue request : 8
Enter the queue of disk positions to be read : 98
183
41
122
14
124
65
67
Enter the initial head position : 53

Disk head moves from 53 to 98 with head movement of 45
Disk head moves from 98 to 183 with head movement of 85
Disk head moves from 183 to 41 with head movement of 142
Disk head moves from 41 to 122 with head movement of 81
Disk head moves from 122 to 14 with head movement of 108
Disk head moves from 14 to 124 with head movement of 110
Disk head moves from 124 to 65 with head movement of 59
Disk head moves from 65 to 67 with head movement of 2

Total Head Movement is 632


**/
