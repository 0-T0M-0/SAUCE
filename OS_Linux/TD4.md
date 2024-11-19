---
title: TD3 Regex
subtitle: OS Linux
author: Tom MAFILLE
geometry: margin=2cm
lang: fr-FR
---

# Partie 1 - Prise en main

1. Afficher Bonjour + le nom d'utilisateur :

    ```bash
    #!bin/sh
    echo "Bonjour $USER"
    ```

2. Le modifier pour afficher des choses différentes en fonction de l'heure :

    ```bash
    #!bin/sh
    HEURE=$(date +%H)
    if [ $HEURE -lt 12 ]; then
        echo "Bonjour $USER"
    elif [ $HEURE -lt 19 ]; then
        echo "Bonsoir $USER"
    else
        echo "Bon après-midi $USER"
    fi
    ```

# Partie 2 - Fichiers

1. Indique si le fichier passé en argument est normal, dossier ou lien:

    ```bash
    #!bin/sh
    if [ -e $1 ]; then
        if [ -f $1 ]; then
                echo "$1 est un fichier normal"
        elif [ -d $1 ]; then
                echo "$1 est un dossier"
        elif [ -f $1 ]; then
                echo "$1 est un lien"
        fi
    else
        echo "$1 n'existe pas"
    fi
    ```

2. Indique si une phrase existe dans un fichier :

    ```bash
    #!bin/sh
    if grep -q $2 $1; then
        echo "$2 existe dans $1"
    else
        echo "$2 n'existe pas dans $1"
    fi
    ```
3. Un script qui affiche les lignes n1 à n2 d'un fichier :

    ```bash
    #!bin/sh
    sed -n "$1,$2p" $3
    ```

4. Script qui échange le contenu de deux fichiers :

    ```bash
    #!/bin/sh
    N=$(grep  -c '' $1)
    n=$(sed -n "1,${N}p" $1)
    M=$(grep -c "" $2)
    n=$(sed -n "1,${N}p" $2)

    > "$1"
    > "$2"

    nano "$n" > $2
    nano "$m" > $1
    ```

# Partie 3 - Pour aller plus loin
