package org.vmis.hello.university.commands

/**
  * Created by Vycheslav Mischeryakov on 29.11.16.
  */
trait Logger {
  private val ErrorPattern = "ERROR: %s"


  def error (message:String): Unit = {
    println(ErrorPattern.format(message))
  }

}
