import { createRouter, createWebHistory } from 'vue-router';
import LoginView from '../views/LoginView.vue';

const routes = [
  
  {
    path: '/:catchAll(.*)',
    component: () => import('../views/NotFoundView.vue')
  },
  {
    path: '/',
    name: 'home',
    component: LoginView
  },
  // otras rutas...
  {
    path: '/register',
    name: 'register',
    component: () => import('../views/RegisterView.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },

  {
    path: '/dashboard',
    name: 'dashboard',
    component: () => import('../views/DashboardView.vue')
  },
  {
    path: '/mistickets',
    name: 'mistickets',
    component: () => import('../views/MyTicketsView.vue')
  },
  {
    path: '/crearticket',
    name: 'crearticket',
    component: () => import('../views/CreateTicketView.vue')
  },
  {
    path: '/micuenta',
    name: 'micuenta',
    component: () => import('../views/MyAccountView.vue')
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
