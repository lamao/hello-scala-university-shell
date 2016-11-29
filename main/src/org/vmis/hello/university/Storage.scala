package org.vmis.hello.university

import org.vmis.hello.university.model.{Group, Student}

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
object Storage {

  private var lastPersonId = 0
  private var lastGroupId = 0


  var students: List[Student] = List(
    DataGenerator.getRandomStudent,
    DataGenerator.getRandomStudent,
    DataGenerator.getRandomStudent,
    DataGenerator.getRandomStudent,
    DataGenerator.getRandomStudent
  )
  var groups: List[Group] = List(
    DataGenerator.getRandomGroup,
    DataGenerator.getRandomGroup,
    DataGenerator.getRandomGroup
  )

  def getNextPersonId: Int = {
    lastPersonId += 1
    lastPersonId
  }

  def getNextGroupId: Int = {
    lastGroupId += 1
    lastGroupId
  }

  def findStudent(id: Int): Option[Student] = {
    students.find({s: Student => s.id == id})
  }

  def findGroup(id: Int): Option[Group] = {
    groups.find({g: Group => g.id == id})
  }

}
