#include <QTime>
#include <fstream>
#include "alarme.h"

using namespace std;

Alarme::Alarme(const string &nom,const QTime &heure,const string texte,bool active) :
    nom_(nom),heure_(heure),texte_(texte),estActive_(active)
{

}


bool Alarme::verifier(const QTime &h)
{
    if (estActive_ && heure_<h)
    {
        estActive_=false;
        return true;
    }
    else return false;
}

void Alarme::charger(ifstream &is)
{
    string heure;
    getline(is,nom_,';');
    getline(is,heure,';');
    getline(is,texte_);
    heure_=QTime::fromString(QString(heure.c_str()));
    estActive_=true;
}

void Alarme::sauver(ofstream &os)
{
    os<<nom_<<";"<<heure_.toString().toStdString()<<";"<<texte_<<endl;
}
