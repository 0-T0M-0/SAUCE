#include "alarmewidget.h"

#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    AlarmeWidget w;
    w.show();
    return a.exec();
}
