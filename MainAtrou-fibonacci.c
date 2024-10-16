#include <stdio.h>
#pragma warning (disable : 4996)


//fonction � trou � compl�ter

int fibonacci(int n) {

    if (n==1 || n==2)
        return 1;
    
    int fibA = 1 , fibB = 1 ;
    int fib=0;
    for (int i=3; i<=n; i++) {
        fib = fibA+fibB;
        fibA = fibB;
        fibB = fib;
    }
    return fib;
}

//fonction � trou � compl�ter

int fibonaccirecursif(int n) {
    if (n==1 || n==2)
        return 1;
    else
    {
        return fibonaccirecursif(n-1)+fibonaccirecursif(n-2);
    }
}

int main(void)
{
    int n = 0;
    printf("Programme pour la suite de fibonacci\n");
    printf("Veuillez saisir une valeur : ");
    scanf("%d", &n);
	

	printf("Resultat 1 (iteratif): %d\n", fibonacci(n));
    printf("Resultat 2 (recursif): %d\n", fibonaccirecursif(n));


}
