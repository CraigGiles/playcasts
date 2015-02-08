package wiring

import database.slick.UserRepositoryComponentSlick
import services.UserServiceComponent

object ApplicationWiring {
  val userServiceComponent = new UserServiceComponent with UserRepositoryComponentSlick {
    //expresses dependencies
    override def repository: UserRepository = new SlickUserRepository
  }

  def getUserService = userServiceComponent.service
}
