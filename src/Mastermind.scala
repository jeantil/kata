import com.sun.xml.internal.fastinfoset.tools.XML_DOM_FI

package

object Mastermind {
  def check(secret :Symbol*)(proposition: Symbol*):(Int,Int)={
    assert(secret.size==proposition.size)
    val nbGood=secret.zip(proposition).count {case(x,y)=>x==y}

    val mapNumColProposition=proposition.groupBy(identity).mapValues(_.size)
    val mapNumColSecret=secret.groupBy(identity).mapValues(_.size)
    val numBad=for{
      (color,nbMauveSecret)<-mapNumColSecret
      nbMauve=mapNumColProposition.getOrElse(color,0)
    } yield (nbMauve min nbMauveSecret)

    (nbGood, numBad.sum-nbGood)
  }
}
