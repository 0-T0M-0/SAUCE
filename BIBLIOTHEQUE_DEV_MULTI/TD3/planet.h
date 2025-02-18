#ifndef PLANET_H
#define PLANET_H

// Pour Windows / Linux,
#include <GL/glu.h>
// Pour mac OS,
// #include <OpenGL/glu.h>
#include <qopengl.h>
#include <QColor>

// Classe dediee pour la gestion d'une planete
class Planet
{
private:
    float radius_;

    float distance_;

    float rotationSpeed_;
    float revolutionSpeed_;

    GLUquadricObj* sphere_;
    bool isSatellite_;
    Planet* parent_;
public:
    // Constructeur avec parametres
    Planet(float distance, float radius,
           float rotationSpeed, float revolutionSpeed,
           bool isSatellite = false, Planet* parent = nullptr);

    // Destructeur
    virtual ~Planet();

    GLuint texture_;

    // Methode d'affichage
    void Display(const float timeInDays) const;
};


#endif // PLANET_H
