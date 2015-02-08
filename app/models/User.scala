package models

import org.joda.time._

import database._

import scala.slick.lifted.TableQuery

import DatabaseDriver.simple._
import scala.slick.lifted.ProvenShape
import com.github.tototoshi.slick.MySQLJodaSupport._

/**
 * User case class denotes a user of the system
 *
 * @param id Primary Key
 * @param email Users email address
 * @param password Users password hash
 * @param created_at Timestamp which this user was created
 * @param updated_at Timestamp which this user was last updated
 * @param deleted_at Timestamp which this user was soft deleted
 */
case class User(id: Option[Int], name: String, email: String, password: String,
                created_at: DateTime, updated_at: DateTime, deleted_at: Option[DateTime])

class Users(tag: Tag) extends Table[(Int, String, String, String, DateTime, DateTime, Option[DateTime])](tag, "users") {
    def id: Column[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def name: Column[String] = column[String]("name")
    def email: Column[String] = column[String]("email")
    def password: Column[String] = column[String]("password")
    def created_at: Column[DateTime] = column[DateTime]("created_at")
    def updated_at: Column[DateTime] = column[DateTime]("updated_at")
    def deleted_at: Column[Option[DateTime]] = column[Option[DateTime]]("deleted_at", O.Nullable)

    def * : ProvenShape[(Int, String, String, String, DateTime, DateTime, Option[DateTime])] =
        (id, name, email, password, created_at, updated_at, deleted_at)
}

object Users {
    def create(u: (Int, String, String, String, DateTime, DateTime, Option[DateTime])): User = {
        User(Some(u._1), u._2, u._3, u._4, u._5, u._6, u._7)
    }
}