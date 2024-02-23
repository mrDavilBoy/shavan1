#include<stdio.h>
#include<math.h>
#include<stdlib.h>

int main()
{
    int queue[100],i,n,seek=0,head,count=0;
    printf("Enter the number of request : ");
    scanf("%d",&n);
    printf("Enter the request sequence : \n");
    for (i=0;i<n;i++)
         scanf("%d",&queue[i]);
    printf("Enter the head position : \n");
    scanf("%d",&head);
    
    while (count!=n)
    {
           int min=1000,d,index;
           for (i=0;i<n;i++)
           {
                d = abs(queue[i]-head);
                if (min>d)
                {
                    min = d;
                    index = i;
                }
           }
           seek += min;
           printf("\nDisk head moves from %d to %d with head movement of %d",head,queue[index],min);
           head=queue[index];
           queue[index]=1000;
           count++;
    }
    printf("\n\nTotal head movement is %d\n",seek);
    return 0;
}

/**

ty56@pc16:~/ty56/ty_OS2_56/Assignment 3$ cc sstf.c
ty56@pc16:~/ty56/ty_OS2_56/Assignment 3$ ./a.out 
Enter the number of request : 8
Enter the request sequence : 
98
183
41
122
14
124
65
67
Enter the head position : 
53

Disk head moves from 53 to 41 with head movement of 12
Disk head moves from 41 to 65 with head movement of 24
Disk head moves from 65 to 67 with head movement of 2
Disk head moves from 67 to 98 with head movement of 31
Disk head moves from 98 to 122 with head movement of 24
Disk head moves from 122 to 124 with head movement of 2
Disk head moves from 124 to 183 with head movement of 59
Disk head moves from 183 to 14 with head movement of 169

Total head movement is 323



**/
