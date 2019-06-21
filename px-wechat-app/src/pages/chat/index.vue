<template>
  <div class="chat">
    <scroll-view :scroll-y="motto" :scroll-top="scrollTop" style="height: 1200rpx;">
      <ul class="content">
        <li v-for="(item,index) in chatMsgs " class="chat_item" :key="index">
          <div class="time">{{time}}</div>
          <img class="stuHeadImg" :src="userInfo.avatarUrl" v-if="item.isMe">
          <img class="teHeadImg" src="/static/img/user.png" v-else>
          <div class="stuChatMsg" v-text="item.msg" v-if="item.isMe"></div>
          <div class="teChatMsg" v-text="item.msg" v-else></div>
          <div class="clear-both"></div>
        </li>
      </ul>
    </scroll-view>
    <div class="sendBox">
      <div class="sendIcon"><img class="iconImg" src="/static/img/添加.png"/></div>
      <input type="text" class="sendContent" v-model="userMsg" />
      <div class="sendIcon" @click="sendMsg">发送</div>
    </div>
  </div>
</template>

<script>
  import { formatTime } from  '../../utils/index'
  export default {
    data() {
      return {
        motto: true,
        userInfo: {},
        scrollTop: 0,
        userMsg: '',
        time:formatTime(new Date()).toString(),
        chatMsgs: [
          { isMe: false, msg: '同学, 你好 !', time:formatTime(new Date()).toString()},
        ]
      }
    },
    methods: {
      getUserInfo() {
        // 调用登录接口
        wx.login({
          success: () => {
            wx.getUserInfo({
              success: (res) => {
                this.userInfo = res.userInfo
              }
            })
          }
        })
      },
      sendMsg() {
        var that = this;
        var msg = that.userMsg;
        if (msg != '' && msg.toString().trim() != '') {
          that.chatMsgs.push({
            isMe: true,
            msg: msg,
            time: formatTime(new Date()).toString()
          });
          that.userMsg = '';
          wx.request({
            url: 'https://zhangyake.site/api/robot', //仅为示例，并非真实的接口地址
            data: {
              info: msg,
              id: that.userInfo.nickName
            },
            header: {
              'content-type': 'application/json' // 默认值
            },
            success: function (res) {
              console.log(res.data)
              var data = res.data;
              if (data && data.hasOwnProperty('text')) {
                that.chatMsgs.push({
                  isMe: false,
                  msg: data.text,
                  time: formatTime(new Date()).toString()
                });
              }
              that.scrollTop = that.scrollTop + 10000;
            }
          })
        }
      }
    },
    created() {
      // 调用应用实例的方法获取全局数据
      this.getUserInfo()
    },
    onLoad(options){
        let id = options.id;
    }
  }
</script>

<style scoped>
  .time{
    text-align: center;
  }
  .chat {
  }
  .content {
    margin: 0 0 110rpx 0;
    padding-top: 20rpx;
  }
  .chat_item {
    margin-bottom: 20rpx;
  }
  .stuHeadImg {
    display: block;
    border-radius: 50%;
    width: 72rpx;
    height: 72rpx;
    float: right;
    border-radius: 50%;
    margin: 0 10rpx;
  }
  .teHeadImg {
    display: block;
    border-radius: 50%;
    width: 72rpx;
    height: 72rpx;
    float: left;
    border-radius: 50%;
    margin: 0 10rpx;
  }
  .teChatMsg {
    float: left;
    background: #eaebea;
    max-width: 60%;
    line-height: 48rpx;
    font-size: 32rpx;
    padding: 12rpx 18rpx;
    border-radius: 5rpx;
  }
  .stuChatMsg {
    white-space: normal;
    word-wrap: break-word;
    float: right;
    background: #6ee57d;
    max-width: 60%;
    line-height: 48rpx;
    font-size: 32rpx;
    padding: 12rpx 18rpx;
    border-radius: 5rpx;
  }
  .clear-both {
    clear: both;
    /* height: 20rpx; */
  }
  .sendBox {
    position: fixed;
    display: flex;
    bottom: 0;
    left: 0;
    right: 0;
    height: 100rpx;
    background: #f1f3ec;
    align-items: center;
  }
  .sendIcon {
    flex: 0 0 100rpx;
    text-align: center;
  }
  .sendContent {
    flex: 1;
    height: 72rpx;
    font-size: 36rpx;
    background: #fff;
    border: none;
    outline: none;
    border-radius: 3rpx;
    padding-left: 10rpx;
  }
  .iconImg{
    width: 25px;
    height: 25px;
    vertical-align:middle;
  }
</style>
