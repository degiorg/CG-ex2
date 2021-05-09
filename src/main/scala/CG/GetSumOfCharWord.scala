package CG

object GetSumOfCharWord {

  def apply(arg: Array[String]): LineToPrint = {
    LineToPrint(arg
      .toSeq
      .flatMap(
        _.split("")
          .filter(_ != "")
          .toSeq)
      .groupMapReduce(identity)(_ => 1)(_ + _))
  }
}

case class LineToPrint(lineProcessing: Map[String, Int]) extends AnyVal
