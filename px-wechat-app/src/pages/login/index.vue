<template>
  <div class="loginBody">
    <div class="top">
      <div class="topTop" :wx-if="userInfo.nickName!==undefined">
        <div class="infoText">
          <span style="font-size: 30px">{{userInfo.nickName}}</span>
        </div>
        <div class="loginIcon">
          <img class="infoImg" v-if="userInfo.avatarUrl" :src="userInfo.avatarUrl" />
        </div>
      </div>

      <div class="topTop" :wx-if="userInfo.nickName===undefined">
        <div class="infoText">
          <span class="notLogin">你还没有登录哟！！</span>
        </div>
        <div class="loginIcon">
          <button open-type="getUserInfo"  @getuserinfo="bindGetUserInfo">登录</button>
        </div>
      </div>
    </div>

    <div class="bottom">
      <div class="book">
        <button class="weui-btn" type="default" @click="goToManual"><span class="btText"><img class="iconImg" src="/static/img/帮助手册.png"/>学员手册</span> <span class="icon"> > </span></button>
      </div>
      <div class="activity">
        <button class="weui-btn" type="default" @click="favorite()" ><span class="btText">
         <img  class="iconImg" src="/static/img/收藏.png"/>我的收藏</span> <span class="icon"> > </span>
        </button>
    </div>
      <div class="info">
        <button class="weui-btn" type="default" @click="goToUserInfo"><span class="btText"><img  class="iconImg" src="/static/img/笔记.png"/>个人信息</span> <span class="icon"> > </span></button>
      </div>
    </div>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        id:'',
        userName: '',
        nickName: '',
        password: '',
        wechat:'',
        mail:'',
        gender:'',
        userInfo: {},
        inputval: '',
        tokenCourses:[],
        courses:[],
        mark:0,

      }
    },
    methods: {
      getUserInfo () {
        // 调用登录接口
        wx.login({
          success: () => {
            wx.getUserInfo({
              success: (res) => {
                this.userInfo = res.userInfo;
                console.log(this.userInfo.nickName)
              }
            })
          }
        })
      },
      bindGetUserInfo (e) {
        this.userInfo=e.mp.detail.userInfo;
      },
      bindViewTap() {
        const url = "../login/main";
        wx.navigateTo({ url });
      },
      login() {
        console.log(this.userInfo);
        wx.getUserInfo({
          success :(res)=>{
            console.log(1)
            this.userInfo = res.userInfo;
          },
          fail (res){
            console.log(res)
          }
        });
      },
      favorite(){
        const url = '../courseMsg/main';
         wx.navigateTo({ url })
 //       this.$fly.post( 'http://localhost:8084/home/listCollectCourse',{"studentNickName":this.userInfo.nickName}).then(res => {
//          console.log(this.userInfo.nickName+res);
//          this.$fly.get( 'http://localhost:8084/home/listCollectCourse?studentID='+5).then(res => {
//            console.log(res);
//          })
//            .catch(error =>{
//              console.log(error);
//              console.log('该课程不存在');
//            });
 //       });
//        console.log("收藏课程")
      },
      clickHandle (msg, ev) {
        console.log('clickHandle:', msg, ev)
      },
      goToUserInfo(){
        const url = '../userInfo/main';
        wx.navigateTo({ url })
      },
      goToManual(){
        const url = '../manual/main';
        wx.navigateTo({ url })
      },
    },
    created () {
        this.nickName='';
      // 调用应用实例的方法获取全局数据
      this.getUserInfo();
      this.$http.authorList().then(function (res) {
        console.log(res)
      });
      this.id = 3;//路由参数
    },
  }
</script>

<style>
  .note{
    text-align: center;
    padding-top: 20rpx;
  }
  .collect{
    text-align: center;
    padding-top: 20rpx;
  }
  .btText{
    display: inline;
    vertical-align:middle;
  }
  .infoImg{
    width: 80px;
    height: 80px;
    border-radius: 50%;
    text-align: center;
  }
  .iconImg{
    width: 25px;
    height: 25px;
    vertical-align:middle;
  }
  .top{
    border: solid 2px lavender;
    margin: 12px 5px;
    background: white;
    float: left;
    width: 96%;
    height: 360rpx;
    border-radius: 8px;
  }
  .top .topTop{
    margin-top: 10rpx;
    float: left;
    width: 100%;
    height: 60%;

  }
  .topTop .infoText{
    float: left;
    width: 52%;

  }
  .topTop .loginIcon{
    float: left;
    width: 43%;
  }
  .top .topBottom{
    border-top: solid 1px lavender;
    margin-top:35rpx;
    float: left;
    width: 99%;
    height: 30%;
  }
  .topBottom .mark{
    float: left;
    width: 48%;
    text-align: center;
    /*border-right: solid 2px saddlebrown;*/
  }
  .mark span{
    font-size: 15px;
    color: #cecece;
  }

  .topBottom .token{
    float: left;
    width: 48%;
    text-align: center;
  }
  .token span{
    font-size: 15px;
    color: #cecece;
  }
  .loginIcon{
    float: left;
    width: 48%;
  }
  .center{
    border: solid 2px saddlebrown;
    margin: 20px 5px;
    background: white;
    float: left;
    height: 100rpx;
    vertical-align:middle;
    width: 96%;
    border-radius: 8px;
  }

  .center .note{
    float: left;
    width: 48%;
    border-right: solid 1px saddlebrown;
    height: 100%;

  }
  .center .collect{
    float: left;
    width: 48%;
  }

  .bottom{
    width: 96%;
    border: solid 2px bisque;
    margin-top: 15px;
    margin-left: 5px;
    background: white;
    float:left;
    border-radius: 8px;
    /*height: 520rpx;*/
  }
  .bottom .book{
    margin-bottom: 20rpx;
  }
  .bottom .ticket{
    margin-bottom: 20rpx;
  }
  .bottom .activity{
    margin-bottom: 20rpx;
  }
  .bottom .info{
    margin-top: 20rpx;
  }
  button .icon{
    float: right;
  }
  button .btText{
    float:  left;
  }

</style>
