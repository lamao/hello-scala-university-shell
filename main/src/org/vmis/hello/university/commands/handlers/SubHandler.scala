package org.vmis.hello.university.commands.handlers

import org.vmis.hello.university.commands.statuses.{BadCommand, Ok, Status}

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
class SubHandler(handlers: Map[String, Handler]) extends Handler {

  private val RequiredNumberOfArgs = 1

  override def process(args: Array[String]): Status = {
    val subCommand = args(0)
    if (handlers.contains(subCommand)) {
      return handlers.apply(subCommand).generalProcess(args.slice(1, args.length))
    } else {
      return BadCommand
    }
  }

  override def getRequiredNumberOfArgs: Int = RequiredNumberOfArgs

}
