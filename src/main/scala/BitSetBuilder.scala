import scala.collection.BitSet

/**
 * 0 → 01, 1 → 10, x → 11 and z → 00
 */
object BitSetBuilder {
  def fromString(string: String): BitSet = {
    var bits: BitSet = BitSet()
    string.reverseIterator.zipWithIndex.foreach { case (c, i) => {
      if (c == '0') {
        bits += (i << 1)
      } else if (c == '1') {
        bits += ((i << 1) + 1)
      } else { // *
        bits += (i << 1, (i << 1) + 1)
      }
    }
    }
    bits
  }

  def fromInt(int: Int, width: Int = 32): BitSet = {
    var bits = BitSet()
    for (i <- 0 until width) {
      if (0 == ((int >> i) & 1)) {
        bits += (i << 1)
      } else {
        bits += ((i << 1) + 1)
      }
    }
    bits
  }
}
