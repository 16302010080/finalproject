<template>
  <div>
    <div class="searchBt">
      <input type="text" class="search" placeholder="搜索课程" v-model="titleSearch" v-on:input="getTitle" />
      <img class="iconImg" src="/static/img/搜索.png" @click="searchCourse(titleSearch)"/>
    </div>
    <!--轮播-->
    <div id="topBanner" class="slide" >
      <div v-for="(imgUrl, index) in bannerList" v-show="index===mark" :key="index" class="slideshow">
        <img :src=imgUrl class="image">
      </div>
      <div class="bar">
        <span v-for="(item, index) in bannerList" :class="{ 'active':index===mark }" :key="index"></span>
      </div>
    </div>

    <!--课程信息-->
    <div class="imageDisplay">
      <div class="allCourses">
        <div class="courseBar">
          <button @click="courseDetail(0)">全部课程</button>
        </div>
        <ul v-for="item in courses" :key="index" v-if="index<4">
          <li class="twoDisplay" @click="courseDetail(item.courseID)">
            <img :src="item.courseImageURL" alt="图片未正常显示" >
            <div class="courseInfo" >
              <span class="title">{{item.courseName}}</span>
            </div>
            <div class="detail0">
              <span >￥{{item.price}} | {{item.startTime}} 开学</span>
              <!--<router-link :to="{path:'../test/main',query:{CourseID:item.courseID}}">-->
                <!--<button>跳转</button>-->
              <!--</router-link>-->
            </div>
          </li>
        </ul>
        <!--//方式一-->
        <!--<router-link :to="{name:'classifyChild',params:{id:item.id}}">-->
          <!--<button>跳转</button>-->
        <!--</router-link>-->

        <!--//方式二-->
        <!--<router-link :to="{path:'../test/main',query:{CourseID:item.id}}">-->
          <!--<button>跳转</button>-->
        <!--</router-link>-->
      </div>
      <div class="theme">
        <div class="courseBar">
          <button>精选专题</button>
        </div>
        <ul v-for="item in courses" :key="index" v-if="index>=4">
          <li class="imageSize"  @click="courseDetail(item.courseID)">
            <img :src="item.courseImageURL" alt="图片未正常显示" style="width: 98% ; height: 150px">
            <div class="text" >
              <span>{{item.courseName}}</span>
            </div>
            <div class="detail1">
              <span >￥{{item.price}} | {{item.startTime}} 开学</span>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>


<script>
//  import router from '../../router'

  export default {
    data () {
      return {
        titleSearch:'',
        mark: 0, //比对图片索引的变量
        bannerList: ["https://hbimg.huabanimg.com/54358fdcb6a553b0005329ac43bd41c6916f34e32bba1-Eg01CB_fw658",
          "https://hbimg.huabanimg.com/b1602569db6a861bbc8044c32c55cd8c6724824f2f7c1-Y1hdCj_fw658",
          "https://hbimg.huabanimg.com/517c79faab2cf8cb5a8d984a7070c299186c50e86fd5-eBTJ39_fw658",
          "https://hbimg.huabanimg.com/f9fec1016c5f746b3aaf38e3c4f3b8dc5bc3833f89f3-janJih_fw658",
          "https://hbimg.huabanimg.com/3f1501cfc0fc6ced8719730eb29841daa5d2075fd0894-4awbUB_fw658"],
        courses:[],
      }
    },

    created () {
      this.play();
      this.getCourse();
      this.searchCourse();
      this.titleSearch=''
    },

    methods: {
        //监听文本框的数据变化
        getTitle(){
            if(this.titleSearch!==''){
              console.log("tail"+this.titleSearch)
            }
        },

       getCourse(){
         this.$fly.get( 'http://localhost:8084/home/listAllCourse').then(res => {
           console.log(res)
          this.courses = res;
         })
           .catch(error =>{
             console.log(error);
             console.log('首页课程访问失败');
           })
       },
      searchCourse(){
        this.$fly.post('http://localhost:8084/home/searchCourse', { courseName: this.titleSearch}).then(res => {
            console.log(res);
        })
          .catch(error => {
            console.log(error);
            console.log(titleSearch + '该课程不存在');
          })
      },

      courseDetail(courseID){
        const url = '../test/main'
        wx.navigateTo({url})
//        console.log(courseID);
      },

      autoPlay () {
        this.mark++;
        if (this.mark === 5) { //当遍历到最后一张图片置零
          this.mark = 0
        }
      },
      play () {
        setInterval(this.autoPlay, 2500)
      },
      change (i) {
        this.mark = i
      },
      openAlert() {
        wx.showModal({
          content: '搜素结果',
          showCancel: false,
          success: function (res) {
            if (res.confirm) {
              console.log('用户点击确定')
            }
          }
        })
      },
    }
  }


</script>


<style scoped>
  .imageDisplay{
    width: 98%;
    margin-top: 3rpx;
    margin-left: 20rpx;
    float: left;
  }
  .courseBar{
    background: #c7c7c7;
    font-size: 38rpx;
    color:gray;
    width: 98%;
    margin-bottom: 8px;
    border-radius: 5px;
    /*padding-right: 50%;*/
  }
  .allCourses{
    margin-top: 10rpx 0 20rpx 0;
    width: 98%;
    height: 100%;
    float: left;
  }
  .allCourses ul{
    width: auto;
  }
  .allCourses li{
    width: 48%;
    float: left;
    /*border: solid 3px white;*/
    margin: auto 3px ;
    position: relative;
  }
  .allCourses img{
    width: 97%;
    height: 220rpx;
  }
  .theme{
    margin-top: 50rpx 0 20rpx 0;
    width: 98%;
    height: 100%;
    float: left;
  }
  .courseInfo{
    width: 100%;
    position:absolute;
    top: 20px;
    text-align: center;
    color: #ff150e;
    font-weight:bold
  }
  .text{
    width: 100%;
    position:absolute;
    margin-top: -120px;
    text-align: center;
    color:#fff;
    font-weight:bold
  }
  .detail0{
    width: 86%;
    position:absolute;
    text-align: center;
    top: 75%;
    left: 49%;
    -webkit-transform: translate(-50%, -50%);
    -moz-transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    -o-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    font-size: 12px;
    background-color: rgba(26, 255, 113, 0.17);
    border-radius: 5px;
  }
  .detail1{
    width: 75%;
    position:absolute;
    text-align: center;
    margin-top: -50px;
    left: 49%;
    -webkit-transform: translate(-50%, -50%);
    -moz-transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    -o-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    font-size: 12px;
    background-color: rgba(255, 253, 29, 0.13);
    border-radius: 10px;
  }

  .searchBt{
    width: 96%;
    height: 30px;
    text-align: center;
    border-radius: 10px;
    margin-left: 10rpx;
    margin-top: 5rpx;
    border: solid 2px lightskyblue;
  }
  .search{
    width: 85%;
    float: left;
  }
  .iconImg{
    width: 25px;
    height: 25px;
    float: left;
    vertical-align:middle;
  }

  .slide {
    width: 95%;
    height: 200px;
    overflow: hidden;
    position: relative;
    margin: 5px  auto;
    border: solid 1px lavender;
    border-radius: 10px;
  }
  .slideshow {
    width: 100%;
    height: 100%;
    float: left;
  }

  .image {
    width:100% ;
    height: 200px;
    display: flex;
    border-radius: 10px;
  }
  .bar {
    position: absolute;
    width: 100%;
    bottom: 10px;
    z-index: 10;
    text-align: center;
  }
  .bar span {
    width: 10px;
    height: 10px;
    -webkit-border-radius:50%;
    -moz-border-radius:50%;
    border-radius:50%;
    background: white;
    display: inline-block;
    margin-right: 10px;
  }
  .title{
    font-weight: 600;
    font-family:"HoloLens MDL2 Assets";
  }
</style>
