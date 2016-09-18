package com.github.fellowship_of_the_bus
package draconia
package game

object SkillTree {
  def apply() = {
    new SkillTree(new MeleeSkillTree, new RangedSkillTree, new MagicSkillTree, new HealingSkillTree)
  }
}

class BaseSkillTree {

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

