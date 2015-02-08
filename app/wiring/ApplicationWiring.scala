package wiring

import repositories.users.sql.UserRepositorySqlComponent
import services.DefaultUserServiceComponent

object ApplicationWiring {
  val userServiceComponent = new DefaultUserServiceComponent with UserRepositorySqlComponent {
    //expresses dependencies
    override def repository: UserRepository = new UserRepositoryImpl
  }

  def getUserService = userServiceComponent.service
}
