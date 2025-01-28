<template>
  <div class="catalog-container">
    <h1>Our Catalog</h1>
    <p>Browse through our collection of bikes and accessories.</p>

    <!-- Section des filtres -->
    <div class="filters">
      <label for="filter-type">Filtrer par type:</label>
      <select id="filter-type" v-model="selectedType" @change="updateCategoryOptions">
        <option value="">Tout</option>
        <option value="velo">Vélos</option>
        <option value="accessory">Accessoires</option>
      </select>

      <label for="filter-category">Filtrer par catégorie:</label>
      <select id="filter-category" v-model="selectedCategory" @change="applyFilters">
        <option value="">Toutes catégories</option>
        <option v-for="category in categoryOptions" :key="category" :value="category">
          {{ category }}
        </option>
      </select>

      <label for="filter-price">Filtrer par prix:</label>
      <input
        type="number"
        id="filter-price"
        v-model.number="maxPrice"
        @input="validatePrice"
        @change="applyFilters"
        placeholder="Prix maximum"
        min="0"
      />
    </div>

    <h2>Vélos</h2>
    <swiper :slides-per-view="3" space-between="20" navigation>
      <swiper-slide
        v-for="velo in filteredVelos"
        :key="velo.nom"
        class="product-card"
      >
        <h3>{{ velo.nom }}</h3>
        <p>Catégorie: {{ velo.categorie }}</p>
        <p>Description: {{ velo.description }}</p>
        <p>Prix: {{ velo.prix }} euros</p>
        <button @click="addToCart(velo)">Ajouter au panier</button>
      </swiper-slide>
    </swiper>

    <h2>Accessoires</h2>
    <swiper :slides-per-view="3" space-between="20" navigation>
      <swiper-slide
        v-for="accessorie in filteredAccessories"
        :key="accessorie.nom"
        class="product-card"
      >
        <h3>{{ accessorie.nom }}</h3>
        <p>Catégorie: {{ accessorie.categorie }}</p>
        <p>Description: {{ accessorie.description }}</p>
        <p>Prix: {{ accessorie.prix }} euros</p>
        <button @click="addToCart(accessorie)">Ajouter au panier</button>
      </swiper-slide>
    </swiper>
  </div>
</template>


<script>
import { Swiper, SwiperSlide } from "swiper/vue";
import "swiper/css"; // Importation des styles de base de Swiper
import "swiper/css/navigation"; // Importation des styles pour la navigation
import SwiperCore, { Navigation } from "swiper"; // Import du module Navigation
import { velos, accessories } from "@/data/catalog.js";
SwiperCore.use([Navigation]);
export default {
  name: "ShopCatalog",
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      velos: [], // Liste réactive pour les vélos
      accessories: [], // Liste réactive pour les accessoires
      selectedType: "",
      selectedCategory: "",
      maxPrice: null,
      categoryOptions: [],
      filteredVelos: [],
      filteredAccessories: [],
    };
  },

  methods: {
    addItemToCatalog(item) {
      if (item.type === "velo") {
        this.velos.push(item);
      } else if (item.type === "accessory") {
        this.accessories.push(item);
      }
      this.applyFilters(); // Mettre à jour les listes filtrées
    },

    addToCart(item) {
      const newitem = { id: 1, name: item.name, price: item.price };
      this.$emit('add-to-cart', newitem);
      console.log(`${item.nom} ajouté au panier`);
    },
    validatePrice() {
      // Empêcher les prix négatifs
      if (this.maxPrice < 0) {
        this.maxPrice = 0; // Remettre à 0 si une valeur négative est saisie
      }
    },
    cleanPrice(price) {
      // Extraire la valeur numérique du prix (exemple : "1000€" devient 1000)
      return parseFloat(price.toString().replace(/[^\d.-]/g, ""));
    },
    applyFilters() {
      const maxPrice = this.maxPrice !== null && this.maxPrice !== '' ? this.maxPrice : Infinity;

      // Filtrer les vélos
      this.filteredVelos = this.velos.filter((velo) => {
        const veloPrice = this.cleanPrice(velo.prix); // Nettoyer le prix
        const matchesCategory =
          !this.selectedCategory || velo.categorie === this.selectedCategory;
        const matchesPrice = veloPrice <= maxPrice;

        return matchesCategory && matchesPrice;
      });

      // Filtrer les accessoires
      this.filteredAccessories = this.accessories.filter((accessory) => {
        const accessoryPrice = this.cleanPrice(accessory.prix); // Nettoyer le prix
        const matchesCategory =
          !this.selectedCategory || accessory.categorie === this.selectedCategory;
        const matchesPrice = accessoryPrice <= maxPrice;

        return matchesCategory && matchesPrice;
      });

      // Appliquer le type (velo ou accessory)
      if (this.selectedType === "velo") {
        this.filteredAccessories = []; // Vider les accessoires
      } else if (this.selectedType === "accessory") {
        this.filteredVelos = []; // Vider les vélos
      }
    },
    updateCategoryOptions() {
      // Mettre à jour les catégories dynamiques en fonction du type sélectionné
      if (this.selectedType === "velo") {
        this.categoryOptions = [
          "Vélo de course",
          "Vélo de ville",
          "VTT",
        ];
      } else if (this.selectedType === "accessory") {
        this.categoryOptions = [
          "Gants de vélo",
          "Casque de vélo",
          "Sacoches de vélo",
        ];
      } else {
        this.categoryOptions = []; // Toutes catégories disponibles
      }

      // Réinitialiser les filtres
      this.selectedCategory = "";
      this.applyFilters();
    },
  },
  mounted() {
    // Charger les données initiales
    this.velos = [...velos];
    this.accessories = [...accessories];

    // Initialiser les listes filtrées
    this.filteredVelos = this.velos;
    this.filteredAccessories = this.accessories;
  },

  swiperModules: [Navigation], // Activer le module Navigation de Swiper
};
</script>

