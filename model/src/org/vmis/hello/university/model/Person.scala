package org.vmis.hello.university.model

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
class Person(id: Int, var name: String, var age: Int, var passport: String) extends Entity(id) {

  override def toString: String = s"ID: $id, Name: $name, age: $age, passport: $passport"
}
