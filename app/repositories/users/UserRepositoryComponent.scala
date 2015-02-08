package repositories.users

import models.User

trait UserRepositoryComponent { //expresses dependencies
  def repository: UserRepository //obtains the instance

  trait UserRepository { //interface exposed to user
    def find(id: Int): User
    def save(user: User): Unit
  }
}
