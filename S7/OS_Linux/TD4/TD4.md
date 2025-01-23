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

1. Script qui compte le nombre de fichiers d'une extension donnée dans le répertoire courant :

   ```bash
    #!/bin/bash

    if [ $# -ne 1 ]; then
      echo "Usage: $0 <extension>"
      exit 1
    fi

    extension=$1
    count=$(find . -maxdepth 1 -type f -name "*.$extension" | wc -l)

    echo "Nombre de fichiers avec l'extension .$extension dans le répertoire courant : $count"
    ```
   
2. Script modifié pour parcourir récursivement les sous-dossiers :

    ```bash
    #!/bin/bash

    if [ $# -ne 1 ]; then
      echo "Usage: $0 <extension>"
      exit 1
    fi

    extension=$1
    count=$(find . -type f -name "*.$extension" | wc -l)

    echo "Nombre de fichiers avec l'extension .$extension (dans tous les sous-dossiers) : $count"
    ```

3. Script extension qui ajoute une extension donnée à tous les fichiers passés en paramètres :

    ```bash
    #!/bin/bash

    if [ $# -lt 2 ]; then
      echo "Usage: $0 <extension> <file1> <file2> ..."
      exit 1
    fi

    extension=$1
    shift

    for file in "$@"; do
      if [ -f "$file" ]; then
        new_file="${file}.$extension"
        if [ -e "$new_file" ]; then
          echo "Erreur : '$new_file' existe déjà, saut du fichier '$file'."
        else
          mv "$file" "$new_file"
          echo "Renommé : '$file' -> '$new_file'"
        fi
      else
        echo "Erreur : '$file' n'existe pas."
      fi
    done
    ```

4. Script regroupe qui regroupe les fichiers ayant la même extension dans un même répertoire :

    ```bash
    #!/bin/bash

    if [ $# -eq 0 ]; then
      echo "Usage: $0 <file1> <file2> ..."
      exit 1
    fi

    for file in "$@"; do
      if [ -f "$file" ]; then
        extension="${file##*.}"
        dir="./$extension"

        if [ ! -d "$dir" ]; then
          mkdir "$dir"
          echo "Créé : dossier '$dir'"
        fi
    
        mv "$file" "$dir/"
        echo "Déplacé : '$file' -> '$dir/'"
      else
        echo "Erreur : '$file' n'existe pas."
      fi
    done
    ```

    

    


