#include "alarmewidget.h"
#include "ui_alarmewidget.h"
#include <QMessageBox>
#include <QTime>
#include <QTimer>

AlarmeWidget::AlarmeWidget(QWidget *parent)
    : QWidget(parent)
    , ui(new Ui::AlarmeWidget)
    , timer(new QTimer(this))
{
    ui->setupUi(this);

    // Initialiser le label avec l'heure courante
    QTime currentTime = QTime::currentTime();
    ui->heure->setText(currentTime.toString("hh:mm:ss"));

    // Configurer le timer pour mettre à jour l'heure chaque seconde
    connect(timer, &QTimer::timeout, this, &AlarmeWidget::updateTime);
    timer->start(1000); // 1000 ms = 1 seconde
}

AlarmeWidget::~AlarmeWidget()
{
    delete ui;
}

void AlarmeWidget::on_pushButton_clicked()
{
    // ajouter une boite de message dans le slot pour verifier si ça fonctionne
    QMessageBox::information(this, "Alarme", "Alarme activée");
}

void AlarmeWidget::updateTime()
{
    QTime currentTime = QTime::currentTime();
    ui->heure->setText(currentTime.toString("hh:mm:ss"));
}
