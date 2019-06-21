<template>
  <div class="page">
    <div class="page__hd">
      <div class="page__title">个人信息</div>
      <div class="page__desc">可在对应的输入框中输入所要修改的信息，并点击修改</div>
    </div>
    <div class="inputZone">
      <div><span>昵称：</span><input type="text"  class="text"  placeholder="nickName" v-model="nickName" v-on:input="getTitle"  title="昵称"></div>
      <div><span>姓名：</span><input type="text"  class="text"  placeholder="name" v-model="name" v-on:input="getTitle" title="姓名"></div>
      <div><span>性别：</span><input type="text"  class="text"  placeholder="gender" v-model="gender" v-on:input="getTitle" title="性别"></div>
      <div><span>学号：</span><input type="text"  class="text"  placeholder="number" v-model="number" v-on:input="getTitle" title="学号"></div>
      <div><span>邮箱：</span><input type="text"  class="text"  placeholder="email" v-model="email" v-on:input="getTitle" title="邮箱"></div>
      <button class="weui-btn" type="primary" style="width:auto; margin-top: 10px;" @click="changeMsg">修改</button>
    </div>
  </div>
</template>

<script>

  export default {
    components: {
    },

    data () {
      return {
        nickName:'',
        name:'',
        gender:'',
        number:'',
        email:'',
        userInfo:[],


      }
    },
    methods:{
      getTitle(){
        if(this.titleSearch!==''){
          console.log("tail"+this.nickName+this.name+this.gender+this.email)
        }
      },
      changeMsg(){
          if(this.name==='' || this.studentID===0){
              this.openAlert();
          }else {
            this.$fly.post( 'http://localhost:8084/stu/msg',{
              "studentID":this.number,
              "studentName":this.name,
              "studentNickName":this.nickName,
              "gender":this.gender==='女'?0:1,
              "email":this.email,
              "avatarURL":"url"
            }).then(res => {
              //this.courses = res;
              console.log(res+this.nickName);
            })
              .catch(error =>{
                console.log(error);
                console.log('选框有空');
              })
          }
      },
      openConfirm() {
        wx.showModal({
          title: '弹窗标题',
          content: '弹窗内容，告知当前状态、信息和解决方法，描述文字尽量控制在三行内',
          confirmText: "主操作",
          cancelText: "辅助操作",
          success: function (res) {
            console.log(res);
            if (res.confirm) {
              console.log('用户点击主操作')
            } else {
              console.log('用户点击辅助操作')
            }
          }
        })
      },
      openAlert() {
        wx.showModal({
          content: '是否要修改信息！！！！',
          showCancel: false,
          success: function (res) {
            if (res.confirm) {
              console.log('用户点击确定')
            }
          }
        })
      },
      getUserInfo () {
        // 调用登录接口
        wx.login({
          success: () => {
            wx.getUserInfo({
              success: (res) => {
                this.userInfo = res.userInfo;
                this.nickName = this.userInfo.nickName;
                this.gender = this.userInfo.gender === 2 ? '女' : '男';
                console.log(this.userInfo.gender)
              }
            })
          }
        })
      }
    },

    created () {
      // this.name='';
      // this.email='';
      this.number=0;
      this.nickName='';
      this.gender=0;
     this.name='yu';
     this.email='1@da';
//      this.number=2019619;
//      this.nickName='Jong Dae';
//      this.gender=0;
      // 调用应用实例的方法获取全局数据
      this.getUserInfo();
      this.$http.authorList().then(function (res) {
        console.log(res)
      });
      this.id = 3;//路由参数

    },
    mounted () {
      this.id = this.$root.$mp.query.id//获取参数
      console.log(this.id)
    }
  }
</script>
<style>

  .inputZone{
    width: 96%;
    margin: 5px ;
  }
  .text{
    border: solid 2px lavender;
    margin-top: 5px;
    margin-bottom: 2px;
    background: white;
    float: left;
    width: 83%;
  }
  .inputZone span{
    float: left;
    width: 15%;
    margin-top: 10px;
    /*margin-bottom: 2px;*/
    text-align: center;
  }
  input{
    height: 80rpx;
    border-radius: 10rpx;
  }
</style>
