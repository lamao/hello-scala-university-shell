package org.vmis.hello.university.model

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
class Group (id: Int, var code: String) extends Entity(id) {

  var students:List[Student] = List()

  override def toString: String = s"ID: $id, Code: $code"
}
