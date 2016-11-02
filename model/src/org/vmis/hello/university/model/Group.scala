package org.vmis.hello.university.model

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
class Group (anId: Int, aCode: String) extends Entity(anId) {

  var code:String = aCode
  var students:List[Student] = List()

  override def toString: String = s"ID: $id, Code: $code"
}
