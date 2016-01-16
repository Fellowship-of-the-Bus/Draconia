package com.github.fellowship_of_the_bus.draconia

// import android.app.Activity
import org.scaloid.common._
import android.os.Bundle
import android.view.Gravity
import android.graphics.Color
import java.util.concurrent.atomic.AtomicInteger
import android.graphics.BitmapFactory

import scala.language.postfixOps

class BattleActivity extends SActivity {
  val viewSeq = new AtomicInteger(0)

  override def onCreate(savedState: Bundle) {
    super.onCreate(savedState)
    val prefs = Preferences()

    viewSeq.set(0)
    setContentView(
      new SScrollView {
        <<.fill
        new SHorizontalScrollView {
          <<.fill
          // style {
          //   case v => v.id = viewSeq.incrementAndGet
          // }
          // var options = new BitmapFactory.Options();
          // options.inJustDecodeBounds = true;

          // SImageView().setImageBitmap(BitmapFactory.decodeResource(getResources, R.drawable.test, options))
          var imageView = SImageView()
          imageView.<<.wrap
          imageView.background = R.drawable.test
          // var imageView = SImageView().<<.wrap.background = R.drawable.test
        }
      }
    )
  }
}