package scorex.transaction.proof

import scorex.serialization.BytesSerializable
import scorex.transaction.box.proposition.{ProofOfKnowledgeProposition, Proposition, PublicImage}
import scorex.transaction.state.Secret

/**
  * The most general abstraction of fact a prover can provide a non-interactive proof
  * to open a box or to modify an account
  *
  * A proof is non-interactive and thus serializable
  */

trait Proof[P <: Proposition] extends BytesSerializable {
  def isValid(proposition: P, message: Array[Byte]): Boolean
}

trait ProofOfKnowledge[S <: Secret, P <: ProofOfKnowledgeProposition[S]] extends Proof[P]
