int findDuplication(int * A, int n)
{
   for (int i=0; i<n; i++) {
     while (A[i] != i+1) {
       if ( A[ A[i]-1 ] == A[i])
          return A[i];

       swap(A[i], A[ A[i]-1 ]);
     }
   }
}
