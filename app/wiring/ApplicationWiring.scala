package wiring

import repositories.users.sql.UserRepositoryComponentSlick
import services.UserServiceComponent

object ApplicationWiring {
  val userServiceComponent = new UserServiceComponent with UserRepositoryComponentSlick {
    //expresses dependencies
    override def repository: UserRepository = new DefaultUserRepository
  }

  def getUserService = userServiceComponent.service
}
