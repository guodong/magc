import org.scalatest.funsuite.AnyFunSuite

class DC extends AnyFunSuite {
  test("res") {
    //    val ir = IR
    //    val dctable = MapVariable
    val mb = 1024 * 1024
    val runtime = Runtime.getRuntime
//    var a = ArrayBuffer[Int]()
//    for (w <- 0 to 100000000)
//      a.addOne(w)
    println("** Used Memory:  " + (runtime.totalMemory - runtime.freeMemory) / mb)
    println("** Free Memory:  " + runtime.freeMemory / mb)
    println("** Total Memory: " + runtime.totalMemory / mb)
    println("** Max Memory:   " + runtime.maxMemory / mb)
  }

  test("dc") {

  }
}
