#!/bin/bash

if [[ $# -ne 1 ]]; then
    echo "Usage : \`infos-csv.sh FICHIER-CSV\`"
else
    while IFS=","
    do
        # sjjss
    done < <(tail -n +2 "$1")
fi
