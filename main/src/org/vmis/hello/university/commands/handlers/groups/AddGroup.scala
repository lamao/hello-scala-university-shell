package org.vmis.hello.university.commands.handlers.groups

import org.vmis.hello.university.Storage
import org.vmis.hello.university.commands.handlers.Handler
import org.vmis.hello.university.commands.statuses.{Ok, Status}
import org.vmis.hello.university.model.Group

import scala.io.StdIn

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
object AddGroup extends Handler {
  override def process(args: Array[String]): Status = {
    println("Code: ")
    val code = StdIn.readLine()

    val group = new Group(Storage.getNextGroupId, code)
    Storage.groups ::= group

    println(s"Added group <$group>")

    Ok
  }
}
