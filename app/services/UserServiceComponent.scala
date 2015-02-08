package services

import database.UserRepositoryComponent
import models.User

trait UserServiceComponent {
  this: UserRepositoryComponent =>

  val service: UserService = new UserService

  class UserService {
    def find(id: Int): Option[User] = repository.findById(id)
    def findByEmail(email: String): Option[User] = repository.findByEmail(email)
    def save(user: User): Unit = repository.save(user)
  }
}
