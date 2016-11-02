package org.vmis.hello.university.commands.handlers.students

import org.vmis.hello.university.{DataGenerator, Storage}
import org.vmis.hello.university.commands.handlers.Handler
import org.vmis.hello.university.commands.statuses.{Ok, Status}
import org.vmis.hello.university.model.Student

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
object GenerateStudent extends Handler {
  override def process(args: Array[String]): Status = {
    val student = DataGenerator.getRandomStudent
    Storage.students ::= student

    println(s"Generated student <$student>")
    Ok
  }
}
