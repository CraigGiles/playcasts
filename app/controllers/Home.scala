package controllers

import play.api._
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

        val usr = service.find(1)
        println(usr)

        val u = usr.getOrElse("Bob")


//        import models._
////        val user = User.findByEmail("craig@gilesc.com")
//        val id = User.insert
//        val user = User.findAll
//        println(user)
        Ok("hello " + u)
    }
}
