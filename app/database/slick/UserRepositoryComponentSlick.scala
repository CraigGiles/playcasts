package database.slick

import models.{Users, User}
import database.UserRepositoryComponent
import database.slick.tables.Users
import database.DatabaseDriver.simple._
import scala.slick.lifted.TableQuery

trait UserRepositoryComponentSlick extends UserRepositoryComponent {
  def userRepository = new SlickUserRepository

  class SlickUserRepository extends UserRepository with Slickable {
    lazy val usersTbl = TableQuery[Users]

    override def findById(id: Int): Option[User] = {
      database withSession { implicit session =>
        val byId = usersTbl.findBy(_.id)
        byId(Some(id)).list.headOption
      }
    }

    override def save(user: User): Unit = {
      database withSession { implicit session =>
        usersTbl.insert(user)
      }
    }

    override def findByEmail(email: String): Option[User] = {
      database withSession { implicit session =>
        val byId = usersTbl.findBy(_.email)
        byId(email).list.headOption
      }
    }

  }
}
