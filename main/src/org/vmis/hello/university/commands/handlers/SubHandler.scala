package org.vmis.hello.university.commands.handlers

import org.vmis.hello.university.commands.statuses.{BadCommand, Ok, Status}

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
class SubHandler(handlers: Map[String, Handler]) extends Handler {

  private val RequiredNumberOfArgs = 1

  override def process(args: Array[String]): Status = {
    val subCommand = args(0)

    var result:Status = BadCommand
    if (handlers.contains(subCommand)) {
      result = handlers.apply(subCommand).generalProcess(args.slice(1, args.length))
    }

    result
  }

  override def getRequiredNumberOfArgs: Int = RequiredNumberOfArgs

}
