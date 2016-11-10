package org.vmis.hello.university

import org.vmis.hello.university.commands.CommandProcessor

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
object Main extends App {
    println("Type command. Type <help> for list of available commands")
    CommandProcessor.run()
}
