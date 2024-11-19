#include <stdio.h>
#pragma warning (disable : 4996)


//fonction � trou � compl�ter

int factorielleiterative(int n)
{
    int total=1;
    int curValeur;
    for (curValeur=1;curValeur<=n;curValeur++)
    {
        total=total*curValeur;
    }
    return total;
}


//fonction � trou � compl�ter

int factoriellerecursive(int valeur)
{
    if (valeur==0)
        return 1;
    else
    {
        return valeur*factoriellerecursive(valeur-1);
    }
}


int main(void)
{
    int n = 0;
    printf("Programme pour la factorielle\n");
    printf("Veuillez saisir une valeur : ");
    scanf("%d", &n);


    printf("Resultat 1 (iteratif): %d\n", factorielleiterative(n));
    printf("\n\n");
    printf("Resultat 2 (recursif): %d\n", factoriellerecursive(n));


}
