package org.vmis.hello.university.model

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
class Student(id: Int, name: String, age: Int, passport: String) extends Person(id, name, age, passport) {

  var group:Group = _


  override def toString:String = {
    var result = super.toString() + ", group: "
    if (group == null) {
      result += "N/A"
    } else {
      result += group.code
    }

    result
  }
}
