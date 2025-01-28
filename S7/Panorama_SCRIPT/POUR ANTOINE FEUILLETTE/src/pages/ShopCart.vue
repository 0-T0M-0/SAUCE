<template>
  <div class="shop-cart">
    <h1>Your Shopping Cart</h1>
    <CartItem v-for="item in cartItems" :key="item.id" :item="item" />
    <div class="total-price">
      Total: ${{ totalPrice }}
    </div>
  </div>
</template>

<script>
import CartItem from "@/components/CartItem.vue";

export default {
  name: "ShopCart",
  components: {
    CartItem,
  },
  props: {
    cartItems: {
      type: Array,
      required: true,
    },
  },
  computed: {
    totalPrice() {
      return this.cartItems.reduce((sum, item) => sum + item.price, 0);
    },
  },
};
</script>

<style scoped>
.shop-cart {
  padding: 1rem;
}

.total-price {
  margin-top: 1rem;
  font-size: 1.5rem;
  font-weight: bold;
}
</style>
