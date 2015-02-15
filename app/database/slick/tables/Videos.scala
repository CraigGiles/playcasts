package database.slick.tables

import models.Video
import org.joda.time.DateTime
import database.DatabaseDriver.simple._
import com.github.tototoshi.slick.MySQLJodaSupport._

class Videos(tag: Tag) extends Table[Video](tag, "videos") {
  def id: Column[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def title: Column[String] = column[String]("title")
  def author: Column[String] = column[String]("author")
  def link: Column[String] = column[String]("link")
  def created_at: Column[DateTime] = column[DateTime]("created_at")
  def updated_at: Column[DateTime] = column[DateTime]("updated_at")
  def deleted_at: Column[Option[DateTime]] = column[Option[DateTime]]("deleted_at", O.Nullable)

  def * = (id, title, author, link, created_at, updated_at, deleted_at) <> ((Video.apply _).tupled, Video.unapply)
}

