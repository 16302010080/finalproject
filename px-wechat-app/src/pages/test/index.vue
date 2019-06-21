<template>
  <!--课程简介-->
  <div class="courseDetail">
   <ul v-for="item in detail" :key="index">
    <!--img :src="item.courseImageURL" alt="图片未正常显示" -->
    <div class="courseName">{{item.courseName}}</div>
    <div class="text">价格：￥ {{item.price}}</div>
    <div class="text">开学时间：{{item.startTime}}</div>
     <div class="text">授课老师：{{item.techName}}</div>
    <div>
      <h5 class="title">课程介绍</h5>
      <p class="detail">{{item.instruction}}</p>
    </div>
    <div>
      <h5 class="title">为什么学这门课</h5>
      <p class="detail">{{item.introduction}}</p>
      <button class="weui-btn mini-btn" size="mini" type="primary"@click="favorite(item.courseID)">收藏课程</button>
      <button class="weui-btn mini-btn" size="mini" type="warn" @click="joinIn(item.courseID,item.teacherID)">加入课程</button>
    </div>
    </ul>
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
        couseID:0
      }
    },

    created () {
      this.getDetail();
        // 调用应用实例的方法获取全局数据
      this.getUserInfo();
//      let id=this.$route.query.courseID;
//      console.log(id)
//      this.getParams();
//      this.courseID=3;
//      var pages = getCurrentPages();
//      var url = currentPage.route;
//      var options = currentPage.options //如果要获取url中所带的参数可以查看options

//      console.log(options)
    },
    methods: {
      //点击图片可以跳转到相应课程详情页面
//     getDetail(){
//       this.$fly.post('http://localhost:8084/home/courseDetail', {
//         courseImageURL: "https://hbimg.huabanimg.com/82b81270d659edc855262af5937fecf15f6d54ab69ce-rP4gU9_fw658"
//       })
//         .then(res => {
//           console.log(res);
//           //this.detail = res;
//         })
//         .catch(error => {
//           console.log(error);
//           console.log('课程详情页面访问失败');
//         })
//     },
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
      favorite(courseID){
        this.$fly.post( 'http://localhost:8084/home/addCollectCourse',{
          "courseID":courseID,
          "studentNickName":this.nickName
        }).then(res => {
          console.log(res);
        })
          .catch(error =>{
            console.log(error);
            console.log('该课程不存在');
          });
      console.log("收藏课程")
      },
      joinIn(courseID,teacherID){
        /*const url = '../learn/main';
        wx.navigateTo({ url })*/
        this.$fly.post( 'http://localhost:8084/home/addTokenCourse',{
          "courseID":courseID,
          "teacherID":teacherID,
          "studentNickName":this.nickName,
          "process":"未开始"
        }).then(res => {
          console.log(res);
        })
          .catch(error =>{
            console.log(error);
            console.log('该课程不存在');
          });
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
                console.log(this.nickName+this.gender)
              }
            })
          }
        })
      }
    },
    watch: {
//      '$route': 'getParams'
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
