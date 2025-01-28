<!-- src/components/Footer.vue -->
<template>
  <footer class="footer">
    <p>&copy; 2025 BikeStore. All rights reserved.</p>
  </footer>
</template>

<script>
export default {
  name: "ShopFooter",
};
</script>

<style scoped>
.footer {
  background-color: var(--footer-bg-color, #333);
  color: var(--footer-text-color, white);
  text-align: center;
  padding: 1rem;
  margin-top: auto;
}
</style>
