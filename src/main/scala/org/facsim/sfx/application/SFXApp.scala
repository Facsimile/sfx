package org.facsim.sfx.application

import javafx.application.Application

/**
Created by mike on 1/26/2016.
*/
trait SFXApp
extends JFXInitialization {

/**
Main function.

Initialize ''JavaFX'' and create the JavaFX application isntannce. Then execute buffered constructor code on the
''JavaFX event-dispatch thread''.

@note This main function will only become active as the application's starting point if this trait is extended as an
object.

@param args Arguments passed to this application from the command line.

@throws IllegalStateException if the application has already been initialized when called. This would typically happen
only if this function is called explicitly from user code.
 */
  final def main(args: Array[String]): Unit = Application.launch(classOf[JFXApplication], args: _*)
}
