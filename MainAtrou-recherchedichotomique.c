#include <stdio.h>
#pragma warning (disable : 4996)

//fonction � trou � compl�ter

int recherchedichotomiqueiterative(int value, int starting, int ending)
{
    if (ending < starting) return -1;
    while (ending != starting)
    {
        int mid= (starting+ending)/2;
        if (mid == value)
        {
            return mid;
        }
        if (mid > value)
        {
            ending = mid;
        }
        if (mid < value)
        {
            starting = mid;
        }
    }
}

//fonction � trou � compl�ter

int recherchedichotomiquerecursive(int value, int starting, int ending)
{
    if (ending < starting) return ;
    int mid = (starting+ending)/2;
    if (mid == value)
    {
        return mid;
    }
    if (mid > value)
    {
        return recherchedichotomiquerecursive(value,starting,mid);
    }
    if (mid < value)
    {
        return recherchedichotomiquerecursive(value,mid,ending);
    }
    return 0;
}

int main(void)
{
    int start = 0, end = 0, valeur = 0;
    printf("Programme pour la recherche dichotomique\n");
    printf("Veuillez saisir une valeur de debut: ");
    scanf("%d", &start);
    printf("Veuillez saisir une valeur de fin: ");
    scanf("%d", &end);
    printf("Veuillez saisir le nombre que l'on doit chercher: ");
    scanf("%d", &valeur);


    printf("Resultat 1 (iteratif): %d\n", recherchedichotomiqueiterative(valeur,start,end));
    printf("\n\n");
    printf("Resultat 1 (recursif): %d\n", recherchedichotomiquerecursive(valeur,start,end));
}
