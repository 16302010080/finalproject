
import App from './index'
import fly from '../../utils/request'

import Vue from 'vue'
Vue.prototype.$fly = fly


const app = new Vue(App)
app.$mount()
export default {
  config: {
    navigationBarTitleText: '课程简介'
  }
}
