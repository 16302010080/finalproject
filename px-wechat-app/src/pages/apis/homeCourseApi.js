import request from './request.js'

class homeCourseApi {
  constructor() {
    const app = getApp();
    console.log(app);
    this._baseUrl = 'http://localhost:8084';
    this._defaultHeader = { 'Content-type': 'application/json' };
    this._request = new request;
    this._request.setErrorHandler(this.errorHander)
  }

  /**
   * 统一的异常处理方法
   */
  errorHander(res) {
    console.error(res)
  }

  /**
   * 获取所有信息
   */
  getMessage() {
    let data =  {};
    return this._request.getRequest(this._baseUrl + '/home/listAllCourse', data).then(res => res.data)
  }

  /**
   * HTTP 请求中的 PUT 、DELETE、POST等网络类型等等函数
   */

}

/*module.exports = {
  homeCourseApi
}*/

export default homeCourseApi;
