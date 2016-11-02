package org.vmis.hello.university.commands.handlers

import org.vmis.hello.university.commands.statuses.{BadCommand, Ok, Status}

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
class SubHandler(aHandlers: Map[String, Handler]) extends Handler {
  private val handlers = aHandlers

  override def process(args: Array[String]): Status = {
    if (args.isEmpty) {
      return BadCommand
    }

    val subCommand = args(0)
    if (handlers.contains(subCommand)) {
      handlers.apply(subCommand).process(args.slice(1, args.length))
    } else {
      return BadCommand
    }

    Ok
  }
}
