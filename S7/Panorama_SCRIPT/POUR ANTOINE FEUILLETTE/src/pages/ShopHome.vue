<template>
  <div class="home-container">
    <h1>Welcome to BikeStore</h1>
    <p>Explore our wide range of bikes and accessories.</p>
    <Catalog class="catalog-section" />
  </div>
</template>

<script>
import Catalog from './ShopCatalog.vue';

export default {
  name: "ShopHome",
  components: {
    Catalog
  }
};
</script>

