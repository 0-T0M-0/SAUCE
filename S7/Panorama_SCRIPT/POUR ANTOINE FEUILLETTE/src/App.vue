<template>
  <div id="app" class="app-container">
    <Header />
    <router-view class="main-content" :cart-items="cartItems" @add-to-cart="addToCart" />
    <Footer />
  </div>
</template>

<script>
import Header from "@/components/ShopHeader.vue";
import Footer from "@/components/ShopFooter.vue";

export default {
  name: "App",
  components: {
    Header,
    Footer,
  },
  data() {
    return {
      cartItems: [
      ],
    };
  },
  methods: {
    addToCart(item) {
      this.cartItems.push(item);
    },
  },
};
</script>

<style src="@/assets/styles/main.css"></style>
