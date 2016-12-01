package org.vmis.hello.university.commands.handlers

import java.lang.IllegalArgumentException

import org.vmis.hello.university.commands.Logger
import org.vmis.hello.university.commands.statuses._

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
trait Handler extends Logger {
  private val IllegalCountOfArgumentsPattern = "Illegal count of arguments. Must be at least <%d>, actual <%d>"

  def generalProcess(args: Array[String]): Status = {
      try {
        validateArgsCount(args)
      } catch {
        case e: IllegalArgumentException => error(IllegalCountOfArgumentsPattern.format(getRequiredNumberOfArgs, args.length))
          return IllegalArguments
      }
      process(args)
  }

  def generalProcess(): Status = generalProcess(new Array[String](0))

  def process(args: Array[String]) : Status

  def validateArgsCount(args: Array[String]) : Unit = {
    if (args.length < getRequiredNumberOfArgs) {
      throw new IllegalArgumentException
    }
  }

  def getRequiredNumberOfArgs: Int = {0}

}
