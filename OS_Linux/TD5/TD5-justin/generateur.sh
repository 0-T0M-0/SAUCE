#!/bin/bash

if [[ $# -ne 2 ]]; then
    echo "Usage : \`generateur.sh DOSSIER_IMAGES DESTINATION.html\`"
else
    if [[ ! -d "$1"/thumbnails ]]; then
        mkdir "$1"/thumbnails
    fi

    readarray -d '' trouve < <(find "$1" -type f -name "*.jpg" -print0)

    # Génération des miniatures
    #for i in "${trouve[@]}"; do
    #    jhead -st "thumbnails/&i" "$i"
    #done

    # Sections des images
    images_html=$(for i in "${trouve[@]}"; do
        echo "<p><a href=\"$i\"><img src=\"$i\" style=\"width:200px\"></a></p>"
    done)

    # Génération de la page HTML
    echo "<!DOCTYPE html>
<html>
    <head>
        <meta charset=\"utf-8\"
        <title>Galerie du $(date)</title>
    </head>

    <body>
        $images_html
    </body>
</html>" > "$2"
fi
