/**
 * Created by 董达芬 on 2019/6/18.
 */

created()
{
  axios.get('http://localhost:8084/home/listAllCourse')

  //then获取成功；response成功后的返回值（对象）
    .then(response=>{
      console.log(response);
      this.oftenGoods=response.data;
    })

    //获取失败
    .catch(error=>{
      console.log(error);
      alert('网络错误，不能访问');

    })

}
