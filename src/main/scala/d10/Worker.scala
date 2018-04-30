package d10

import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import scala.concurrent.duration._

/**
  * @author wcyong
  */
class Worker(var cores: Int, var memory: Int) extends Actor {
  var masterActor: ActorSelection = null
  val workerId = UUID.randomUUID().toString

  val HearBeatIntever = 3000


  //就是actor启动后会立即执行的方法，只会执行一次
  override def preStart(): Unit = {
    masterActor = context.actorSelection("akka.tcp://masterActorSystem@localhost:9980/user/masterActor")
    //1,worker启动后立即向master进行注册
    masterActor ! RegisterWorker(workerId, cores, memory)
  }

  //用来接收消息的方法，这个方法会被多次执行，只要有消息过来就会被执行
  override def receive: Receive = {
    case "started" => println("worker startup successful...")
    //master 发送过来的注册成功的消息
    case RegisteredWorker => {
      //导入定时器
      import context.dispatcher
      //开启定时任务
      context.system.scheduler.schedule(0 millis, HearBeatIntever millis, self, SendHearBeat)
    }
    //向master汇报心跳
    case SendHearBeat => {
      masterActor ! HearBeat(workerId)
    }

  }
}

object Worker {
  def main(args: Array[String]): Unit = {
    val workerHost = "localhost"
    val workerPort = "9983"

    val configStr =
      s"""
         |akka.actor.provider = "akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname = "$workerHost"
         |akka.remote.netty.tcp.port = "$workerPort"
      """.stripMargin

    val config = ConfigFactory.parseString(configStr)
    //创建老大ActorSystem
    val workerActorSystem = ActorSystem("workerActorSystem", config)
    //使用ActorSystem来创建Actor
    val workerActor = workerActorSystem.actorOf(Props(new Worker(62, 128)), "workerActor")
    workerActor ! "started"
    //将ActorSystem 阻塞在这，不要让其停止
    workerActorSystem.whenTerminated
  }

}
