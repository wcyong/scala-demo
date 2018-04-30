package d10

/**
  * @author wcyong
  */

//用来封装worker的基本信息
class WorkerInfo(var workerId: String, var cores: Int, var memory: Int) {
  //worker最近汇报心跳的时间
  var lastHearBeatTime: Long = System.currentTimeMillis()
}
