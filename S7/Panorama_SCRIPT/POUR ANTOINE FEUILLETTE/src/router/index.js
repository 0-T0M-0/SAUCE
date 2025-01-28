import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/ShopHome.vue';
import Catalog from '@/pages/ShopCatalog.vue';
import ContactForm from '@/pages/ContactForm.vue';
import ShopCart from '@/pages/ShopCart.vue';

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/catalog', name: 'Catalog', component: Catalog },
  { path: '/contact', name: 'Contact', component: ContactForm },
  { path: '/cart', name: 'Cart', component: ShopCart, props: true },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
