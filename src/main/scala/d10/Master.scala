package d10

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

import scala.concurrent.duration._

/**
  * @author wcyong
  */
class Master extends Actor {

  //workerId-->WorkerInfo
  val idToWorker = new scala.collection.mutable.HashMap[String, WorkerInfo]()
  //WorkerInfo
  val workers = new scala.collection.mutable.HashSet[WorkerInfo]()

  val CheckTimeOutWorkerIntever = 5000


  //preStart方法是在actor启动后会立马执行的方法
  override def preStart(): Unit = {
    import context.dispatcher
    //启动一个定时器定时检查超时的worker
    context.system.scheduler.schedule(0 millis, CheckTimeOutWorkerIntever millis, self, CheckTimeOutWorker)
  }

  override def receive: Receive = {
    case "started" => println("master startup successful...")
    //接收worker发送过来的注册消息
    case RegisterWorker(workerId, cores, memory) => {
      if (!idToWorker.contains(workerId)) {
        //将发送过来的worker信息进行封装成workerInfo保存到map和set中
        val workerInfo = new WorkerInfo(workerId, cores, memory)
        idToWorker.put(workerId, workerInfo)
        workers += workerInfo

        //sender 指代的是消息源，即谁发送过来的消息，就指代谁
        sender() ! RegisteredWorker

      }
    }
    //接收worker汇报心跳
    case HearBeat(workerId) => {
      //中idToWorker中取出对应的worker更新最近一次汇报心跳的时间
      if (idToWorker.contains(workerId)) {
        val workerInfo = idToWorker(workerId)
        workerInfo.lastHearBeatTime = System.currentTimeMillis()
      }

    }

    //检测超时的worker
    case CheckTimeOutWorker => {
      val currentTime = System.currentTimeMillis()
      //过滤出超时的worker(即在指定的时间范围内没有向master进行汇报)
      val toRemove = workers.filter(w => currentTime - w.lastHearBeatTime > CheckTimeOutWorkerIntever)
      toRemove.foreach(workerInfo => {
        idToWorker.remove(workerInfo.workerId)
        workers -= workerInfo
      })
      println(s" worker of alive is ${workers.size}")
    }
  }
}

object Master {
  def main(args: Array[String]): Unit = {
    val masterHost = "localhost"
    val masterPort = "9980"

    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$masterHost"
         |akka.remote.netty.tcp.port = "$masterPort"
      """.stripMargin

    val config = ConfigFactory.parseString(configStr)
    //创建老大ActorSystem
    val masterActorSystem = ActorSystem("masterActorSystem", config)
    //使用ActorSystem来创建Actor
    val masterActor = masterActorSystem.actorOf(Props[Master], "masterActor")
    //给新创建的masterActor发送一条消息,发送消息用 感叹号 “ ！” 进行发送
    masterActor ! "started"
    //将ActorSystem 阻塞在这，不要让其停止
    masterActorSystem.whenTerminated

  }
}
