import scala.collection.BitSet

class Bitseq(string: String) { // 101 -> 100110
  val width: Int = string.length
  var bits: BitSet = BitSet()
  var pos: Int = width - 1

}

