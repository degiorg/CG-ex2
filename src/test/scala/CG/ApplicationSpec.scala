package CG

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import org.scalatest.matchers.should.Matchers._

class ApplicationSpec extends AnyFlatSpec  with TypeCheckedTripleEquals with ScalaCheckPropertyChecks  {
  """The getSumOfCharWord with an empty array """ should
  """return an empty Map""" in {
  GetSumOfCharWord(Array("")) shouldEqual   (LineToPrint(Map()))
  }
  """The getSumOfCharWord with a g """ should
  """return a Map ((\"g\" , 1))""" in {
  GetSumOfCharWord(Array("g")) shouldEqual LineToPrint(Map(("g", 1)))
  }
  """The getSumOfCharWord with a gi """ should
  """return a Map ((\"g\" , 1), (\"i\" , 1))""" in {
  GetSumOfCharWord(Array("gi")) shouldEqual  LineToPrint(Map(("g" , 1) , ("i", 1)))
  }
  """The getSumOfCharWord with a gg """ should
  """return a Map ((\"g\" , 2), """ in {
  GetSumOfCharWord(Array("gg")) shouldEqual  LineToPrint(Map(("g" , 2) ))
  }
  """The getSumOfCharWord with a ggi """ should
  """return a Map ((\"g\" , 2), (\"i\" , 1) """ in {
  GetSumOfCharWord(Array("ggi")) shouldEqual  LineToPrint(Map(("g" , 2), ("i", 1)))
  }
  """The getSumOfCharWord with a ggii """ should
  """return a Map ((\"g\" , 2), (\"i\" ,2) """ in {
  GetSumOfCharWord(Array("ggii")) shouldEqual  LineToPrint(Map(("g" , 2), ("i", 2)))
  }
  """The getSumOfCharWord with a gigi """ should
  """return a Map ((\"g\" , 2), (\"i\" ,2) """ in {
  GetSumOfCharWord(Array("gigi")) shouldEqual  LineToPrint(Map(("g" , 2), ("i", 2)))
  }

  """Given any Array of string the sum of the char """ should """equal of GetSumOfCharWord sum return""" in {
  forAll(fun = (args: Array[String]) => {
  val result = GetSumOfCharWord(args)
  result.lineProcessing.values.sum shouldEqual (args.map(_.length).sum)
      }
    )
  }
}