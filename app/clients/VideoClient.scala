package clients

import services.VideoServiceComponent
import database.slick.{VideoRepositoryComponentSlick, UserRepositoryComponentSlick}

object VideoClient {
  val videoServiceComponent = new VideoServiceComponent with VideoRepositoryComponentSlick {
    override def repository = new SlickVideoRepository
  }

  def get = videoServiceComponent.service
}
