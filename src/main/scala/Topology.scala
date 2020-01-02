import io.circe.generic.auto._
import io.circe.parser
import scalax.collection.edge.Implicits._
import scalax.collection.edge.LUnDiEdge
import scalax.collection.mutable.Graph

class Node {

}

case class Ninfo(ports: Map[String, String]) {

}

class Link1 {

}

case class Topo(nodes: Map[String, Ninfo], links: List[List[String]]) {

}

object Topology {
  //  val tree = json.JSON.parseFull(Source.fromResource("topo.json").mkString)
  val g = Graph.empty[Switch, LUnDiEdge]

  def addSwitch(switch: Switch): Unit = {
    g += switch
  }

  def getSwitch(name: String): Switch = {
    val n = g.nodes.find(n => n.id == name)
    n match {
      case Some(x) => x.toOuter
      case None => null
    }

  }

  def addLink(node1: Switch, node2: Switch, link: Link): Unit = {
    g += (node1 ~+ node2) (link)
  }

  def fromJson(json: String): Unit = {
    //    implicit val ninfoDecoder = deriveDecoder[Ninfo]
    //    implicit val topoDecoder = deriveDecoder[Topo]
    val obj = parser.decode[Topo](json)
    obj match {
      case Right(topo) => {
        for ((name, info) <- topo.nodes) {
          val sw = Switch(name)
          for ((pid, pinfo) <- info.ports) {
            val port = new Port(pid)
            sw.ports += (pid -> port)
          }
          addSwitch(sw)
        }
        topo.links.foreach(pair => {
          val s1 = getSwitch(pair(0).split(":")(0))
          val s1p = pair(0).split(":")(1)
          val s2 = getSwitch(pair(1).split(":")(0))
          val s2p = pair(1).split(":")(1)
          val link = Link(s1.ports(s1p), s2.ports(s2p))
          addLink(s1, s2, link)
        })
      }
    }
    println(g)
  }

  def shortestPath(src: String, dst: String): Option[Topology.g.Path] = {
    def n(outer: Switch): g.NodeT = g get outer

    n(getSwitch(src)) shortestPathTo n(getSwitch(dst))
  }
}

object SwitchType extends Enumeration {
  type SwitchType = Value
  val OF, P4, NPL = Value
}

class Port(id: String) {
  val switch: Switch = null
}

case class Switch(var id: String) {

  import SwitchType._

  val typ: SwitchType = P4
  var ports: Map[String, Port] = Map.empty
}

case class Link(var p0: Port, var p1: Port) {

}

//object Topology1 {
//  val (s1, s2, s3) = (Switch("s1"), Switch("s2"), Switch("s3"))
//  s1.ports.addOne(new Port(1))
//  s2.ports.addOne(new Port(1))
//  s3.ports.addOne(new Port(1))
//
//  val g1 = Graph((s1 ~+ s2) (Link(s1.ports(0), s2.ports(0))),
//    (s2 ~+ s3) (Link(s2.ports(0), s3.ports(0))),
//    (s1 ~+ s3) (Link(s1.ports(0), s3.ports(0))))
//  println(g1 mkString (","))
//
//  def n(outer: Switch): g1.NodeT = g1 get outer
//
//  val spO = n(s1) shortestPathTo n(s3)
//  println(spO)
//}
