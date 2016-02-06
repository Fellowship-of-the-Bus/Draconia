package com.github.fellowship_of_the_bus
package draconia
package game

import IDMap._
import lib.util.rand
import lib.math.floor

case class Attributes (
  //base stats
  var strength: Int,
  var intelligence: Int,
  var speed: Int,
  var health: Int,
  var physicalDefense: Int,
  var magicDefense: Int,

  //Equipment only Values
  var fireResistance: Int,
  var iceResistance: Int,
  var lightningResistance: Int) 



case class Growth (val strength: Int, val intelligence: Int, val speed: Int, 
              val health: Int, val physicalDefenese: Int, val magicDefense: Int) 
