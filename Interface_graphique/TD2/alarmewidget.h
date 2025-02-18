#ifndef ALARMEWIDGET_H
#define ALARMEWIDGET_H

#include <QMainWindow>

class AlarmeWidget : public QMainWindow
{
    Q_OBJECT

public:
    AlarmeWidget(QWidget *parent = nullptr);
    ~AlarmeWidget();

    void changerTexte(void);
};
#endif // ALARMEWIDGET_H
