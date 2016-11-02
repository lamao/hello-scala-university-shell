package org.vmis.hello.university.commands.handlers

import org.vmis.hello.university.commands.statuses.Status

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
trait Handler {
  def process(args: Array[String]): Status

  def process(): Status = process(new Array[String](0))

}
