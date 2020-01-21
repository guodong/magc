import frontend.Variable
import network.Topology

class PathFingerprint {
  var path: Topology.g.Path = _
  var fingerprint: Map[Variable, Any] = _
}
