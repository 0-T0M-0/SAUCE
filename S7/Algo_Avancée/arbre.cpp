/*
 * arbre.cpp
 *
 *  Created on: Jan 15, 2019
 *      Author: jp
 */

#include <cstdlib>
#include <iostream>
#include "arbre.hpp"

using namespace std;

bool estVide(node* noeud){
	return (noeud == NULL);
}

ABR arbreVide(){
	return NULL;
}

void insere(int val,ABR* arbre){
	node* newNode = new node;
	newNode->valeur = val;
	newNode->filsgauche = NULL;
	newNode->filsdroit = NULL;

	if (estVide(*arbre))
		*arbre = newNode;
	else{
		node* tmp = *arbre;
		node* parent = NULL;
		while(!estVide(tmp)){
			parent = tmp;
			if (tmp->valeur >= val)
				tmp = tmp->filsgauche;
			else
				tmp = tmp->filsdroit;
		}

		if (parent->valeur >= val)
			parent->filsgauche = newNode;
		else
			parent->filsdroit = newNode;
	}
}

bool recherche(int val, ABR arbre){
	node* tmp = arbre;

	while(tmp->valeur != val){
		if (tmp->valeur > val)
			tmp = arbre->filsgauche;
		else
			tmp = arbre->filsdroit;
	}

	if(estVide(tmp))
		return false;
	else
		return true;
}

int taille(ABR arbre){
	if (estVide(arbre))
		return 0;
	else
		return 1 + taille(arbre->filsdroit) + taille(arbre->filsgauche);
}

int hauteur(ABR arbre){
	if (estVide(arbre))
		return 0;
	else{
		int hauteurGauche = hauteur(arbre->filsgauche); 
		int hauteurDroite = hauteur(arbre->filsdroit); 

		return 1 + max(hauteurGauche,hauteurDroite);
	}
}

void parcours_profondeur(ABR arbre, int version){
	if(!estVide(arbre)){
		if(version == 1){
				/* A compléter (parcours préfixe) */
			cout << arbre->valeur << " ";
			parcours_profondeur(arbre->filsgauche, version);
			parcours_profondeur(arbre->filsdroit, version);
		}
		else if(version == 2){
            /* A compléter (parcours suffixe) */
			parcours_profondeur(arbre->filsgauche, version);
			parcours_profondeur(arbre->filsdroit, version);
			cout << arbre->valeur << " ";

		}
		else{
			parcours_profondeur(arbre->filsgauche, version);
			cout << arbre->valeur << " ";
			parcours_profondeur(arbre->filsdroit, version);
		}
	}
}
