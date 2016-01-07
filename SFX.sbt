// Facsimile -- A Discrete-Event Simulation Library
// Copyright © 2004-2016, Michael J Allen.
//
// This file is part of Facsimile.
//
// Facsimile is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// Facsimile is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
// warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
// details.
//
// You should have received a copy of the GNU Lesser General Public License along with Facsimile. If not,
// see http://www.gnu.org/licenses/lgpl.
//
// The developers welcome all comments, suggestions and offers of assistance. For further information, please visit the
// project home page at:
//
//   http://facsim.org/
//
// Thank you for your interest in the Facsimile project!
//
// IMPORTANT NOTE: All patches (modifications to existing files and/or the addition of new files) submitted for
// inclusion as part of the official Facsimile code base, must comply with the published Facsimile Coding Standards. If
// your code fails to comply with the standard, then your patches will be rejected. For further information, please
// visit the coding standards at:
//
//   http://facsim.org/Documentation/CodingStandards/
//======================================================================================================================
// SBT build configuration specific to the Facsimile SFX project.
//======================================================================================================================

import FacsimileBuild._

// ID of the SFX project.
//
// This is the "normalized name" of this project, also known as a Maven/SBT/Ivy artifact name (such as "myfabapp"). This
// must also match the name of the project on GitHub.

facsimileProjId in Global := "sfx"

// Name of the SFX project.
//
// Human-readable phrase that describes (in a shortened form) this project (such as "My Fabulous App").
//
// This is equivalent to the "name" Maven POM information field, and is employed as such during deployment to the
// Sonatype OSS Nexus repository. It is also used by SBT for naming each project and sub-project.

facsimileProjName in Global := "Lightweight Scala wrapper for JavaFX"

// Description of the main Facsimile project.
//
// This is a detailed description for this project.

facsimileProjDesc in Global := """
  SFX is a lightweight Scala wrapper for JavaFX. It is intended for use by Scala developers working with JavaFX GUI
  interfaces, 3D and FXML.
"""

// Home page of the main Facsimile project.

facsimileProjHomePage in Global := "http://facsim.org/sfx"

// Facsimile root project.

lazy val root = (project in file (".")).
settings (commonSettings: _*).
settings (rootSettings: _*).
settings (rootProjectUnidocSettings: _*).
settings (

// Add library dependencies specific to this project.

  libraryDependencies ++= Seq (
    // TODO
  )
)