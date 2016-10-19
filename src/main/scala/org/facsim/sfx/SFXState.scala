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
Scala source file belonging to the org.facsim.sfx package.
*/
//======================================================================================================================

package org.facsim.sfx

import javafx.application.Application

/**
Trait encapsulating the state of a ''JFX'' application.

This provides an interface for specific states defined in this file.
*/
private[sfx] sealed trait SFXState {

/**
The ''JavaFX'' application instance.

This value is `None` unless there is an active ''JavaFX'' application instance.
*/

  val jfxApp: Option[Application] = None
}

/**
Uninitialized.

State for ''SFX'' applications that have yet to initialize ''JavaFX''.
*/
private[sfx] object SFXUninitialized
extends SFXState

/**
Running.

State for an ''SFX'' application that is currently running.

@constructor Create new ''SFX'' running application.

@param jfxApp ''JavaFX'' sole application instance. This cannot be `None` and must be defined.
*/
private[sfx] case class SFXRunning(override val jfxApp: Option[Application])
extends SFXState {

/*
Sanity checks
*/
  require(jfxApp.isDefined)
}

/**
Terminated.

State for a ''JFX'' application that has been terminated, and which is no longer active.
*/
private[sfx] object SFXTerminated
extends SFXState