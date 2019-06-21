<template>
  <div class="body">
  <!--已参与的课程-->
  <div class="courses">
    <span class="courseBar">已参与的课程</span>
    <ul v-for="item in tokenCourses" :key="index">
      <li class="AAAimageSize"><img :src="item.image" alt="">
        <span>{{item.name}} 课程进度: {{item.process}} % </span>
        <button class="weui-btn mini-btn" type="primary" size="mini">查看</button>
      </li>
    </ul>
  </div>

  <!--所有的课程-->
  <div class="courses">
    <span class="courseBar">全部课程</span>
    <ul v-for="it in courses" :key="index">
      <li class="imageSize"><img :src="it.image" alt="">
        <span>{{it.name}}</span>
        <span style="color: red">￥{{it.price}}</span>
        <navigator :url="'../learn/main?id='+id" hover-class="none">
          <button class="weui-btn mini-btn" size="mini" type="warn">参与</button>
        </navigator>
      </li>
    </ul>
  </div>
  </div>
</template>

<script>
  import { formatTime } from '@/utils/index'
    export default {
      data() {
        return {
          tokenCourses:[
            {
              name:'SQL从入门到放弃',// course name
              process:10,// your token process
              description:'SQL从入门到放弃',// course description
              price:20,
              image:'http://nos.netease.com/edu-image/00c8b32b-3c0d-4343-8ee0-09c5dd372c66.jpg',

            },
          ],
          courses:[
            {
              name:'SQL从入门到放弃',// course name
              process:0,// your token process
              description:'SQL从入门到放弃',// course description
              price:20,
              image:'http://nos.netease.com/edu-image/00c8b32b-3c0d-4343-8ee0-09c5dd372c66.jpg',

            },
            {
              name:'SQL从入门到放弃',// course name
              process:0,// your token process
              description:'SQL从入门到放弃',// course description
              price:20,
              image:'http://nos.netease.com/edu-image/00c8b32b-3c0d-4343-8ee0-09c5dd372c66.jpg',

            },
            {
              name:'SQL从入门到放弃',// course name
              process:0,// your token process
              description:'SQL从入门到放弃',// course description
              price:20,
              image:'http://nos.netease.com/edu-image/00c8b32b-3c0d-4343-8ee0-09c5dd372c66.jpg',

            },
            {
              name:'SQL从入门到放弃',// course name
              process:0,// your token process
              description:'SQL从入门到放弃',// course description
              price:20,
              image:'http://nos.netease.com/edu-image/FE8F6C4E0E7607D1FD4B99F2458EA42F.jpg',

            },{
              name:'SQL从入门到放弃',// course name
              process:0,// your token process
              description:'SQL从入门到放弃',// course description
              price:20,
              image:'http://nos.netease.com/edu-image/FE8F6C4E0E7607D1FD4B99F2458EA42F.jpg',

            },
            {
              name:'SQL从入门到放弃',// course name
              process:0,// your token process
              description:'SQL从入门到放弃',// course description
              price:20,
              image:'http://nos.netease.com/edu-image/00c8b32b-3c0d-4343-8ee0-09c5dd372c66.jpg',

            }
          ],
          userName: '',
          password: '',
          wechat:'',
          mail:'',
          gender:''
        }
      },
    }
</script>

<style scoped>
.courses{
  margin-top: 10rpx;
}
.courseBar{
  border-bottom: solid 1px lavender;
  font-size: 35rpx;
}
.imageSize{

}

</style>
