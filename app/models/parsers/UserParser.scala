package models.parsers

import anorm.~
import anorm._
import anorm.SqlParser._
import org.joda.time._
import org.joda.time.format._

import models.User

object UserParser {
    val userParser : RowParser[User] = {
        long("id") ~
        str("name") ~
        str("email") ~
        str("password") ~
        date("created_at") ~
        date("updated_at") ~
        get[Option[String]]("deleted_at") map { 
            case id ~ name ~ email ~ password ~ created_at ~ updated_at ~ deleted_at =>
                User(id, name, email, password, new DateTime(created_at), new DateTime(updated_at), optionalDate(deleted_at))
        }
    }

    val usersParser: ResultSetParser[List[User]] = { 
        userParser *
    }

    private def optionalDate(value: Option[String]) : Option[DateTime] = {
        if (value == None) None else Some(new DateTime(value))
    }
}
