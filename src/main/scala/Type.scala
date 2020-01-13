trait Type {

}
trait CompoundType extends Type

object StringType extends Type
object IntegerType extends Type
object MapType extends CompoundType
object SetType extends CompoundType
object ListType extends CompoundType
object BitType extends Type