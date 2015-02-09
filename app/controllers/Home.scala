package controllers

import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import services.ServiceWiring

object Home extends Controller {

    def index = Action {
        Ok(views.html.home.index())
    }

    def about = Action {
        Ok(views.html.home.about())
    }

    def contact = Action {
        Ok(views.html.home.contact())
    }

    def addUser = Action {
        val service = ServiceWiring.getUserService
        val videos = ServiceWiring.getVideoService

        val usr = service.find(1)
        val all = videos.getAllVideos()

        val u = usr.getOrElse("Bob")

        val json = all.map(video => Json.obj(
            "id" -> video.id,
            "title" -> video.title,
            "author" -> video.author,
            "link" -> video.link,
            "created_at" -> video.created_at,
            "updated_at" -> video.updated_at,
            "deleted_at" -> video.deleted_at
        ))

        Ok(json.toString())
    }
}
