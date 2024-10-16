#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#pragma warning (disable : 4996)

#define MAX 100000
#define SIZE 10000


void tri_rapide(int *tab){
    

}



// Fonction de remplissage par des entiers al�atoires d'un tableau de taille SIZE
void generation_tab(int *tab){
    srand(time(NULL));
    for (int i = 0; i < SIZE; i++)
        tab[i] = rand() % MAX;
}

// Fonction v�rifiant si un tableau d'entiers est bien tri�
int verif_tri(int *tab){
    for(int i = 0; i < SIZE-1; i++)
        if(tab[i+1] < tab[i])
            return -1;
    return 1;
}


void tri_bulle(int *tab){
    int tmp,i,j;  
    for (i=0;i<SIZE;i++) {
        for (j=0;j<SIZE-i-1;j++) {
            if (tab[j]>tab[j+1]){
                tmp =tab[j];
                tab[j]=tab[j+1];
                tab[j+1]=tmp;
            }
        }
    }
}

void tri_selection(int *tab) {
    int i, j, tmp, index;

    for (i = 0; i < SIZE - 1; i++) {
        index = i; 
        for (j = i + 1; j < SIZE; j++) { 
            if (tab[j] < tab[index]) {
                index = j;
            }
        }
        if (index != i) {
            tmp = tab[i];
            tab[i] = tab[index];
            tab[index] = tmp;
        }
    }
}


void afficher_tableau(int tab[]) {
    for (int i = 0; i < SIZE; i++) {
        printf("%d ", tab[i]);
    }
    printf("\n");
}

void fusion(int tab[], int indiceG, int indiceM, int indiceD)
{
    int i, j, k;
    int n1 = indiceM-indiceG+1;// A compléter
    int n2 = indiceD-indiceM;// A compléter

    // Création de tableau temporaire
    int L[SIZE], R[SIZE];

    // Initialiser les tableaux temporaires
    for (i = 0; i < n1; i++)
        L[i]=tab[indiceG+i];
    for (j = 0; j < n2; j++)
        R[j]=tab[indiceM+1+j];


    // Fusionner les tableaux temporaires
    i = 0;
    j = 0;
    k = indiceG;
    while (i < n1 && j < n2) {
        if (L[i]<=R[j]) {
            tab[k]=L[i];
            i++;
        }
        else {
            tab[k]=R[j];
            j++;
        }
        k++;
    }

    // Copier les éléments restants du tableau de gauche
    while (i < n1) {
        tab[k]=L[i];
        i++;
        k++;
    }

    // Copier les éléments restants du tableau de droite
    while (j < n2) {
        tab[k]=R[j];
        j++;
        k++;
    }
    //afficher_tableau(tab);
}

void tri_fusion(int tab[], int indiceG, int indiceD)
{
    if (indiceG < indiceD) {
        int indiceM = indiceG + (indiceD - indiceG) / 2;

        // trier les tableaux récursivement
        tri_fusion(tab,indiceG,indiceM);
        tri_fusion(tab,indiceM+1,indiceD);

        fusion(tab,indiceG,indiceM,indiceD);
    }
}
        





int main(void)
{
    clock_t debut,fin;
    int n = 0;
    int tab[MAX];
    printf("Programme pour comparer les algorithmes de tri\n");
    generation_tab(tab);
    tri_fusion(tab,0,SIZE);
    
    if (verif_tri(tab)==1) {
        printf("succès \n");
    }
    else {
        printf("echec \n");
    }
    //printf("Succ�s (1) ou �chec (-1) : %d\n",verif_tri(tab));

    debut = clock();
    tri_fusion(tab,0,SIZE);
    // Mettez ici la fonction dont vous voulez mesurer le temps d'ex�cution
 
    fin = clock();

    printf("Le temps d'execution a ete de %.3f secondes\n",(double)(fin-debut)/CLOCKS_PER_SEC);
}
