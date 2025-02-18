#include "star.h"
#include <cmath>
#include <cstdlib> // Pour rand()

#define PI 3.14159265358979323846

Star::Star() {
    unsigned short step = 100;
    float radius = 800.0f;  // Rayon de la sphère

    // Génère des angles aléatoires
    float theta = ((rand() % 10000) / 10000.0f) * 2.0f * PI;  // [0, 2π]
    float phi = acos(2.0f * ((rand() % 10000) / 10000.0f) - 1.0f);  // [0, π] (distribution uniforme)

    // Convertit en coordonnées cartésiennes
    x_ = radius * sin(phi) * cos(theta);
    y_ = radius * sin(phi) * sin(theta);
    z_ = radius * cos(phi);

    taille_ = (rand() % (2 * step)) / (float)step + 1;
}

Star::~Star() {}

void Star::Display() {
    glPushMatrix();

    glTranslated(x_, y_, z_);
    glPointSize(taille_);
    glBegin(GL_POINTS);
    glVertex3f(0, 0, 0);  // L'étoile est dessinée en (0,0,0) localement
    glEnd();

    glPopMatrix();
}
