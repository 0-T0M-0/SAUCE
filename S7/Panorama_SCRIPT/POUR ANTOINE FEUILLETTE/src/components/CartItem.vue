<template>
  <div class="cart-item">
    <h2>{{ item.name }}</h2>
    <p>Price: ${{ item.price }}</p>
  </div>
</template>

<script>
export default {
  name: "CartItem",
  props: {
    item: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>
.cart-item {
  border: 1px solid #ccc;
  padding: 1rem;
  margin-bottom: 1rem;
}
</style>
