/*
Facsimile -- A Discrete-Event Simulation Library
Copyright © 2004-2016, Michael J Allen.

This file is part of Facsimile.

Facsimile is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later
version.

Facsimile is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License along with Facsimile. If not, see
http://www.gnu.org/licenses/lgpl.

The developers welcome all comments, suggestions and offers of assistance. For further information, please visit the
project home page at:

  http://facsim.org/

Thank you for your interest in the Facsimile project!

IMPORTANT NOTE: All patches (modifications to existing files and/or the addition of new files) submitted for inclusion
as part of the official Facsimile code base, must comply with the published Facsimile Coding Standards. If your code
fails to comply with the standard, then your patches will be rejected. For further information, please visit the coding
standards at:

  http://facsim.org/Documentation/CodingStandards/
========================================================================================================================
Scala source file defining the org.facsim.sfx.stage package.
*/
//======================================================================================================================

package org.facsim.sfx

//======================================================================================================================
/**
Wrappers for `javafx.stage` elements.
*/
//======================================================================================================================

import javafx.event.EventDispatcher
import javafx.scene.Scene
import javafx.stage.{Window => JFXWindow}

package object stage {

  implicit class Window (w: JFXWindow)
  extends AnyVal {
    def eventDispatcher = w.getEventDispatcher
    def eventDispatcher_= (ed: EventDispatcher) = w.setEventDispatcher (ed)

    def height = w.getHeight
    def height_= (h: Double) = w.setHeight (h)

    def onCloseRequest = w.getOnCloseRequest
    def onCloseRequest_= (e: => Unit) = w.setOnCloseRequest (???)

    def onHidden = w.getOnHidden
    def onHiddin_= (e: => Unit) = w.setOnHidden (???)

    def onHiding = w.getOnHiding
    def onHiding_= (e: => Unit) = w.setOnHiding(???)

    def onShowing = w.getOnShowing
    def onShowing_= (e: => Unit) = w.setOnShowing(???)

    def onShown = w.getOnShown
    def onShown_= (e: => Unit) = w.setOnShown(???)

    def opacity = w.getOpacity
    def opacity_= (e: => Unit) = w.setOpacity(???)

    def properties = w.getProperties

    def scene = w.getScene
    def scene_= (s: Scene) = w.setScene (s)


    , getUserData, getWidth, getX, getY}
  }
}
