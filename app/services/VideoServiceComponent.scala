package services

import database.VideoRepositoryComponent

trait VideoServiceComponent {
  this: VideoRepositoryComponent =>

  val service: VideoService = new VideoService

  class VideoService {
//    def find(id: Int): Option[User] = repository.findById(id)
//    def findByEmail(email: String): Option[User] = repository.findByEmail(email)
//    def save(user: User): Unit = repository.save(user)
  }
}
