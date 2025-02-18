#ifndef ALARMEWIDGET_H
#define ALARMEWIDGET_H

#include <QWidget>
#include <QTimer>

QT_BEGIN_NAMESPACE
namespace Ui {
class AlarmeWidget;
}
QT_END_NAMESPACE

class AlarmeWidget : public QWidget
{
    Q_OBJECT

public:
    AlarmeWidget(QWidget *parent = nullptr);
    ~AlarmeWidget();

private slots:
    void on_pushButton_clicked();
    void updateTime();

private:
    Ui::AlarmeWidget *ui;
    QTimer *timer;
};

#endif // ALARMEWIDGET_H
