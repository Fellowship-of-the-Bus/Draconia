package com.github.fellowship_of_the_bus
package draconia
package game
import org.newdawn.slick.{AppGameContainer, GameContainer, Graphics, SlickException,Color, Input}
import org.newdawn.slick.state.{BasicGameState, StateBasedGame}

import IDMap._
import lib.game.GameConfig.{Height,Width}
import lib.util.rand
import lib.math.floor

class Character (n: String) {

  var level = 1
  var experience = 0
  var name = n
  //base stats
  var strength = 0
  var intelligence = 0
  var speed = 0
  var dexterity = 0
  var health = 0
  var mana = 0
  var physdef = 0
  var magdef = 0

  //growth rates
  var strGrowth = 0
  var intGrowth = 0
  var spdGrowth = 0
  var dexGrowth = 0
  var healthGrowth = 0
  var manaGrowth = 0
  var pdefGrowth = 0
  var mdefGrowth = 0

  {
    var t = rand(3)
    var pool = 0
    var totalbase = 0
    if (t == 0) {
      pool = 50
      totalbase = 50
    } else if ( t == 1) {
      pool = 60
      totalbase = 60
    } else if (t == 2) {
      pool = 70
      totalbase = 70
    }
    while (pool > 0) {
      t = rand(8)
      t match {
        case 0 => strength = strength+1
        case 1 => intelligence = intelligence+1
        case 2 => speed = speed+1
        case 3 => dexterity = dexterity+1
        case 4 => health = health+10
        case 5 => mana = strength+5
        case 6 => physdef = physdef+1
        case 7 => magdef = magdef+1
      }
      pool = pool -1
    }
    t = rand(3)
    var totalgrowth = 0
    t match {
      case 0 => totalgrowth = 20
      case 1 => totalgrowth = 25
      case 2 => totalgrowth = 30
    }
    strGrowth = floor(strength / totalbase * totalgrowth + 0.5)
    intGrowth = floor(intelligence / totalbase * totalgrowth + 0.5)
    spdGrowth = floor(speed / totalbase * totalgrowth + 0.5)
    dexGrowth = floor(dexterity / totalbase * totalgrowth + 0.5)
    healthGrowth = floor(health / totalbase * totalgrowth + 0.5)
    manaGrowth = floor(mana / totalbase * totalgrowth + 0.5)
    pdefGrowth = floor(physdef / totalbase * totalgrowth + 0.5)
    mdefGrowth = floor(magdef / totalbase * totalgrowth + 0.5)
  }


  //Equipment
  var inventory = List[Item]

  
  //skills
  var skillTree = new MasteryLevels
  var skills = List[Skill]
  var skillBar = List[Skill]

  def maxHp () = {
    //some formula
  }
  def maxMp () = {
  }
  def pDamage () = {
    //some formula
  }
  def mDamage () = {
  }
  def pDef () = {
  }
  def mDef () = {
  }
  def acc () = {
  }
  def dodge () = {
  }
}

object Brodric extends Character("Brodric") {
  strength = 10
  intelligence = 10
  speed = 10
  dexterity = 10
  health = 100
  mana = 50
  physdef = 10
  magdef = 10

  strGrowth = 4
  intGrowth = 4
  spdGrowth = 4
  dexGrowth = 4
  healthGrowth = 40
  manaGrowth = 20
  pdefGrowth = 4
  mdefGrowth = 4
}


