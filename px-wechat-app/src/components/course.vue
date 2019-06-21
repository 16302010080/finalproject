<template>
  <div>
    <!--ul class="course">
      <li><img src="{{image}}"/>
      <span>{{name}}: {{text}}</span>
      <span>￥{{price}}</span>
      </li>
    </ul-->
  </div>
</template>

<script>
  export default {
    props: ['text','image','price','name']
  }
</script>

<style>
  .course {
    padding: 10px;
    border: solid 1px lavender;
  }
</style>
