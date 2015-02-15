package database.slick

import models.{Videos, Video}
import database.VideoRepositoryComponent
import database.DatabaseDriver.simple._
import database.slick.tables.Videos

import scala.slick.lifted.TableQuery

trait VideoRepositoryComponentSlick extends VideoRepositoryComponent {
  def videoRepository = new SlickVideoRepository

  class SlickVideoRepository extends VideoRepository with Slickable {
    lazy val videos = TableQuery[Videos]

    def all(): Seq[Video] = {
      database withSession { implicit session =>
        videos.list
      }
    }

    override def findById(id: Int): Option[Video] = {
      database withSession { implicit session =>
        val byId = videos.findBy(_.id)
        byId(id).list.headOption
      }
    }

    override def findByAuthor(author: String): Seq[Video] = {
      database withSession { implicit session =>
        val byId = videos.findBy(_.author)
        byId(author).list
      }
    }

    override def findByTitle(title: String): Seq[Video] = {
      database withSession { implicit session =>
        val byId = videos.findBy(_.title)
        byId(title).list
      }
    }

    override def save(video: Video): Unit = {
    }

  }
}
