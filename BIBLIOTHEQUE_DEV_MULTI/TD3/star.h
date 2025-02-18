#ifndef STAR_H
#define STAR_H

// Pour Windows / Linux,
#include <GL/glu.h>
// Pour mac OS,
// #include <OpenGL/glu.h>
#include <qopengl.h>
#include <QColor>

class Star
{
private:
    float x_;
    float y_;
    float taille_;
    float z_;

public:
    // Constructeur sans parametres
    Star();

    // Destructeur
    virtual ~Star();

    // Methode d'affichage
    void Display();
};

#endif // STAR_H
