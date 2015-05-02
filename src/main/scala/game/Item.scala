package com.github.fellowship_of_the_bus
package draconia.game

class Item

case class Equipable() extends Item() {

}

case class Consumable(amount: Int, action: (Int) => Unit) extends Item() {
  def apply() = action(amount)
}

