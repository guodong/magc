package network

import io.circe.generic.auto._
import io.circe.parser
import scalax.collection.edge.Implicits._
import scalax.collection.edge.LUnDiEdge
import scalax.collection.mutable.Graph

case class Ninfo(ports: Map[String, String]) {

}

case class Topo(hosts: Map[String, Ninfo], switches: Map[String, Ninfo], links: List[List[String]]) {

}

object Topology {
  //  val tree = json.JSON.parseFull(Source.fromResource("topo.json").mkString)
  val g = Graph.empty[Node, LUnDiEdge]

  def addSwitch(switch: Switch): Unit = {
    g += switch
  }

  def addHost(host: Host): Unit = {
    g += host
  }

  def getNode(name: String): Node = {
    val n = g.nodes.find(n => n.id == name)
    n match {
      case Some(x) => x.toOuter
      case None => null
    }
  }

  def addLink(node1: Node, node2: Node, link: Link): Unit = {
    g += (node1 ~+ node2) (link)
  }


  def fromJson(json: String): Unit = {
    //    implicit val ninfoDecoder = deriveDecoder[network.Ninfo]
    //    implicit val topoDecoder = deriveDecoder[network.Topo]
    val obj = parser.decode[Topo](json)
    obj match {
      case Left(error) => println(error.getMessage)
      case Right(topo) => {
        for ((name, info) <- topo.switches) {
          val sw = new Switch(name)
          for ((pid, pinfo) <- info.ports) {
            val port = new Port(pid, sw)
            sw.addPort(port)
          }
          addSwitch(sw)
        }
        for ((id, info) <- topo.hosts) {
          val host = new Host(id)
          for ((pid, pinfo) <- info.ports) {
            val port = new Port(pid, host)
            host.addPort(port)
          }
          addHost(host)
        }
        topo.links.foreach(pair => {
          val s1 = getNode(pair(0).split(":")(0))
          val s1p = pair(0).split(":")(1)
          val s2 = getNode(pair(1).split(":")(0))
          val s2p = pair(1).split(":")(1)
          s1.ports(s1p).peer = s2.ports(s2p)
          s2.ports(s2p).peer = s1.ports(s1p)
          val link = new Link(s1.ports(s1p), s2.ports(s2p))
          addLink(s1, s2, link)
        })
      }
    }
    println(g)
  }

  def shortestPath(src: String, dst: String): Option[g.Path] = {
    def n(outer: Node): g.NodeT = g get outer
    var srcSw: Node = null
    var dstSw: Node = null
    if (src.contains(":")) { // e.g. "e1:1"
      srcSw = getNode(src.split(":")(0))
    } else {
      srcSw = getNode(src)
    }

    if (dst.contains(":")) {
      val tmpSw = getNode(dst.split(":")(0))
      val port = tmpSw.ports(dst.split(":")(1))
      dstSw = port.peer.node
    }
    val p: Option[g.Path] = n(srcSw) shortestPathTo n(dstSw)
    p
  }
}
