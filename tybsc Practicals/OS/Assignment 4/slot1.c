#include<mpi.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>

#define ARRAY_SIZE 1000

int main(int argc, char** argv)
{
     int rank,size;
     int array[ARRAY_SIZE];
     int sum=0;
     int local_sum=0;
     
     MPI_Init(NULL,NULL);
     MPI_Comm_rank(MPI_COMM_WORLD,&rank);
     MPI_Comm_size(MPI_COMM_WORLD,&size);
     
     srand(time(NULL)+rank);
     for (int i=0;i<ARRAY_SIZE;i++)
     {
          array[i]=rand()%100;
     }
     
     for (int i=rank;i<ARRAY_SIZE;i+=size)
     {
          local_sum+=array[i];
     }
     
     MPI_REDUCE(&local_sum,&sum,1,MPI_INT,MPI_SUM,0,MPI_COMM_WORLD);
     
     if (rank==0)
     {
         printf("Sum of %d random numbers : %d\n",ARRAY_SIZE,sum);
     }
     MPI_Finalize();
     return 0;
}
