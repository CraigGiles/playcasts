package models

import org.joda.time._
import org.joda.time.format._

import play.api.db.DB
import play.api.Play.current

import anorm.~
import anorm._
import anorm.SqlParser._
import java.sql._
import utilities.AnormExtension._

import models.parsers.UserParser._

case class User(id: Long, name: String, email: String, password: String, 
    created_at: DateTime, updated_at: DateTime, deleted_at: Option[DateTime])

object User {
    def findAll: Seq[User] = DB.withConnection { implicit connection =>
        SQL("select * from users").as(usersParser)
    }
    
    def findByEmail(email: String): Option[User] = DB.withConnection { implicit connection =>
        SQL("select * from users where email={value}")
            .on("value" -> email)
            .as(usersParser)
            .headOption
    }

}

