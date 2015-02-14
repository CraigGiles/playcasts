package clients

import database.slick.{VideoRepositoryComponentSlick, UserRepositoryComponentSlick}
import database.UserRepositoryComponent
import services.UserServiceComponent

object UserClient {
  val userServiceComponent = new UserServiceComponent with UserRepositoryComponentSlick {
    override def repository = new SlickUserRepository
  }

  def get = userServiceComponent.service
}
