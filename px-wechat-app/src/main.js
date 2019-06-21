import Vue from 'vue'

// import Router from 'vue-router'
//
// Vue.use(Router)
import App from './App'
import flyioPlugin from './utils/apiUtil.js'

import '../static/weui/weui.css'
import './css/app.css'
import './css/loginForm.css'

// import index from './pages/test/index.vue'

Vue.use(flyioPlugin);//使用组件库

Vue.config.productionTip = false
App.mpType = 'app'

const app = new Vue(App)
app.$mount()

export default {
  // 这个字段走 app.json
  config: {
    // 页面前带有 ^ 符号的，会被编译成首页，其他页面可以选填，我们会自动把 webpack entry 里面的入口页面加进去
    pages: [
      'pages/test/main',
      'pages/courseMsg/main',
      'pages/manual/main',
      'pages/chat/main',
      'pages/userInfo/main',
      'pages/learn/main',
      'pages/login/main',
      'pages/takeCourses/main',
      '^pages/index/main',
    ],
    window: {
      backgroundTextStyle: 'light',
      navigationBarBackgroundColor: '#fff',
      navigationBarTitleText: 'WeChat',
      navigationBarTextStyle: 'black'
    },
    tabBar: {
      color: '#6f6f6f',
      selectedColor: '#18a3ff',
      backgroundColor: '#ffffff',
      borderStyle: 'black',
      list: [
        {
          pagePath: 'pages/takeCourses/main',
          iconPath: 'static/img/学习0.png',
          selectedIconPath: 'static/img/学习1.png',
          text: '学习'
        },
        {
          pagePath: 'pages/index/main',
          iconPath: 'static/img/课程0.png',
          selectedIconPath: 'static/img/课程1.png',
          text: '课程'
        },
        {
          pagePath: 'pages/login/main',
          iconPath: 'static/img/我的0.png',
          selectedIconPath: 'static/img/我的1.png',
          text: '我的'
        }
      ]
    },
    // routes: [
    //   {
    //     path: 'pages/test/main',
    //     name: ' index'
    //   },
    //   {
    //     path: 'pages/test/main',
    //     name: ' index'
    //   },
    // ]
  },
};
