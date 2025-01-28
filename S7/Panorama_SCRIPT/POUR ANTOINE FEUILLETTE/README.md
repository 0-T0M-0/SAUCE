# projetPLS

This TD aims at implementing with VueJs an e-commerce suite for bikes with at least following features :
- [X] a catalog of bikes and accessories
- [ ] a cart
- [X] a contact form
A bike has at least following properties :
- [X] a name
- [X] a category
- [X] a description
- [X] a price

An accessory has at least following properties :
- [X] a name
- [X] a description
- [X] a price

Plus :

- [X] a header with the name of the e-shop
- [X] a nav-bar with the website menu, with all pages : home page, search page, contact page and others (optional, because this needs the router component).
- a main section (or page) with the catalog of bikes and accessories with the possibility to :
    - [X] filter the displayed bikes or accessories (by category, price, only accessories)
    - [ ] add a bike or an accessory to the cart
    - [ ] a cart section (or page) with the items added to cart, and the possibility to remove an item to the cart
- [X] a "Contact us" form section (or page)
- [X] a footer with classic copyright information

# Bonus

- ...

# Arborescence

e-commerce-bikes/
├── node_modules/          # Modules installés via npm
├── public/                # Fichiers accessibles publiquement (favicon, index.html, etc.)
│   ├── favicon.ico
│   └── index.html
├── src/                   # Code source de l'application
│   ├── assets/            # Images, fichiers CSS globaux, etc.
│   │   ├── images/
│   │   │   ├── logo.png
│   │   │   └── bikes/
│   │   └── styles/
│   │       ├── main.css
│   │       └── variables.css
│   ├── components/        # Composants Vue réutilisables
│   │   ├── Header.vue
│   │   ├── NavBar.vue
│   │   ├── Footer.vue
│   │   ├── ProductCard.vue   # Composant pour afficher un vélo ou un accessoire
│   │   └── CartItem.vue      # Composant pour afficher un élément du panier
│   ├── pages/             # Pages principales de l'application
│   │   ├── Home.vue
│   │   ├── Catalog.vue
│   │   ├── Cart.vue
│   │   └── ContactForm.vue
│   ├── router/            # Configuration des routes
│   │   └── index.js
│   ├── stores/            # Gestion de l'état global avec Pinia
│   │   └── cart.js
│   ├── data/              # Données statiques (par exemple, catalogue de produits)
│   │   └── catalog.js
│   ├── App.vue            # Composant racine
│   ├── main.js            # Point d'entrée principal de l'application
├── .gitignore             # Fichiers et dossiers à ignorer par Git
├── package.json           # Dépendances et scripts npm
├── package-lock.json      # Version exacte des dépendances
└── README.md              # Documentation du projet
