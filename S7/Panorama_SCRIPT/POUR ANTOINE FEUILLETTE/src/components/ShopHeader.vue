<!-- src/components/Header.vue -->
<template>
  <header class="header">
    <div class="container">
      <h1 class="shop-name">BikeStore</h1>
      <nav class="nav-bar">
        <ul class="nav-menu">
          <li class="nav-item">
            <router-link to="/">Home</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/cart">Panier</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/contact">Contact</router-link>
          </li>
        </ul>
      </nav>
    </div>
  </header>
</template>

<script>
export default {
  name: "ShopHeader",
};
</script>
