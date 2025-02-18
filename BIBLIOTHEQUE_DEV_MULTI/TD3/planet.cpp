#include "planet.h"

Planet::Planet(float distance, float radius,
               float rotationTime, float revolutionTime,
               bool isSatellite, Planet* parent)
{

    distance_ = distance;
    radius_ = radius;
    rotationSpeed_ = 0;
    if (rotationTime != 0) rotationSpeed_ = 1 / rotationTime;
    revolutionSpeed_ = 0;
    if (revolutionTime != 0) revolutionSpeed_ = 1 / revolutionTime;

    isSatellite_ = isSatellite;
    if (isSatellite) parent_ = parent;

    // Creation de la quadrique
    sphere_ = gluNewQuadric();
}

Planet::~Planet()
{
    // Destruction de la quadrique
    gluDeleteQuadric(sphere_);
}

void Planet::Display(const float timeInDays) const
{
    float pi = 3.14159;

    glPushMatrix(); // sets origin to (0,0,0)

    // Couleur de l'objet
    GLfloat colortab_DIFFUSE[] = {1, 1, 1, 1.0f};
    GLfloat colortab_AMBIENT[] = {1.0/3.0, 1.0/3.0, 1.0/3.0, 1.0f};
    if (!isSatellite_) {
        colortab_AMBIENT[0] = 1;
        colortab_AMBIENT[1] = 1;
        colortab_AMBIENT[2] = 1;
    }

    float h = 0; float k = 0;
    if (isSatellite_) {
        float angle = parent_->revolutionSpeed_ * timeInDays;
        h = parent_->distance_ * cos(angle);
        k = parent_->distance_ * sin(angle);
        glTranslated(h,k,0);
    }

    // Transformation pour la periode de revolution
    float angle = revolutionSpeed_ * timeInDays;
    float x = distance_ * cos(angle);
    float y = distance_ * sin(angle);
    glTranslated(x,y,0);

    // Transformation pour la periode de rotation
    glRotatef(rotationSpeed_ * timeInDays, 0,0,1);

    glMaterialfv(GL_FRONT,GL_DIFFUSE, colortab_DIFFUSE);
    glMaterialfv(GL_FRONT,GL_AMBIENT, colortab_AMBIENT);

    // Appliquer la texture
    glEnable(GL_TEXTURE_2D);
    glBindTexture(GL_TEXTURE_2D, texture_);
    gluQuadricTexture(sphere_, GL_TRUE);

    // Affichage de la quadrique
    int slices = 32;
    int stacks = 8;
    gluSphere(sphere_,radius_,slices,stacks);


    glPopMatrix();

    // Tracer les trajectoires
    glBegin(GL_LINE_STRIP);
    for (int i=0; i<500; i++) {
        x = distance_ * cos(i*pi/50) + h;
        y = distance_ * sin(i*pi/50) + k;
        glVertex3f(x,y,0);
    }
    glEnd();

}
