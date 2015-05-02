package com.github.fellowship_of_the_bus
package draconia.game

// A mapping of masteries to numbers
object MasteryID {
	val fire = 0
	val water = 1
	val earth = 2
	val wind = 3
	val light = 4
	val dark = 5
	val oneHand = 6
	val shield = 7
	val twoHand = 8
	val bow = 9
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

// Base class for masteries
trait Mastery {
	// Stat gains granted by mastery
	def gains: Array[Int]
	// Associated masteries which grant combination skills
	def related: Array[Int]
	// Associated skills granted
	def comboSkills: Array[Int]
}

object FireMastery extends Mastery {
	val gains = new Array[Int](8)
	val related = Array(MasteryID.earth, MasteryID.wind, MasteryID.light)
	val comboSkills = Array(1) // placeholder value until skill mapping created
}

// object waterMastery
// object earthMastery
// object windMastery
// object lightMastery
// object darkMastery
// object oneHandMastery
// object shieldMastery
// object twoHandMastery
// object bowMastery