<template>
  <div>
    <button open-type="getUserInfo" @getuserinfo="bindGetUserInfo" @click="getUserInfo1">获取权限</button>
  </div>
</template>

<script>
  export default {
    onload() {
      // 这个时候 不行，可能与生命周期有关系
      // this.getSetting()
    },
    mounted() {
      // 一进来看看用户是否授权过
      this.getSetting()
    },
    methods: {
      getSetting() {
        wx.getSetting({
          success: function (res) {
            if (res.authSetting['scope.userInfo']) {
              wx.getUserInfo({
                success: function (res) {
                  console.log(res.userInfo)
                  //用户已经授权过
                  console.log('用户已经授权过')
                }
              })
            } else {
              console.log('用户还未授权过')
            }
          }
        })

      },
      getUserInfo1() {
        console.log('click事件首先触发')
        // 判断小程序的API，回调，参数，组件等是否在当前版本可用。  为false 提醒用户升级微信版本
        // console.log(wx.canIUse('button.open-type.getUserInfo'))
        if (wx.canIUse('button.open-type.getUserInfo')) {
          // 用户版本可用
        } else {
          console.log('请升级微信版本')
        }
      },
      bindGetUserInfo(e) {
         console.log(e.mp.detail.rawData);
         console.log('事件触发');
         this.openAlert();
        // if (e.mp.detail.rawData) {
        //   //用户按了允许授权按钮
        //   console.log('用户按了允许授权按钮')
        // } else {
        //   //用户按了拒绝按钮
        //   console.log('用户按了拒绝按钮')
        // }
      },
      openAlert(e) {
        wx.showModal({
          content: '弹窗内容，告知当前状态、信息和解决方法，描述文字尽量控制在三行内',
          showCancel: false,
          success: function (res) {
            if (res.confirm) {
              console.log('用户点击确定')
            }
          }
        })
      }
    }
  }
</script>

<style scoped>
  img{
    width: 100%;
    height: 100%;
  }
</style>
