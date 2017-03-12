import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll
import org.scalacheck.Test.Parameters


object FibonacciCheck extends Properties("Fibonacci"){

  val genNonNegativesInts: Gen[Int] = Gen.choose(1, 10)
  val genModules = Gen.choose(2, 4)

  property("both solutions should be equivalent") =
    forAll(genNonNegativesInts, genModules){(n, m)  =>
      val assertion = FibonacciHuge.getFibonacciHugeNaive(n, m) == FibonacciHuge.getFibonacciHugeFast(n,m)
      if (!assertion) {
        System.out.println("Error en n:" + n + " ,m:" + m)
      }
      assertion
    }

//  override def overrideParameters(p: Parameters): Parameters = p.withMinSuccessfulTests(10000)

}
