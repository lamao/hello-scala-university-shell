package org.vmis.hello.university.commands.handlers.students

import org.vmis.hello.university.Storage
import org.vmis.hello.university.commands.handlers.Handler
import org.vmis.hello.university.commands.statuses.{Ok, Status}
import org.vmis.hello.university.model.Student

import scala.io.StdIn

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
object AddStudent extends Handler {

    override def process(args: Array[String]): Status = {
      print("Name: ")
      val name = StdIn.readLine()
      print("Age: ")
      val age = StdIn.readLine()
      print("Passport: ")
      val passport = StdIn.readLine()

      val student = new Student(Storage.getNextPersonId, name, age.toInt, passport)
      Storage.students ::= student

      println(s"Added student <$student>")

      Ok
    }

}
