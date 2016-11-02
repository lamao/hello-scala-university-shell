package org.vmis.hello.university.commands.handlers.students

import org.vmis.hello.university.Storage
import org.vmis.hello.university.commands.handlers.Handler
import org.vmis.hello.university.commands.statuses.{Ok, Status}

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
object ListStudents extends Handler {

  override def process(args: Array[String]): Status = {
    println("Students: ")
    val students = Storage.students.sortBy( x => x.id)
    for (student <- students) {
      println(student.toString)
    }

    Ok
  }
}
