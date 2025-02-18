#ifndef LISTEALARME_H
#define LISTEALARME_H

#include<list>
#include<fstream>
#include "alarme.h"

class ListeAlarme : public list<Alarme>
{
public:
    ListeAlarme();
    Alarme *verifier(const QTime &h);
    void charger(std::ifstream &is);
    void sauver(std::ofstream &os);
};

#endif // LISTEALARME_H
