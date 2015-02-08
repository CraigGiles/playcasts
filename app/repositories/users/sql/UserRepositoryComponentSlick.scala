package repositories.users.sql

import models.User
import org.joda.time.DateTime
import repositories.users.UserRepositoryComponent

trait UserRepositoryComponentSlick extends UserRepositoryComponent {
  def userRepository = new DefaultUserRepository

  class DefaultUserRepository extends UserRepository {
    override def find(id: Int): User = {
      User(1, "Craig Giles", "craig@gilesc.com", "aosdgfoaf38faodsbouy131oasjbdf", new DateTime(), new DateTime(), None)
    }

    override def save(user: User): Unit = {
      println("Saved user: " + user.name)
    }
  }
}