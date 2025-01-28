<!-- src/components/NavBar.vue -->
<template>
  <nav class="nav-bar">
    <ul>
      <li><router-link to="/">Home</router-link></li>
      <li><router-link to="/catalog">Catalog</router-link></li>
      <li><router-link to="/contact">Contact</router-link></li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: "NavBar",
};
</script>

<style scoped>
.nav-bar {
  background-color: var(--nav-bg-color, #555);
  padding: 0.5rem;
}

.nav-bar ul {
  list-style: none;
  display: flex;
  justify-content: center;
  padding: 0;
  margin: 0;
}

.nav-bar li {
  margin: 0 1rem;
}

.nav-bar a {
  color: var(--nav-link-color, white);
  text-decoration: none;
}

.nav-bar a:hover {
  text-decoration: underline;
}
</style>
