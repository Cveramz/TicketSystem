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
    path: '/admin/tickets',
    name: 'admintickets',
    component: () => import('../views/ADMIN-Views/ADMINTicketsView.vue')
  },
  {
    path: '/admin/dashboard',
    name: 'admindashboard',
    component: () => import('../views/ADMIN-Views/ADMINDashboardView.vue')
  },
  {
    path: '/admin/',
    name: 'adminhome',
    component: () => import('../views/ADMIN-Views/ADMINDashboardView.vue')
  },
  {
    path: '/admin/eliminarTickets',
    name: 'admineliminartickets',
    component: () => import('../views/ADMIN-Views/ADMINDeleteTicketsView.vue')
  },
  {
    path: '/admin/cuentas',
    name: 'admincuentas',
    component: () => import('../views/ADMIN-Views/ADMINCuentasView.vue')
  },
  {
    path: '/admin/responderticket',
    name: 'adminresponderticket',
    component: () => import('../views/ADMIN-Views/ADMINReplyTicket.vue')
  },
  {
    path: '/admin/eliminarcuentas',
    name: 'admineliminarcuentas',
    component: () => import('../views/ADMIN-Views/ADMINDeleteAccountsView.vue')
  },
  {
    path: '/admin/administrarcuentas',
    name: 'adminadministrarcuentas',
    component: () => import('../views/ADMIN-Views/ADMINAdminAccountsView.vue')
  },
  {
    path: '/analista',
    name: 'analista',
    component: () => import('../views/ANALISTA-Views/ANALISTADashboardView.vue')
  },
  {
    path: '/analista/dashboard',
    name: 'analistadashboard',
    component: () => import('../views/ANALISTA-Views/ANALISTADashboardView.vue')
  },
  {
    path: '/analista/tickets',
    name: 'analistatickets',
    component: () => import('../views/ANALISTA-Views/ANALISTATicketsView.vue')
  },
  {
    path: '/analista/responderticket',
    name: 'analistaresponderticket',
    component: () => import('../views/ANALISTA-Views/ANALISTAReplyTicketView.vue')
  },
  {
    path: '/invitado/',
    name: 'invitado',
    component: () => import('../views/INVITADO-Views/CreateTicketView.vue')
  },
  {
    path: '/crearticket',
    name: 'crearticket',
    component: () => import('../views/CreateTicketView.vue')
  },
  {
    path: '/ticketstatus',
    name: 'ticketstatus',
    component: () => import('../views/TicketStatusView.vue')
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
