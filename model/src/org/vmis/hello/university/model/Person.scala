package org.vmis.hello.university.model

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
class Person(anId: Int, aName: String, anAge: Int, aPassport: String) extends Entity(anId) {

  var name:String = aName
  var age:Int = anAge
  var passport:String = aPassport

  override def toString: String = s"ID: $id, Name: $name, age: $age, passport: $passport"


}
