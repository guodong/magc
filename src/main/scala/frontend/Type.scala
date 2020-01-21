package frontend

trait Type {

}
trait CompoundType extends Type

object StringType extends Type
object IntegerType extends Type
object BitwiseType extends Type
object MapType extends CompoundType
object SetType extends CompoundType
object ListType extends CompoundType
class ClassType(name: String, elements: List[Type]) extends CompoundType