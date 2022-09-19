import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      {
        path: '',
        component: () => import('pages/IndexPage.vue'),
      },
      {
        path: '/library',
        component: () => import('pages/LibraryPage.vue'),
      },
      {
        path: '/sign-in',
        component: () => import('pages/SignInPage.vue'),
      },
      {
        path: '/register',
        component: () => import('pages/RegisterPage.vue'),
      },
      {
        path: '/account',
        component: () => import('pages/AccountPage.vue'),
      },
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
];

export default routes;
