#ifndef MYGLWIDGET_H
#define MYGLWIDGET_H

#include "planet.h"
#include "star.h"
#include <QOpenGLWidget>
#include <QKeyEvent>
#include <QTimer>

// Classe dediee a l'affichage d'une scene OpenGL
class MyGLWidget : public QOpenGLWidget
{
    Q_OBJECT

public:

    // Constructeur
    MyGLWidget(QWidget * parent = nullptr);

    // Destructeur
    ~MyGLWidget();


protected:

    // Fonction d'initialisation
    void initializeGL();

    // Fonction de redimensionnement
    void resizeGL(int width, int height);

    // Fonction d'affichage
    void paintGL();

    // Fonction de gestion d'interactions clavier
    void keyPressEvent(QKeyEvent * event);

private:
    // Timer d'animation
    float m_TimeElapsed { 0.0f };
    QTimer m_AnimationTimer;

    // Liste des planetes
    std::vector<Planet*> m_Planetes;

    // Liste des textures
    std::vector<GLuint*> m_Textures;

    // Liste d'étoile
    std::vector<Star*> m_Etoiles;
};

#endif // MYGLWIDGET_H
