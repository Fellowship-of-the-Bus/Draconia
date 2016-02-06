package com.github.fellowship_of_the_bus
package draconia
package game

trait SkillID
trait PassiveSkillID extends SkillID
trait ActiveSkillID extends SkillID

case class BasicMeleeID() extends ActiveSkillID
case class BasicPassiveID() extends PassiveSkillID


class Skill(val id: SkillID) {
}

class PassiveSkill (sid: PassiveSkillID) extends Skill(sid) {

}

abstract class ActiveSkill(sid: ActiveSkillID) extends Skill(sid) {

  //takes 1 x,y map coord, character
  def action(x: Int, y:Int, c: Character): Unit

  def ignoreLOS: Boolean
  def range: Int

  // if both true, then anything on the tile works
  // if neither, then tile must be empty
  def allowAlly: Boolean
  def allowEnemy: Boolean

  //takes 2 x,y map coords
  def canTarget(xOrigin: Int, yOrigin: Int, xTarget: Int, yTarget: Int): Boolean = {
    //check range and line of sight
    // then check character type in the tile.
    true
  }
}

object BasicMeleeSkill extends ActiveSkill(BasicMeleeID()) {
  def ignoreLOS = true
  def range = 1

  def allowAlly = false
  def allowEnemy = true

  def action(x: Int, y: Int, c: Character) = {

  }
}
