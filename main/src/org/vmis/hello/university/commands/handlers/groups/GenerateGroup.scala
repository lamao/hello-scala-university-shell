package org.vmis.hello.university.commands.handlers.groups

import org.vmis.hello.university.{DataGenerator, Storage}
import org.vmis.hello.university.commands.handlers.Handler
import org.vmis.hello.university.commands.statuses.{Ok, Status}
import org.vmis.hello.university.model.Group

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
object GenerateGroup extends Handler {
  override def process(args: Array[String]): Status = {
    val group = DataGenerator.getRandomGroup
    Storage.groups ::= group

    println(s"Generated group $group")

    Ok
  }
}
