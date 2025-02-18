#ifndef ALARME_H
#define ALARME_H

#include <QTime>
#include <fstream>
#include <string>

using namespace std;

class Alarme
{
    string nom_;
    QTime heure_;
    string texte_;
    bool estActive_;
public:
    Alarme(const string &nom="",const QTime &heure=QTime(),const string texte="",bool active=true);
    const string &getNom() const {return nom_;}
    const QTime &getHeure() const {return heure_;}
    const string &getTexte() const {return texte_;}
    void activer() {estActive_=true;}
    bool verifier(const QTime &h);
    void charger(ifstream &is);
    void sauver(ofstream &os);
};

#endif // ALARME_H
