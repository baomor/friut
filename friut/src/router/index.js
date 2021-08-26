import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Pie from "../views/pie"
import Table from "../views/Table"
import Edit from "@/views/Edit";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/pie',
    name: 'Pie',
    component: Pie
  },
  {
    path: '/table',
    name: 'Table',
    component: Table

  },
  {
    path: '/edit',
    name: 'Edit',
    component: Edit
  }
]

const router = new VueRouter({
  routes
})

export default router
