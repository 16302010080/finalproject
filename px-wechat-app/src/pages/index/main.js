
import fly from '../../utils/request'
import Vue from 'vue'
// import Router from 'vue-router'
// Vue.use(Router)

// Vue.use(Router)
Vue.prototype.$fly = fly
// Vue.prototype.$router=router

import App from './index'

const app = new Vue(App);
app.$mount();

//
// export default new Router({
//   routes: [
//     {
//       path: '../test/:courseID',
//       name: 'index'
//     },
    // {
    //   path: '/first',
    //   name: 'First',
    //   component: First
    // },
    // {
    //   path: '/hello',
    //   name: 'hello',
    //   component: HelloWorld
    // },
    // {
    //   path: '/list-detail/:id/:title',
    //   name: 'ListDetail',
    //   component: ListDetail
    // },

//   ]
// })
