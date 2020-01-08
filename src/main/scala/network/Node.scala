package network

import scala.collection.mutable.ArrayBuffer

class Port(val id: String, val node: Node) {
  var peer: Port = _
  var label: String = ""
}

trait Node {
  val id: String
  var ports: Map[String, Port] = Map.empty

  def addPort(port: Port): Unit = ports += port.id -> port
}

class Host(val id: String) extends Node {
}

class Switch(val id: String) extends Node {
  var dpconfig: String = _
  var tables: ArrayBuffer[Table] = ArrayBuffer.empty
}

class Link(var p0: Port, var p1: Port) {
  var bandwidth: Int = 0
}