package database

import models.User

trait UserRepositoryComponent {
  def repository: UserRepository

  trait UserRepository {
    def findById(id: Int): Option[User]
    def findByEmail(email: String): Option[User]
    def save(user: User): Unit
  }
}
