import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import DefaultLayout from '../layouts/DefaultLayout'
import AuthLayout from '../layouts/AuthLayout'

import Login from '../components/auth/Login'
import Registration from '../components/auth/Registration'

const routes =
  [
    {
      path: '/',
      name: 'DefaultLayout',
      components: {
        DefaultLayout: DefaultLayout
      },
    },
    {
      path: '/auth',
      name: "AuthLayout",
      components:
      {
        AuthLayout: AuthLayout
      },
      children: [
        {
          path: 'login',
          components:
          {
            Login: Login
          }
        },
        {
          path: 'registration',
          components:
          {
            Registration: Registration
          }
        }
      ]
    }

  ]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
