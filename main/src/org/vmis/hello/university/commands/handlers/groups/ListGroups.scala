package org.vmis.hello.university.commands.handlers.groups

import org.vmis.hello.university.Storage
import org.vmis.hello.university.commands.handlers.Handler
import org.vmis.hello.university.commands.statuses.{Ok, Status}

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
object ListGroups extends Handler {
  override def process(args: Array[String]): Status = {
    println("Groups: ")
    val groups = Storage.groups.sortBy(x => x.id)
    for (group <- groups) {
      println(group.toString)
    }

    Ok
  }
}
