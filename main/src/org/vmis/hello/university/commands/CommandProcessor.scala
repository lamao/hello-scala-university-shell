package org.vmis.hello.university.commands

import org.vmis.hello.university.commands.handlers.groups.{AddGroup, GenerateGroup, ListGroups}
import org.vmis.hello.university.commands.handlers.students.{AddStudent, GenerateStudent, ListStudents, UpdateStudent}
import org.vmis.hello.university.commands.handlers.system.{Exit, Help}
import org.vmis.hello.university.commands.handlers.{Handler, SubHandler}
import org.vmis.hello.university.commands.statuses.{BadCommand, Error, Ok, Status}

import scala.io.StdIn

/**
  * Created by Vycheslav Mischeryakov on 01.11.16.
  */
object CommandProcessor {

  private val EXIT_COMMAND = "exit"
  private val PROMPT = "> "
  private val SEPARATOR = " "

  private def handlers:Map[String, Handler] = Map(
    "help" -> Help,
    "exit" -> Exit,
    "students" -> new SubHandler(Map(
      "list" -> ListStudents,
      "add" -> AddStudent,
      "update" -> UpdateStudent,
      "generate" -> GenerateStudent
    )),
    "groups" -> new SubHandler(Map(
      "list" -> ListGroups,
      "add" -> AddGroup,
      "generate" -> GenerateGroup
    ))
  )

  /**
    * Run the processor
    */
  def run(): Unit = {

    while (true) {
      print(PROMPT)
      val line = StdIn.readLine()
      if (line.startsWith(EXIT_COMMAND)) {
        handlers.apply(EXIT_COMMAND).generalProcess()
        return
      } else {
        val status = processLine(line)
        if (status.eq(BadCommand)) {
          println(s"Command <$line> is not a proper command")
        } else if (!status.eq(Ok)) {
          println(s"Some problems occurred during executing command. Returning status is ${status.getClass.getTypeName}")
        }
      }
    }
  }

  /**
    * Process one line, inputted by user
    * @param line - string line from user input
    * @return
    */
  private def processLine(line: String): Status = {
    val tokens = line.split(SEPARATOR)
    if (tokens.isEmpty) {
      return Error
    } else {
      val handler = handlers.get(tokens(0))
      if (handler.eq(None)) {
        return BadCommand
      }
      return handler.get.generalProcess(tokens.slice(1, tokens.length))
    }
  }

  def getAvailableCommands: Iterable[String] = handlers.keys

}
