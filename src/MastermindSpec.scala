package eu.byjean

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import scala.None

/**
 *
*/

class MastermindSpecDone extends FlatSpec with ShouldMatchers {
  behavior of "Mastermind"

  it should "be true" in{
    true should equal(true)
  }

  it should "check that propiosition and secret have the same size" in {
    evaluating {Mastermind.check(secret='blue)(proposition='red,'blue)} should produce
      [AssertionError]
  }

  it should "find nothing in a bad proposition" in {
    Mastermind.check('blue)('red) should equal(0,0)
  }

  it should "find 1 good when proposition of 1 equals secret" in {
    Mastermind.check('blue)('blue) should equal(1,0)
  }

  it should "find 1 good when first of proposition of 2 is good" in {
    Mastermind.check('blue,'red)('blue,'blue) should equal(1,0)
  }

  it should "find 1 good when second of proposition of 2 is good" in {
    Mastermind.check('red,'blue)('blue,'blue) should equal(1,0)
  }

  it should "find 2 good when proposition of 2 is good" in {
    Mastermind.check('blue,'blue)('blue,'blue) should equal(2,0)
  }
  //bon biens placés !!

  it should "find 1 misplaced mauve" in{
    Mastermind.check('blue,'mauve)('mauve,'red) should equal(0,1)
  }

  it should "find 1 misplaced mauve in second position" in{
    Mastermind.check('mauve,'blue)('red,'mauve) should equal(0,1)
  }

  it should "find 2 misplaced mauve" in{
    Mastermind.check('mauve,'blue,'mauve,'blue)('red,'mauve,'red,'mauve) should equal(0,2)
  }

  it should "find 1 good and 1 misplaced mauve" in{
    Mastermind.check('mauve,'blue,'mauve,'blue)('mauve,'red,'red,'mauve) should equal(1,1)
  }
  it should "find 1 good and 1 misplaced mauve with one extra mauve" in {
    Mastermind.check('mauve,'blue,'mauve,'blue)('mauve,'mauve,'red,'mauve) should equal(1,1)
  }
   // fin du kata


  //suite de test complete y compris les tests sautes en presentation
  it should "find throw an error if proposition and secret have different sizes" in {
     evaluating { Mastermind.check(secret='blue)(proposition='red, 'blue) } should  produce [AssertionError]
  }

  it should "find nothing for a wrong proposition" in {
    Mastermind.check(secret='blue)(proposition='red) should equal(0,0)
  }

  it should "find 1 good for an identical proposition of 1" in {
    Mastermind.check('blue)('blue) should equal(1,0)
  }
  it should "find 1 good for a proposition of 2 with the first good" in {
    Mastermind.check('blue,'blue)('blue,'red) should equal(1,0)
  }
  it should "find 1 good for a proposition of 2 with the second good" in {
    Mastermind.check('blue,'blue)('red,'blue) should equal(1,0)
  }
  it should "find 2 good for a proposition of 2" in {
    Mastermind.check('blue,'blue)('blue,'blue) should equal(2,0)
  }
  //bon biens places : ok
  it should "find one misplaced mauve in a proposition with the first misplaced" in {
    Mastermind.check('blue,'mauve)('mauve,'red) should equal(0,1)
  }
  it should "find one misplaced misplaced mauve in a proposition with the second misplaced" in {
    Mastermind.check('mauve,'blue)('red,'mauve) should equal(0,1)
  }
  it should "find 2 misplaced mauve in a secret of 4 " in {
    Mastermind.check('mauve,'mauve,'blue,'blue)('red,'red,'mauve,'mauve) should equal(0,2)
  }
  it should "find 1 good and 1 misplaced mauve in a secret of 3" in {
    Mastermind.check('mauve,'mauve,'blue)('mauve,'red,'mauve) should equal(1,1)
  }
  it should "find 1 good and 1 misplaced mauve in a secret of 4" in {
    Mastermind.check('mauve,'mauve,'blue,'blue)('mauve,'red,'mauve,'mauve) should equal(1,1)
  }

  it should "find 1 good and 1 misplaced pink in a secret of 4" in {
    Mastermind.check('pink,'pink,'blue,'blue)('pink,'red,'pink,'pink) should equal(1,1)
  }
}
