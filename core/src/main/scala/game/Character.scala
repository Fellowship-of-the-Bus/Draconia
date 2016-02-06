package com.github.fellowship_of_the_bus
package draconia
package game

import IDMap._
import lib.util.rand
import lib.math.floor

object Character {
  def apply(n: String) {
    var attribute = new Attributes(0,0,0,0,0,0,0,0,0)
    var growth = new Growth(0,0,0,0,0,0)
    // roll random character stats
    var t = rand(3)
    var pool = 0
    if (t == 0) {
      pool = 50
    } else if ( t == 1) {
      pool = 60
    } else if (t == 2) {
      pool = 70
    }
    while (pool > 0) {
      t = rand(6)
      t match {
        case 0 => attribute.strength = attribute.strength+1
        case 1 => attribute.intelligence = attribute.intelligence+1
        case 2 => attribute.speed = attribute.speed+1
        case 3 => attribute.health = attribute.health+10
        case 4 => attribute.physicalDefense = attribute.physicalDefense+1
        case 5 => attribute.magicDefense = attribute.magicDefense+1
      }
      pool = pool -1
    }
    return new Character(n, attribute, growth)
  }
} 

class Character (val name: String, val attributes: Attributes, val growth: Growth) {

  var level = 1
  var experience = 0

  //Equipment
  var inventory = List[Item]

  //Skills
  var skillTree = SkillTree()

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


