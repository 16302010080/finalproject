<template>
  <!--已参与的课程-->


  <div class="courses">
    <button class="bt" type="default" @click="getTakeCourse" style="border-radius: 2px;"><span class="btText">
      <img  class="iconImg" src="/static/img/已参与课程.png"/>请点击！查看已参与课程</span>

    </button>
    <button><a hre="/pages/course/main?id=FeanLau">点击传值</a></button>

    <div v-for="item in tokenCourses" :key="index" class="courseContent" :v-if="tokenCourses.length>0">
      <div class="text">
        <div class="title">
          <span>{{item.courseName}}</span>
        </div>
        <div class="process">
          <span>课程进度: <span class="processValue">{{item.process===null?"未开始":item.process}}</span> </span>
        </div>
        <div class="bt">
          <button class="weui-btn mini-btn" size="mini" type="primary"@click="watchToCourse">查看课程</button>
          <button class="weui-btn mini-btn" size="mini" type="warn" @click="chatToTeacher">联系老师</button>
        </div>
      </div>
    </div>
    <div class="empty" :v-if="length==0" v-model="length" style="text-align: center">
      <img class="emptyImg" src="/static/img/empty.png" :v-if="tokenCourses.length==0" />
      <span>你还没有参与课程哦！！</span>
    </div>
  </div>

</template>

<script>
  import { formatTime } from '@/utils/index'
    export default {
      data() {
        return {
          tokenCourses:[],
          nickName:'',
          length:0
        }
      },
      created () {
          this.nickName='';
        this.getTakeCourse();
          this.getUserInfo();
      },
      methods:{
        getUserInfo () {
          // 调用登录接口
          wx.login({
            success: () => {
              wx.getUserInfo({
                success: (res) => {
                  this.userInfo = res.userInfo;
                  this.nickName = this.userInfo.nickName;
                  this.gender = this.userInfo.gender;
                  console.log("wodee"+this.nickName+this.gender)
                }
              })
            }
          })
        },
        getTakeCourse(){
          this.$fly.get( 'http://localhost:8084/home/myCourse?studentNickName='+this.nickName).then(res => {
           this.tokenCourses = res;
            console.log("参与课程"+res);
            this.length=this.tokenCourses.length;
            console.log(this.length)
          })
            .catch(error =>{
              console.log(error);
              console.log('已参与课程访问失败');
            })
        },
        chatToTeacher(){
          const url = '../chat/main';
          wx.navigateTo({ url })
        },
        watchToCourse(){
          const url = '../learn/main';
          wx.navigateTo({ url })
        },
      }
    }
</script>

<style scoped>
  .courses{
    width: 98%;
    float: left;
    /*position: absolute; ^
    */
  }
  .bt{
    width: 98%;
    vertical-align: middle;
  }
  .courseContent{
    border: solid 1px lavender;
    border-radius: 10px;
    width: 97%;
    margin-top: 20rpx;
    margin-left: 10rpx;
    float: left;
  }
  .imageDisplay{
    float: left;
    width: 45%;
    margin-right: 6rpx;
  }
  img{
    width: 100%;
    height: 200rpx;
    padding-top: 5px;
    padding-left: 2px;
    padding-right: 5px;
  }
  .text{
    float: left;
    padding-top: 5px;
    margin-left: 8px;
    width: 50%;
    height: 200rpx;
  }
  .title{
    font-weight: 600;
    font-size: 30rpx;
    color: #6482fa;
    margin-bottom: 5rpx;
  }
  .process{
    font-size: 28rpx;
    margin-top: 10rpx;
  }
  .processValue{
    color: #ff4306;
  }
  .btText{
    float: left;
    vertical-align: bottom;
  }
  .iconImg{
    width: 25px;
    height: 28px;
   vertical-align: middle;
  }
  .emptyImg{
    width: 94%;
    height: 400rpx;
    margin: 5px;
  }
</style>
