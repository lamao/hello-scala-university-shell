package org.vmis.hello.university.model

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
class Student(anId: Int, aName: String, anAge: Int, aPassport: String) extends Person(anId, aName, anAge, aPassport) {

  var group:Group = _


  override def toString:String = {
    var result = super.toString() + ", group: "
    if (group == null) {
      result += "N/A"
    } else {
      result += group.code
    }

    return result
  }
}
