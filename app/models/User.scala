package models

import org.joda.time._
import org.joda.time.format._

import play.api.db.DB
import play.api.Play.current

import anorm.~
import anorm._
import anorm.SqlParser._
import java.sql._
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException

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

    def insert: Option[Long] = DB.withConnection { implicit connection => 
        val sqlQuery = SQL(
            """
            INSERT INTO users(name, email, password, created_at, updated_at)
            VALUES({name}, {email}, {password}, {created_at}, {updated_at})
            """
        )

        try {
            sqlQuery.on("name" -> "cgiles", "email" -> "email", "password" -> "password", 
                        "created_at" -> new DateTime(), "updated_at" -> new DateTime())
                    .executeInsert()
        } catch {
            case e:MySQLIntegrityConstraintViolationException => { println("MySQL Constraint: " + e); None } 
            case e:Exception => { println(e); None } 
        }

    }
}

