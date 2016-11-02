package org.vmis.hello.university

import org.vmis.hello.university.model.{Group, Student}


/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
object DataGenerator {

  private val firstNames = Array("John", "Edward", "Robert", "Sarah", "Jane", "Bill", "Kate", "Garry")
  private val lastNames = Array("Smith", "White", "Black", "Potter", "Holmes", "Bloom", "Miller")

  def getRandomGroup: Group = {
    val code = Math.round(Math.random() * 9000) + 1000

    new Group(Storage.getNextGroupId, code.toString)
  }

  def getRandomStudent: Student = {
    val firstName = firstNames(Math.round(Math.random() * (firstNames.length - 1)).toInt)
    val lastName = lastNames(Math.round(Math.random() * (lastNames.length - 1)).toInt)
    val age = (Math.round(Math.random() * 15) + 10).toInt
    val passport = "GN" + (Math.round(Math.random() * 9000) + 1000)

    new Student(Storage.getNextPersonId, s"$firstName $lastName", age, passport)
  }

}
