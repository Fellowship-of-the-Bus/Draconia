package com.github.fellowship_of_the_bus
package draconia.game

// A mapping of skills to numbers
object SkillID {
  // val fire = 0
  // val water = 1
  // val earth = 2
  // val wind = 3
  // val light = 4
  // val dark = 5
  // val oneHand = 6
  // val shield = 7
  // val twoHand = 8
  // val bow = 9
}

object SkillTree {

}

class BaseSkillTree {
  def apply() {
    new SkillTree(new MeleeSkillTree, new RangedSkillTree, new MagicSkillTree, new HealingSkillTree)
  }
}

class MeleeSkillTree extends BaseSkillTree {

}
class RangedSkillTree extends BaseSkillTree {

}
class MagicSkillTree extends BaseSkillTree {

}
class HealingSkillTree extends BaseSkillTree {

}
class SkillTree(val meleeSkillTree: MeleeSkillTree, val rangedSkillTree: RangedSkillTree,
                val magicSkillTree: MagicSkillTree, val healingSkillTree: HealingSkillTree) {

}
class MasteryLevels() {
  var levels = new Array[Int](10)

  // Return an array of stat bonuses from masteries
  def getStats() {

  }

  // Return a list of skills granted through masteries
  def getSkills() {

  }
}
