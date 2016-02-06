package com.github.fellowship_of_the_bus
package draconia
package game

// import lib.util.rand
// import lib.math.floor


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

// Incase we want to change growth rates
case class Growth (var strength: Int, var intelligence: Int, var speed: Int,
              var health: Int, var physicalDefenese: Int, var magicDefense: Int)
