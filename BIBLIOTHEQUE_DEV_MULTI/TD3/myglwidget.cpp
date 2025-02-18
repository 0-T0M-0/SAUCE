#define _USE_MATH_DEFINES

// Pour Windows / Linux,
#include <GL/glu.h>
// Pour mac OS,
// #include <OpenGL/glu.h>
#include "myglwidget.h"
#include "planet.h"
#include "star.h"
#include <QApplication>

// Declarations des constantes
const unsigned int WIN_WIDTH_HEIGHT = 900;
const float MAX_DIMENSION     = 50.0f;

// Constructeur
MyGLWidget::MyGLWidget(QWidget * parent) : QOpenGLWidget(parent)
{
   setFixedSize(WIN_WIDTH_HEIGHT, WIN_WIDTH_HEIGHT);

   // Connexion du timer
   connect(&m_AnimationTimer,  &QTimer::timeout, [&] {
       m_TimeElapsed += 1.0f / 2.0f;
       update();
   });

   m_AnimationTimer.setInterval(10);
   m_AnimationTimer.start();
}

MyGLWidget::~MyGLWidget()
{
    for (Planet* planet : m_Planetes) {
        delete planet;
    }
    for (Star* star : m_Etoiles) {
        delete star;
    }
    for (GLuint* texture : m_Textures) {
        glDeleteTextures(1, texture);
        delete texture;
    }
}
// Fonction d'initialisation
void MyGLWidget::initializeGL()
{

    // Reglage de la couleur de fond
    glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

    // Activation du zbuffer
    glEnable(GL_DEPTH_TEST);

    // Distance par rapport au soleil, rayon, periode de rotation, periode de révolution
    // 0.0f, 5.0f, 0.0f, 0.0f               // Soleil
    // 7.5f, 0.50f,  58.646f,   87.969f     // Mercure
    // 10.0f, 0.90f, -243.018f, 224.701f    // Venus
    // 13.0f, 0.90f, 0.997f,    365.256f    // Terre
    // 17.5f, 1.50f, 1.025f,    686.960f    // Mars
    // 27.0f, 3.00f, 0.413f,    935.354f    // Jupiter
    // 35.0f, 2.50f, 0.448f,    1757.736f   // Saturne
    // 40.5f, 1.50f, -0.718f,   3687.150f   // Uranus
    // 45.0f, 1.50f, 0.671f,    6224.903f  // Neptune

    std::vector<std::vector<unsigned char>> m_Colors;
    m_Colors.push_back(std::vector<unsigned char> {240, 198, 29}    ); // Soleil
    m_Colors.push_back(std::vector<unsigned char> {200, 248, 242}   ); // Mercure
    m_Colors.push_back(std::vector<unsigned char> {255, 255, 242}   ); // Venus
    m_Colors.push_back(std::vector<unsigned char> {11, 92, 227}     ); // Terre
    m_Colors.push_back(std::vector<unsigned char> {247, 115, 12}    ); // Mars
    m_Colors.push_back(std::vector<unsigned char> {253, 199, 145}   ); // Jupiter
    m_Colors.push_back(std::vector<unsigned char> {200, 196, 251}   ); // Saturne
    m_Colors.push_back(std::vector<unsigned char> {198, 241, 245}   ); // Uranus
    m_Colors.push_back(std::vector<unsigned char> {57, 182, 247}    ); // Neptune
    m_Colors.push_back(std::vector<unsigned char> {128, 128, 128}    ); // Neptune

    // Creation des planètes et ajout des planetes dans le vecteur m_Planetes
    m_Planetes.push_back(new Planet(0.0f, 5.0f, 0.0f, 0.0f));               // Soleil
    m_Planetes.push_back(new Planet(7.5f, 0.50f,  58.646f,   87.969f, true, m_Planetes[0]));     // Mercure
    m_Planetes.push_back(new Planet(10.0f, 0.90f, -243.018f, 224.701f, true, m_Planetes[0]));    // Venus
    m_Planetes.push_back(new Planet(13.0f, 0.90f, 0.997f,    365.256f, true, m_Planetes[0]));    // Terre
    m_Planetes.push_back(new Planet(17.5f, 1.50f, 1.025f,    686.960f, true, m_Planetes[0]));    // Mars
    m_Planetes.push_back(new Planet(27.0f, 3.00f, 0.413f,    935.354f, true, m_Planetes[0]));    // Jupiter
    m_Planetes.push_back(new Planet(35.0f, 2.50f, 0.448f,    1757.736f, true, m_Planetes[0]));   // Saturne
    m_Planetes.push_back(new Planet(40.5f, 1.50f, -0.718f,   3687.150f, true, m_Planetes[0]));   // Uranus
    m_Planetes.push_back(new Planet(45.0f, 1.50f, 0.671f,    6224.903f, true, m_Planetes[0]));   // Neptune
    m_Planetes.push_back(new Planet(2.0f, 0.35f, 27.3f,    27.3f, true, m_Planetes[3])); // Lune

    glEnable(GL_LIGHTING);

    glEnable(GL_LIGHT0);
    GLfloat light0_pos[] = {0.0, 0.0, 0.0, 1.0};
    GLfloat light0_color[] = {1.0, 1.0, 1.0, 1.0};
    glLightfv(GL_LIGHT0,GL_POSITION,light0_pos);
    glLightfv(GL_LIGHT0,GL_AMBIENT,light0_color);
    glLightfv(GL_LIGHT0,GL_DIFFUSE,light0_color);

    glDisable(GL_LIGHT_MODEL_AMBIENT);
    // GLfloat light_model_ambient_tab[] = {0.75, 0.75, 0.75, 1.0};
    // glLightModelfv(GL_LIGHT_MODEL_AMBIENT, light_model_ambient_tab);

    // Charger les textures
    QImage img;
    QStringList textureFiles = {
        "/home/t-0/Documents/TD3/res/soleil.jpg", "/home/t-0/Documents/TD3/res/mercure.jpg", "/home/t-0/Documents/TD3/res/venus.jpg", "/home/t-0/Documents/TD3/res/terre.jpg",
        "/home/t-0/Documents/TD3/res/mars.jpg", "/home/t-0/Documents/TD3/res/jupiter.jpg", "/home/t-0/Documents/TD3/res/saturne.jpg", "/home/t-0/Documents/TD3/res/uranus.jpg",
        "/home/t-0/Documents/TD3/res/neptune.jpg", "/home/t-0/Documents/TD3/res/lune.jpg"
    };

    glEnable(GL_TEXTURE_2D);
    for (const QString& file : textureFiles) {
        if (!img.load(file)) {
            qWarning("Failed to load texture: %s", qPrintable(file));
            continue;
        }
        img = img.convertToFormat(QImage::Format_RGBA8888);
        GLuint* texture = new GLuint;
        glGenTextures(1, texture);
        glBindTexture(GL_TEXTURE_2D, *texture);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, img.width(), img.height(), 0, GL_RGBA, GL_UNSIGNED_BYTE, img.bits());
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        m_Textures.push_back(texture);
        qDebug() << "Loaded texture:" << file;
    }
    
    // Initialiser les textures des planètes
    for (size_t i = 0; i < m_Planetes.size(); ++i) {
        if (i < m_Textures.size()) {
            m_Planetes[i]->texture_ = *m_Textures[i];
        } else {
            qWarning("Not enough textures for planets");
        }
    }

    for (int i=0; i<6500; i++) {
        m_Etoiles.push_back(new Star());
    }
}

// Fonction de redimensionnement
void MyGLWidget::resizeGL(int width, int height)
{
    // Definition du viewport (zone d'affichage)
    glViewport(0, 0, width, height);

    // Definition de la matrice de projection
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    if(width != 0)
        gluPerspective(45.0, static_cast<float>(width) / height, 0.1, 1000.0);

    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
}

// Fonction d'affichage
void MyGLWidget::paintGL()
{
    // Reinitialisation des tampons
    glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);

    // Definition de la position de la camera
    glLoadIdentity();

    // Animation de la caméra en rotation autour du centre
    float angle = m_TimeElapsed * - 0.2f; // Rotation progressive
    float radius = 100.0f; // Distance de la caméra
    float camX = radius * cos(angle * M_PI / 180.0);
    float camY = radius * sin(angle * M_PI / 180.0);
    float camZ = 50.0f; // Hauteur pour une meilleure vue

    gluLookAt(camX, camY, camZ, 0, 0, 0, 0, 0, 1);

    // Affichage des m_Planetes
    for (unsigned char i=0; i<m_Planetes.size(); i++) {
        m_Planetes[i]->Display(m_TimeElapsed);
    }

    float colortab[4] = {1.0f, 1.0f, 1.0f, 1.0f};
    glMaterialfv(GL_FRONT,GL_AMBIENT, colortab);
    // Affichage des m_Planetes

    for (unsigned short i=0; i<m_Etoiles.size(); i++) {
        m_Etoiles[i]->Display();
    }

}

// Fonction de gestion d'interactions clavier
void MyGLWidget::keyPressEvent(QKeyEvent * event)
{
    switch(event->key())
    {
        // Activation/Arret de l'animation
        case Qt::Key_Enter:
        {
            if(m_AnimationTimer.isActive())
                m_AnimationTimer.stop();
            else
                m_AnimationTimer.start();

            break;
        }
        // Cas par defaut
        default:
        {
            // Ignorer l'evenement
            event->ignore();
            return;
        }
    }

    // Acceptation de l'evenement et mise a jour de la scene
    event->accept();
    update();
}
