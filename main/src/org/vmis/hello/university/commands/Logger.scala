package org.vmis.hello.university.commands

/**
  * Created by Vycheslav Mischeryakov on 29.11.16.
  */
trait Logger {
  private val ErrorPattern = "ERROR: %s"
  private val WarningPattern = "WARNING: %s"
  private val InfoPattern = "INFO: %s"
  private val LogPattern = "%s"


  def error (message:String): Unit = {
    println(ErrorPattern.format(message))
  }

  def warn(message:String): Unit = {
    println(WarningPattern.format(message))
  }

  def info(message:String): Unit = {
    println(InfoPattern.format(message))
  }

  def log(message:String): Unit = {
    LogPattern.format(message)
  }

}
