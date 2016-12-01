package org.vmis.hello.university.commands.handlers.students

import org.vmis.hello.university.Storage
import org.vmis.hello.university.commands.Logger
import org.vmis.hello.university.commands.handlers.Handler
import org.vmis.hello.university.commands.statuses.{Error, Ok, Status}

import scala.io.StdIn

/**
  * Created by Vycheslav Mischeryakov on 10.11.16.
  */
object UpdateStudent extends Handler {
  private val RequiredNumberOfArgs = 1

  override def process(args: Array[String]): Status = {
    val id = args(0).toInt

    val studentOption = Storage.findStudent(id)
    if (studentOption.isEmpty) {
      println(s"Student #$id not found")
      return Error
    }

    val student = studentOption.get
    println("Input new values for student. Press <Enter> to no change field")
    print(s"Name (${student.name}): ")
    val name = StdIn.readLine()
    if (!name.isEmpty) {
      student.name = name
    }

    print(s"Age (${student.age}): ")
    val age = StdIn.readLine()
    if (!age.isEmpty) {
      student.age = age.toInt
    }
    print(s"Passport (${student.passport}): ")
    val passport = StdIn.readLine()
    if (!passport.isEmpty) {
      student.passport = passport
    }

    println(s"Student updated <$student>")

    Ok
  }

  override def getRequiredNumberOfArgs: Int = RequiredNumberOfArgs
}
