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
        videos.list.map(v => Videos.create(v))
      }
    }

    override def findById(id: Int): Option[Video] = {
      database withSession { implicit session =>
        val vids = videos.list.find(v => v._1 == Some(id))
        vids.map(v => Videos.create(v))
      }
    }

    override def findByAuthor(author: String): Seq[Video] = {
      all.filter(v => v.author == author)
    }

    override def findByTitle(title: String): Seq[Video] = {
      all.filter(v => v.title == title)
    }

    override def save(video: Video): Unit = {
    }

  }
}
