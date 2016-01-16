package com.github.fellowship_of_the_bus.draconia

// import android.app.Activity
import org.scaloid.common._
import android.os.Bundle
import android.view.Gravity
import android.graphics.Color
import java.util.concurrent.atomic.AtomicInteger

import scala.language.postfixOps

class BattleActivity extends SActivity {
  val viewSeq = new AtomicInteger(0)

  override def onCreate(savedState: Bundle) {
    super.onCreate(savedState)
    setContentView(
      new SScrollView {
        // style {
        //   case v => v.id = viewSeq.incrementAndGet
        // }

        SImageView().background = R.drawable.test
      }
    )
  }
}
