---
title: TD5 Scripts
subtitle: OS Linux
author: Tom MAFILLE
geometry: margin=2cm
lang: fr-FR
---

# Partie 1 - Tri de fichiers

1. Script qui trie des fichiers par date de création dans un répertoire donné :

    ```bash
    #!/bin/bash

    if ! command -v jhead &>/dev/null; then
        echo "Erreur : La commande 'jhead' n'est pas installée. Veuillez l'installer avant de continuer."
        exit 1
    fi

    if [ $# -ne 1 ]; then
        echo "Usage : $0 <répertoire>"
        exit 1
    fi

    directory=$1

    if [ ! -d "$directory" ]; then
        echo "Erreur : '$directory' n'est pas un répertoire valide."
        exit 1
    fi

    cd "$directory" || exit 1

    for file in *.jpg *.jpeg *.JPG *.JPEG; do
        if [ -f "$file" ]; then
            creation_date=$(jhead "$file" 2>/dev/null | grep "Date/Time" | awk '{print $3}' | tr ':' '-')
        if [ -n "$creation_date" ]; then
            new_name="${creation_date}_${file}"
            mv "$file" "$new_name"
            echo "Renommé : $file -> $new_name"
        else
            echo "Impossible de récupérer la date pour '$file'."
        fi
    fi
    done
    ```

# Partie 1 - Générateur de galeries

2. Générer une galerie HTML avec miniatures et liens vers les images :

    ```bash
    #!/bin/bash

    if ! command -v convert &>/dev/null; then
        echo "Erreur : La commande 'convert' (ImageMagick) n'est pas installée. Veuillez l'installer."
        exit 1
    fi

    if [ $# -ne 2 ]; then
        echo "Usage : $0 <répertoire images> <fichier HTML>"
        exit 1
    fi

    image_dir=$1
    html_file=$2

    if [ ! -d "$image_dir" ]; then
        echo "Erreur : '$image_dir' n'est pas un répertoire valide."
        exit 1
    fi

    # Démarrage du fichier HTML
    cat <<EOF > "$html_file"
    <!DOCTYPE html>
    <html lang="fr">
    <head>
        <meta charset="UTF-8">
        <title>Galerie d'images</title>
        <style>
            body { font-family: Arial, sans-serif; text-align: center; }
            img { margin: 10px; border: 1px solid #ccc; max-width: 200px; max-height: 200px; }
            a { text-decoration: none; color: black; }
        </style>
    </head>
    <body>
    <h1>Galerie d'images</h1>
EOF

    # Génération des miniatures et ajout au HTML
    for img in "$image_dir"/*.{jpg,jpeg,png}; do
        [ -f "$img" ] || continue
        base_name=$(basename "$img")
        thumb_name="thumb_$base_name"

        # Crée une miniature
        convert "$img" -resize 200x200 "$image_dir/$thumb_name"

        # Ajoute à la galerie
        echo "<a href=\"$img\"><img src=\"$image_dir/$thumb_name\" alt=\"$base_name\"></a>" >> "$html_file"
    done

    # Fin du fichier HTML
    cat <<EOF >> "$html_file"
    </body>
    </html>
EOF

    echo "Galerie générée dans '$html_file'."
    ```

# Partie 3 - Extraction d'informations

1. Rechercher des produits alimentaires avec des taux d'éléments nutritionnels supérieurs ou égaux à une valeur donné :

    ```bash
    #!/bin/bash

    if [ $# -ne 2 ]; then
        echo "Usage : $0 <élément> <valeur>"
        exit 1
    fi

    element=$1
    value=$2
    file="nutrition.csv"  # Nom du fichier CSV contenant les données

    if [ ! -f "$file" ]; then
        echo "Erreur : Fichier '$file' introuvable."
        exit 1
    fi

    # Extraction des colonnes pertinentes
    header=$(head -1 "$file")
    column=$(echo "$header" | tr ';' '\n' | grep -n -i "$element" | cut -d: -f1)

    if [ -z "$column" ]; then
        echo "Erreur : L'élément '$element' n'existe pas dans le fichier."
        exit 1
    fi

    # Filtrage des résultats
    awk -F';' -v col="$column" -v val="$value" 'NR == 1 || $col >= val { print }' "$file"
    ```
