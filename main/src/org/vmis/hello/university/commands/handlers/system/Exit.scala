package org.vmis.hello.university.commands.handlers.system

import org.vmis.hello.university.commands.handlers.Handler
import org.vmis.hello.university.commands.statuses.{Ok, Status}

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
object Exit extends Handler {
  override def process(args: Array[String]): Status = {
    println("Exiting")
    Ok
  }
}
