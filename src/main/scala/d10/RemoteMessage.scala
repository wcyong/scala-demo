package d10

/**
  * @author wcyong
  */
trait RemoteMessage extends Serializable {

}

//worker-------->master
case class RegisterWorker(var workerId: String, var cores: Int, var memory: Int) extends RemoteMessage

//master ---->worker
case class RegisteredWorker() extends RemoteMessage

//worker---------->worker
object SendHearBeat

//worker---->master
case class HearBeat(var workerId: String)

//master--->master
object CheckTimeOutWorker
