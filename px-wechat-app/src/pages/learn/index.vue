<template>
  <div class="learnPage">

    <div class="detail">
      <div class="courseTittle">课程名称：<span> {{title}}</span></div>
      <div class="teacher"> 教师：<span>{{teacher}}</span></div>
      <div class="ddl">课程时段：<span>{{time}}</span></div>
    </div>

    <div class="taskZone">
      <button class="weui-btn" type="default" disabled="true">教师布置的任务</button>
      <div class="taskEmpty" :wx:if="tasks.length===1"><em>当前没有任务！请享受自己的欢乐时光吧！</em></div>
      <div class="task">
        <div class="courseTittle">题目：<span> {{title}}</span></div>
        <div class="teacher"> 当前状态：<span style="color: red">{{state}}</span></div>
        <div class="ddl">截止时间：<span>{{time}}</span></div>
        <div><button class="weui-btn mini-btn" type="primary" size="mini" @click="openAlert">查看</button></div>
      </div>
    </div>
  </div>
</template>

<script>
  import { formatTime } from '@/utils/index'
  import card from '@/components/card'

  export default {
    components: {
      card
    },

    data () {
      return {
        logs: [],
        title:'SQL从入门到放弃',
        teacher:'小白',
        time:'2019/3/1 - 2019/6/1',
        process:0,
        textList:{},
        tasks:[],
        state:'未完成',


      }
    },
    methods:{
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
          content: '这是题目信息',
          showCancel: false,
          success: function (res) {
            if (res.confirm) {
              console.log('用户点击确定')
            }
          }
        })
      }
    },

    created () {
      const logs = (wx.getStorageSync('logs') || [])
      this.logs = logs.map(log => formatTime(new Date(log)))
    },
    mounted () {
      this.id = this.$root.$mp.query.id//获取参数
      console.log(this.id)
    }
  }
</script>
<style>
  .detail{
    width: 94%;
    border: solid 1px lavender;
    padding: 10rpx;
    /*background: #c7c7c7;*/
    margin-top: 10rpx;
    margin-left: 13rpx;
    border-radius: 10px;
  }
  span{
    color: #2154FA;
    margin-left: 15rpx;
  }
  .taskZone{
    width: 96%;
    /*border: solid 1px lavender;*/
    border-radius: 13px;
    /*background: #c7c7c7;*/
    margin-left: 13rpx;
    margin-top: 25rpx;
  }
  .taskEmpty{
    width: 96%;
    margin-top: 45rpx;
    margin-left: 30rpx;
    vertical-align:middle;
    color: #e64340;
  }
  .task{
    width: 96%;
    border: solid 1px lavender;
    border-radius: 10px;
    /*margin-left: 10rpx;*/
    margin-top: 10rpx;
    padding: 10rpx;
  }
</style>
