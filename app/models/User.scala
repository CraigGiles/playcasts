package models

import org.joda.time._
import org.joda.time.format._

import play.api.db.DB
import play.api.Play.current

import anorm._
import anorm.SqlParser._
import java.sql._
import utilities.AnormExtension._

case class User(id: Long, name: String, email: String, password: String, 
    created_at: DateTime, updated_at: DateTime, deleted_at: DateTime)

object User {
    def findAll: Seq[User] = DB.withConnection { 
        implicit connection =>
        SQL("select * from users").map( row =>
            User(row[Long]("id"), row[String]("name"), row[String]("email"), 
                 row[String]("password"), row[DateTime]("created_at"), 
                 row[DateTime]("updated_at"), row[DateTime]("deleted_at"))
        ).list
    }
}

//param: Option[String] = None
