---
title: JavaScript
subtitle: TD 1
author:
- Tom Mafille
date: 27 novembre 2024
documentclass: article
geometry: margin=2cm
papersize: a4
linestretch: 1.2
fontsize: 12pt
linkcolor: blue
lang: fr-FR
header-includes:
- \usepackage{calrsfs}
- \usepackage{amsmath}
- \DeclareMathAlphabet{\pazocal}{OMS}{zplm}{m}{n}
---

# PARTIE 1

1. Aller dans le navigateur, `inspecter`, `console` pour voir le résultat.

    ``` javascript
    $( document ).ready(function() {
        console.log('JAJ');
    });
    ```

# PARTIE 2

1. Définir les variables :

    ```javascript
    $(document).ready(function() {
        // variables
        var $ulElement = $('ul');
        var $addButton = $('#addButton');

        // pour visualiser
        console.log($ulElement);
        console.log($addButton);
});
```

# PARTIE 3

1. Event bouton cliqué :

    ```javascript
    $(document).ready(function() {
        var $ulElement = $('ul');
        var $addButton = $('button');

        $addButton.on('click', function() {
        console.log('CLICK');
        });
    });
    ```
# PARTIE 4

1. Print la valeur de l'iput :

    ```javascript
    $(document).ready(function() {
        var $ulElement = $('ul');
        var $addButton = $('button');
        var $inputElement = $('#item'); // # <=> by id

        $addButton.on('click', function() {
            var inputValue = $inputElement.val();
            console.log('valeur de la sauce :', inputValue)
        });
    });
    ```
# PARTIE 5

1. Créer un élement `li` avec cette valeur et l'ajouter à l'élement `ul` :

     ```javascript
     $(document).ready(function() {
        var $ulElement = $('ul');
        var $addButton = $('button');
        var $inputElement = $('#item');

        $addButton.on('click', function() {
            var inputValue = $inputElement.val();

            if (inputValue.trim() !== '') { //vérifier que c'est non NUL (comme Antoine FEUILLETTE)
                var $liElement = $('<li></li>');
                $liElement.text(inputValue);
                $ulElement.append($liElement);
                $inputElement.val('');
            } else {
                console.log('ya rien.');
            }
        });
    });
    ```

# PARTIE 6

1. Ajout d'un bouton `Delete` :

     ```javascript
     $(document).ready(function() {
        var $ulElement = $('ul');
        var $addButton = $('button');
        var $inputElement = $('#item');

        $addButton.on('click', function() {
            var inputValue = $inputElement.val();

            if (inputValue.trim() !== '') { //vérifier que c'est non NUL (comme Antoine FEUILLETTE)
                var $liElement = $('<li></li>');
                $liElement.text(inputValue);
                $ulElement.append($liElement);
                $inputElement.val('');

                // Bouton DELETE
                var $deleteButton = $('<button>Delete</button>');
                // Ajout du bouton dans le <li>
                $liElement.append($deleteButton);

                // Ajout du bouton dans le <ul>
                $ulElement.append($liElement);
                // Supp
                $inputElement.val('');
            } else {
                console.log('ya rien.');
            }
        });
    });
    ```
# PARTIE 7

1. Suppression lorsqu'on presse sur le bouton `Delete` :

     ```javascript
     $(document).ready(function() {
        var $ulElement = $('ul');
        var $addButton = $('button');
        var $inputElement = $('#item');

        $addButton.on('click', function() {
            var inputValue = $inputElement.val();

            if (inputValue.trim() !== '') { //vérifier que c'est non NUL (comme Antoine FEUILLETTE)
                var $liElement = $('<li></li>');
                $liElement.text(inputValue);
                $ulElement.append($liElement);
                $inputElement.val('');

                // Bouton DELETE
                var $deleteButton = $('<button>Delete</button>');
                $deleteButton.on('click', function() {
                    $liElement.remove(); //Quand click -> suppression
                });

                // Ajout du bouton dans le <li>
                $liElement.append($deleteButton);

                // Ajout du bouton dans le <ul>
                $ulElement.append($liElement);
                // Supp
                $inputElement.val('');
            } else {
                console.log('ya rien.');
            }
        });
    });
    ```
