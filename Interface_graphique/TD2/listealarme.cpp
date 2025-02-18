#include <list>
#include<fstream>
#include "listealarme.h"

using namespace std;

ListeAlarme::ListeAlarme()
{
}

Alarme *ListeAlarme::verifier(const QTime &h)
{
    Alarme *a=0;
    iterator it=begin();
    while(a==0 && it!=end())
    {
        if (it->verifier(h)) a=&(*it);
        it++;
    }
    return a;
}


void ListeAlarme::charger(ifstream &is)
{
    int n;
    clear();
    is>>n;
    is.ignore();
    for (int i=0;i<n;i++)
    {
        Alarme a;
        a.charger(is);
        push_back(a);
    }

}

void ListeAlarme::sauver(ofstream &os)
{
    os<<size()<<endl;
    for (iterator it=begin();it!=end();it++) it->sauver(os);

}
