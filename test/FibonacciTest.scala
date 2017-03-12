import org.scalatest.FlatSpec
import collection.JavaConverters._

class FibonacciTest extends FlatSpec{

  behavior of "Fibonacci"

  it should "compute pisano periods for a case" in {
    val period = FibonacciHuge.getPisanoPeriod(2).asScala
    assert( period === Array(0,1,1))
  }

  it should "compute pisano periods for b case" in {
    val period = FibonacciHuge.getPisanoPeriod(3).asScala
    assert( period === Array(0,1,1,2,0,2,2,1))
  }

  it should "compute pisano periods for c case" in {
    val period = FibonacciHuge.getPisanoPeriod(4).asScala
    assert( period === Array(0,1,1,2,3,1))
  }

  it should "compute Fibonacci modulo m" in {
    val result = FibonacciHuge.getFibonacciHugeFast(2015,3)
    assert(result === 1)
  }


}
