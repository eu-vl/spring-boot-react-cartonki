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
      redirect: "/dashboard",
      components: {
        DefaultLayout: DefaultLayout
      },
      children: [
        {
          path: '/dashboard',
          component: Home
        }
      ],
      beforeEnter: (to, from, next) => {
        const user = localStorage.getItem('user');
        if (user != null) {
          next()
        }
        else next({ path: 'auth' })
      },
    },
    {
      path: '/auth',
      name: "AuthLayout",
      redirect: "/auth/login",
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
          },
          beforeEnter: (to, from, next) => {
            const user = localStorage.getItem('user');
            if (user == null) {
              next()
            }
            else next({ path: '/' })
          }
        },
        {
          path: 'registration',
          components:
          {
            Registration: Registration
          },
          beforeEnter: (to, from, next) => {
            const user = localStorage.getItem('user');
            if (user == null) {
              next()
            }
            else next({ path: '/' })
          },
        }
      ]
    }

  ]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
