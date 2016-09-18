package com.github.fellowship_of_the_bus
package draconia
import java.util.logging.{Level, Logger}
import org.newdawn.slick.{AppGameContainer, GameContainer, Graphics, SlickException,Color, Input, Image}
import org.newdawn.slick.state.{BasicGameState, StateBasedGame}

import lib.util.Native
import lib.game.GameConfig

class Draconia(gamename: String) extends StateBasedGame(gamename) {
  def initStatesList(gc: GameContainer) = {
    gc.setShowFPS(true)
  }
}

object Draconia extends App {
  def makeImg(loc: String) = new Image(loc)

  GameConfig.FrameRate = 60

  try {
    import GameConfig._
    Native.loadLibraryFromJar()
    val appgc = new AppGameContainer(new Draconia("temp"))
    Height = appgc.getScreenHeight
    Width = appgc.getScreenWidth
    appgc.setDisplayMode(Width, Height, true)
    appgc.setTargetFrameRate(FrameRate)
    appgc.setVSync(true)
    appgc.start()
  } catch {
    case ex: SlickException => Logger.getLogger(Draconia.getClass.getName()).log(Level.SEVERE, null, ex)
    case t: Throwable =>
      println("Library path is: " + System.getProperty("java.library.path"))
      t.printStackTrace
  }
}