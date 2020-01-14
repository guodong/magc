package frontend

import scala.util.parsing.input.Positional

sealed trait MagellanAST extends Positional
case class ClassDef(name: String) extends MagellanAST
case class VarDef(name: String, varType: VarType) extends MagellanAST
case class VarType(name: String, genericTypes: Seq[VarType]) extends MagellanAST
case class SimpleType(name: String) extends MagellanAST

case class AndThen(step1: MagellanAST, step2: MagellanAST) extends MagellanAST
case class ReadInput(inputs: Seq[String]) extends MagellanAST
case class CallService(serviceName: String) extends MagellanAST
case class Choice(alternatives: Seq[ConditionThen]) extends MagellanAST
case object Exit extends MagellanAST

sealed trait ConditionThen extends Positional { def thenBlock: MagellanAST }
case class IfThen(predicate: Condition, thenBlock: MagellanAST) extends ConditionThen
case class OtherwiseThen(thenBlock: MagellanAST) extends ConditionThen

sealed trait Condition extends Positional
case class Equals(factName: String, factValue: String) extends Condition