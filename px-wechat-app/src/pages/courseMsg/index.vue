<template>
  <!--收藏课程-->
  <div class="courseDetail">
    <ul v-for="item in detail" :key="index" v-if="detail.length>0">
      <div class="courseName">{{item.courseName}}</div>
      <div class="text">价格：￥ {{item.price}}</div>
      <div class="text">开学时间：{{item.startTime}}</div>
      <div>
        <h5 class="title">课程介绍</h5>
        <p class="detail">{{item.instruction}}</p>
      </div>
      <div>
        <h5 class="title">为什么学这门课</h5>
        <p class="detail">{{item.introduction}}</p>
      </div>
    </ul>
    <span v-if="detail.length==0">没有收藏！</span>
  </div>
</template>
<script>

  export default {
    data () {
      return {
        detail:[],
        nickName:'',
        gender:'',
        userInfo:[],
      }
    },

    created () {
      this.getDetail();
      this.favorite();
      this.getUserInfo();
      // 调用应用实例的方法获取全局数据
    },
    methods: {
      getDetail(){
        this.$fly.get( 'http://localhost:8084/home/listAllCourse').then(res => {
          // console.log(res)
          this.detail = res;
          console.log(res);
        })
          .catch(error =>{
            console.log(error);
            console.log('课程详情页面访问失败');
          })
      },
      favorite(){
//        const url = '../courseMsg/main';
//        wx.navigateTo({ url })
       this.$fly.post( 'http://localhost:8084/home/listCollectCourse',{"studentNickName":this.userInfo.nickName}).then(res => {
          console.log("duuuus"+this.userInfo.nickName+res);
          this.detail=res;
       });
        console.log("收藏课程")
      },
      joinIn(){
        /*const url = '../learn/main';
         wx.navigateTo({ url })*/
        console.log("加入课程")
      },
      getUserInfo () {
        // 调用登录接口
        wx.login({
          success: () => {
            wx.getUserInfo({
              success: (res) => {
                this.userInfo = res.userInfo;
                this.nickName = this.userInfo.nickName;
                this.gender = this.userInfo.gender;
                console.log(this.nickName+this.gender+"course")
                this.favorite();
              }
            })
          }
        })
      }
    }
  }

</script>
<style scoped>
  .title{
    text-indent: 0.5em;
    font-size: 15px;
    font-weight: 800;
  }
  .detail{
    text-indent: 2em;
    font-size: 12px;
  }
  .courseDetail{
    width: 100%;
    float: left;
  }
  .text{
    font-size: 15px;
    font-weight: 600;
    text-indent: 1em;
    width: 100%;
    height: 40px;
    float: left;
    border: solid 1px lavender;
    margin-top: 1px;
    padding-top: 15px;
    border-radius: 5px;
    vertical-align:middle;
  }
  .courseName{
    font-size: 20px;
    font-weight: 600;
    text-align: center;
    width: 100%;
    height: 40px;
    float: left;
    border: solid 1px lavender;
    margin-top: 1px;
    padding-top: 15px;
    border-radius: 5px;
    vertical-align:middle;
  }
  img{
    width: 100%;
    height: 360rpx;
  }
</style>
