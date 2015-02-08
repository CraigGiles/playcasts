package models

import org.joda.time._

/**
 * User case class denotes a user of the system
 *
 * @param id Primary Key
 * @param email Users email address
 * @param password Users password hash
 * @param created_at Timestamp which this user was created
 * @param updated_at Timestamp which this user was last updated
 * @param deleted_at Timestamp which this user was soft deleted
 */
case class User(id: Option[Int],
                name: String,
                email: String,
                password: String,
                created_at: DateTime,
                updated_at: DateTime,
                deleted_at: Option[DateTime])


object Users {
    def create(u: (Option[Int], String, String, String, DateTime, DateTime, Option[DateTime])) = User.tupled(u)
}