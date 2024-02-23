#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX 100

typedef struct dir
{
      char fname[20];
      int start;
      struct dir *next;
}NODE;

NODE *head,*last,*temp,*prev,*dell,*tmp;
int n,bit[MAX],fb=0;

void init()
{
      int i;
      printf("Enter total no. of disk blocks : ");
      scanf("%d",&n);
      for (i=0;i<n;i++)
      {
           bit[i]=rand()%2;
      }
}

void show_bitvector()
{
     int i;
     for (i=0;i<n;i++)
          printf("%d ",bit[i]);
     printf("\n");
}

void show_dir()
{
     NODE *temp;
     int i;
     printf("\nDirectory : ");
     printf("\nFile Name   Allocated Block Number");
     for (temp=head;temp!=NULL;temp=temp->next)
     {
          printf("\n %s",temp->fname);
          printf("      %d",temp->start);
     }
     printf("\n\nAllocated Blocks : ");
     for (temp=head;temp!=NULL;temp=temp->next)
     {
          printf("%d->",temp->start);
     }
     printf("NULL\n\n");
}

void create()
{
     NODE *p;
     char fname[20];
     int i,j,nob;
     int fb=0;
     printf("Enter file name : ");
     scanf("%s",&fname);
     printf("Enter the no of blocks : ");
     scanf("%d",&nob);
     for (i=0;i<n;i++)
     {
          if (bit[i]==0)
              fb++;
     }
     if (nob>fb)
     {
         printf("Failed to create file %s\n",fname);
         return;
     }
     else
     {
         for (i=0;i<n;i++)
         {
              if (bit[i]==0 && nob!=0)
              {
                  p=(NODE*)malloc(sizeof(NODE));
                  strcpy(p->fname,fname);
                  nob--;
                  bit[i]=1;
                  p->start=i;
                  p->next=NULL;
                  if (head==NULL)
                      head=p;
                  else
                      last->next=p;
                  last=p;
              }
         }
         printf("File %s created successfully \n",fname);
     }
}

void delete()
{
     int i=0;
     NODE *p,*q;
     char fname[20];
     
     temp=head;
     printf("Enter file to be deleted : ");
     scanf("%s",fname);
     
     while (temp!=NULL)
     {
            p=q=head;
            while (p!=NULL)
            {
                   if (strcmp(p->fname,fname)==0)
                       break;
                       
                   q=p;
                   p=p->next;
            }
            
            if (p==NULL)
            {
                return;
            }
            
            if (p==head)
                head=head->next;
            else if (p==last)
            {
                last=q;
                last->next=NULL;
            }
            else
            {
                 q->next=p->next;
            }
            bit[p->start]=0;
            free(p);
            temp=temp->next;
     }
     printf("File %s deleted successfully\n",fname);
}

int main()
{
    int ch;
    init();
    while(1)
    {
        printf("\n*******Menu*******\n");
        printf("\n1.Show bit Vector");
        printf("\n2.Create New File");
        printf("\n3.Show Directory");
        printf("\n4.Delete File");
        printf("\n5.Exit\n");
        printf("\nEnter Your Choice : \n");
        scanf("%d",&ch);
        
        switch (ch)
        {
                case 1: show_bitvector();
                        break;
                case 2: create();
                        break;
                case 3: show_dir();
                        break;
                case 4: delete();
                        break;
                case 5: exit(0);
        }
    }
}

/**
**************OUTPUT**************

ty56@pc16:~/ty56/ty_OS2_56/Assignment 2$ cc linked.c
ty56@pc16:~/ty56/ty_OS2_56/Assignment 2$ ./a.out 
Enter total no. of disk blocks : 50

*******Menu*******

1.Show bit Vector
2.Create New File
3.Show Directory
4.Delete File
5.Exit

Enter Your Choice : 
1
1 0 1 1 1 1 0 0 1 1 0 1 0 1 1 0 0 0 0 0 1 0 1 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 1 0 1 1 1 1 0 1 0 0 1 0 

*******Menu*******

1.Show bit Vector
2.Create New File
3.Show Directory
4.Delete File
5.Exit

Enter Your Choice : 
2
Enter file name : harsh
Enter the no of blocks : 7 
File harsh created successfully 

*******Menu*******

1.Show bit Vector
2.Create New File
3.Show Directory
4.Delete File
5.Exit

Enter Your Choice : 
1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 1 0 1 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 1 0 1 1 1 1 0 1 0 0 1 0 

*******Menu*******

1.Show bit Vector
2.Create New File
3.Show Directory
4.Delete File
5.Exit

Enter Your Choice : 
3

Directory : 
File Name   Allocated Block Number
 harsh      1
 harsh      6
 harsh      7
 harsh      10
 harsh      12
 harsh      15
 harsh      16

Allocated Blocks : 1->6->7->10->12->15->16->NULL


*******Menu*******

1.Show bit Vector
2.Create New File
3.Show Directory
4.Delete File
5.Exit

Enter Your Choice : 
2
Enter file name : shivam
Enter the no of blocks : 4
File shivam created successfully 

*******Menu*******

1.Show bit Vector
2.Create New File
3.Show Directory
4.Delete File
5.Exit

Enter Your Choice : 
1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 1 0 1 1 1 1 0 1 0 0 1 0 

*******Menu*******

1.Show bit Vector
2.Create New File
3.Show Directory
4.Delete File
5.Exit

Enter Your Choice : 
3

Directory : 
File Name   Allocated Block Number
 harsh      1
 harsh      6
 harsh      7
 harsh      10
 harsh      12
 harsh      15
 harsh      16
 shivam      17
 shivam      18
 shivam      19
 shivam      21

Allocated Blocks : 1->6->7->10->12->15->16->17->18->19->21->NULL


*******Menu*******

1.Show bit Vector
2.Create New File
3.Show Directory
4.Delete File
5.Exit

Enter Your Choice : 
4
Enter file to be deleted : shivam

*******Menu*******

1.Show bit Vector
2.Create New File
3.Show Directory
4.Delete File
5.Exit

Enter Your Choice : 
3

Directory : 
File Name   Allocated Block Number
 harsh      1
 harsh      6
 harsh      7
 harsh      10
 harsh      12
 harsh      15
 harsh      16

Allocated Blocks : 1->6->7->10->12->15->16->NULL


*******Menu*******

1.Show bit Vector
2.Create New File
3.Show Directory
4.Delete File
5.Exit

Enter Your Choice : 
4    
Enter file to be deleted : harsh
File harsh deleted successfully

*******Menu*******

1.Show bit Vector
2.Create New File
3.Show Directory
4.Delete File
5.Exit

Enter Your Choice : 
3

Directory : 
File Name   Allocated Block Number

Allocated Blocks : NULL


*******Menu*******

1.Show bit Vector
2.Create New File
3.Show Directory
4.Delete File
5.Exit

Enter Your Choice : 
5

**/
