#!/bin/bash

if [[ $# -ne 1 ]]; then
    echo "Usage : \`tri.sh REPERTOIRE_A_TRIER\`"
else
    readarray -d '' trouve < <(find "$1" -type f -name "*.jpg" -print0)

    for i in "${trouve[@]}"; do
        nom_og=$(basename "$i" | cut -d'.' -f1)
        
        jhead -n%Y%m%d-%H%M%S_"$nom_og" "$i"
    done
fi
