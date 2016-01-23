package com.github.fellowship_of_the_bus.draconia

import org.scaloid.common._
import android.os.Bundle
import android.view.Gravity


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import android.widget.FrameLayout;

class SVScrollView()(implicit context: Context, parentVGroup: TraitViewGroup[_] = null) extends SScrollView() {
    override def onTouchEvent(ev: MotionEvent) = false
}

class SHScrollView()(implicit context: Context, parentVGroup: TraitViewGroup[_] = null) extends SHorizontalScrollView() {
    override def onTouchEvent(ev: MotionEvent) = false
}

class OmniScrollView()(implicit context: Context, parentVGroup: TraitViewGroup[_] = null) extends SFrameLayout {
  val vScroll = new SVScrollView()(context,parentVGroup)
  val hScroll = new SHScrollView()(vScroll.context,vScroll.parentViewGroup)
  override val parentViewGroup = hScroll.parentViewGroup
  var mx = 0.0f;
  var my = 0.0f;

  override def onTouchEvent(event : MotionEvent)  = {
    event.getActionMasked match {
      case MotionEvent.ACTION_DOWN => {
        mx = event.getX
        mx = event.getY
      }
      case MotionEvent.ACTION_MOVE => {
        val curX = event.getX
        val curY = event.getY
        vScroll.scrollBy((mx - curX).toInt, (my - curY).toInt)
        hScroll.scrollBy((mx - curX).toInt, (my - curY).toInt)
        mx = curX;
        my = curY;
      }
      case MotionEvent.ACTION_UP => {
        val curX = event.getX
        val curY = event.getY
        vScroll.scrollBy((mx - curX).toInt, (my - curY).toInt)
        hScroll.scrollBy((mx - curX).toInt, (my - curY).toInt)
      }
      case _ => {}
    }
    true
  }

  vScroll += hScroll
  this += vScroll
  
}