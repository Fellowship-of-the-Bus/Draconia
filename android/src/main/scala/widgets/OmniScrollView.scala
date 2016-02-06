package com.github.fellowship_of_the_bus.draconia

import org.scaloid.common._
import android.os.Bundle
import android.view.Gravity
import android.view.View

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ScrollView;
import android.widget.FrameLayout;
import android.graphics.Canvas

class SVScrollView()(implicit context: Context, parentVGroup: TraitViewGroup[_] = null) extends SScrollView() {
  override def onTouchEvent(ev: MotionEvent) = false
  setWillNotDraw(true)
  override def draw(canvas : Canvas) = {
    super.draw(canvas)
    android.util.Log.e("draconia", s"Vertical draw")
  }
  disableVerticalScrollBar()
}

class SHScrollView()(implicit context: Context, parentVGroup: TraitViewGroup[_] = null) extends SHorizontalScrollView() {
  override def onTouchEvent(ev: MotionEvent) = false
  setWillNotDraw(true)
  override def draw(canvas : Canvas) = {
    super.draw(canvas)
    android.util.Log.e("draconia", s"Horizontal draw")
  }

  disableHorizontalScrollBar()
}

class OmniScrollView()(implicit context: Context, parentVGroup: TraitViewGroup[_] = null) extends SFrameLayout with ScaleGestureDetector.OnScaleGestureListener {
  val vScroll = new SVScrollView()(context,parentVGroup)
  val hScroll = new SHScrollView()(vScroll.context,vScroll.parentViewGroup)
  override val parentViewGroup = hScroll.parentViewGroup

  val scaleDetector = new ScaleGestureDetector(context, this)

  var mx = 0.0f;
  var my = 0.0f;

  var scaleFactor = 1f
  var scaling = false

  setWillNotDraw(false)

  def onScaleBegin(detector : ScaleGestureDetector) = {
    android.util.Log.e("draconia", "Scale begin")
    scaling = true
    true
  }

  def onScale(detector : ScaleGestureDetector) = {
    scaleFactor *= detector.getScaleFactor
    android.util.Log.e("draconia", s"New scale factor ${scaleFactor}")
    invalidate()
    true
  }

  def onScaleEnd(detector : ScaleGestureDetector) = {
    android.util.Log.e("draconia", "Scale end")
    scaling = false
  }

  override def onTouchEvent(event : MotionEvent)  = {
    scaleDetector.onTouchEvent(event);
    event.getActionMasked match {
      case MotionEvent.ACTION_DOWN => {
        mx = event.getX
        my = event.getY
      }
      case MotionEvent.ACTION_MOVE => {
        if (!scaling) {
          val curX = event.getX
          val curY = event.getY
          vScroll.scrollBy(((mx - curX) / scaleFactor).toInt, ((my - curY) / scaleFactor).toInt)
          hScroll.scrollBy(((mx - curX) / scaleFactor).toInt, ((my - curY) / scaleFactor).toInt)
          mx = curX;
          my = curY;
        }
      }
      case MotionEvent.ACTION_UP => {
        val curX = event.getX
        val curY = event.getY
        vScroll.scrollBy(((mx - curX) / scaleFactor).toInt, ((my - curY) / scaleFactor).toInt)
        hScroll.scrollBy(((mx - curX) / scaleFactor).toInt, ((my - curY) / scaleFactor).toInt)
      }
      case _ => {
        android.util.Log.e("draconia", event.toString)
      }
    }
    true
  }

  override def draw(canvas : Canvas) = {
    android.util.Log.e("draconia", s"Drawing with scaleFactor = ${scaleFactor}")
    canvas.save()
    canvas.scale(scaleFactor,scaleFactor)
    super.draw(canvas)
    //vScroll.draw(canvas)
    //hScroll.draw(canvas)
    canvas.restore()
    android.util.Log.e("draconia", s"Done drawing")
  }

  vScroll += hScroll
  this += vScroll

  import scala.language.implicitConversions
  implicit override def defaultLayoutParams[V <: View](v: V): LayoutParams[V] = v.getLayoutParams() match {
    case p: LayoutParams[V @unchecked] => p
    case _ => new LayoutParams(v) {
      object MyFrameLayout extends SFrameLayout()(context, parentVGroup) {
        override def +=(v: View) = {
          OmniScrollView.this.hScroll += v
          this
        }
      }

      override def parent = MyFrameLayout
    }
  }
}
