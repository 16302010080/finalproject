<template>
  <div class="loginBody">
    <div class="zone">
      <div class="tittle"><p>1.大白书院介绍</p ></div>
      <div class="text">
        <p>熊猫书院是在线碎片化阅读平台，针对目前读书难问题而提出的一项自我改变计划-《十个月提升自己》，
          第一个在线专业课程，学制十个月。 通过十个月的学习能够完善用户的知识结构，具有完善的思维能力。
          隶属于风变科技（深圳）有限公司。
        </p >
      </div>
    </div>
    <div class="zone">
      <div class="tittle"><p>2.阅读计划</p ></div>
      <div class="text">
        <p>Q1：阅读时间是怎么样安排的？什么时候可以看书？<br>
          A1：周一至周五每天0:00系统会准时自动更新内容，你即可在熊猫书院进行阅读。
          要注意的是“任务更新提醒”会在6:30左右通知你阅读，如果你是早起一族，你无需等待通知便可读书。
          另外，提醒时间可到【熊猫书院-我的-阅读提醒设置】中进行调整。
          注：在提醒时间之前完成阅读，将不会收到阅读提醒<br>

          Q2:要买纸质书吗？书单可以换吗？每天读多久？<br>
          A2: ①书院每天给学员提供的卡片内容，都是由我们教研中心邀请相关领域的专业学者根据原书撰写的拆书版。
          这据科学的教学大纲二次开发的精华内容，学员每天只需要抽出15分钟空余时间来进行阅读即可让你快速学习一本书的主要观点和精华内容。
          ②书单暂时是书院提供，不能自己选择，详情可以到熊猫书院公众号内回复【书单】进行获取。
          ③每天会推送15分钟左右的内容提供给大家学习。另外，熊猫书院十分鼓励学员学习原书，但我们暂时只提供拆书版精华内容，
          如果想阅读原书可以自行购买正版的电子书或原书。<br>

          Q3:感觉现在每天的内容有点少？<br>
          A3:目前书院每天提供15分钟左右的学习内容，并且为期十个月，学习难度以及学习量都会循序渐进地提高。
          另一方面，十个月提升自己的计划，事实上最难的是坚持，我们希望大家通过每日坚持阅读，养成阅读的好习惯。
          每日15分钟的碎片阅读，所花费的时间成本是相对较低，能够帮助大家大致了解书籍的内容，
          如果感兴趣，熊猫书院更鼓励大家去阅读原本书籍，不感兴趣也能丰富你的边际知识。<br>
        </p >
      </div>
    </div>
    <div class="zone">
      <div class="tittle"><p>3.课程形式</p ></div>
      <div class="text">
        <p>熊猫书院是在线碎片化阅读平台，针对目前读书难问题而提出的一项自我改变计划-《十个月提升自己》，
          第一个在线专业课程，学制十个月。 通过十个月的学习能够完善用户的知识结构，具有完善的思维能力。
          隶属于风变科技（深圳）有限公司。
        </p >
      </div>
    </div>
    <div class="zone">
      <div class="tittle"><p>4.其他事项</p ></div>
      <div class="text">
        <p>4.1本课程为虚拟服务，付费学员在开学24小时后将不支持任何形式的退款，请您谅解！<br>
          4.2 如有特殊问题、重要反馈可以发送邮件至80@web.fudan.edu.cn
        </p >
      </div>
    </div>
  </div>
</template>

<script>
  export default {
  }
</script>

<style>
  .tittle{
    width: 96%;
    /*height: 30%;*/
    padding-bottom: 10px;
  }
  .tittle p{
    border-left: solid 2px orange;
  }
  .zone{
    width: 96%;
    background: white;
    /*border-top: solid 1px lavender;*/
    margin: 10px 5px;
  }
  .text{
    /*width: 96%;*/
    border-top: solid 1px lavender;
    padding: 15px 5px;
    /*margin: 12px 5px;*/
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
    /*border-right: solid 2px saddlebrown;*/
  }
  .topBottom .token{
    float: left;
    width: 48%;
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
