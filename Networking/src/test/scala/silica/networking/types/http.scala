package silica.networking.types


import org.scalatest._
import argonaut._, Argonaut._

import HttpDefs._


class HttpSpec extends FlatSpec with Matchers {
    "MyInfo" should "parse example json" in {
        val json = """{
            "_id": "57874d42d0ae911e3bd15bbc",
            "badge": {
                "color1": "#260d0d",
                "color2": "#6b2e41",
                "color3": "#ffe56d",
                "flip": false,
                "param": -100,
                "type": 21
            },
            "cpu": 170,
            "credits": 0,
            "email": "daboross@daboross.net",
            "gcl": 571069296,
            "github": {
                "id": "1152146",
                "username": "daboross"
            },
            "lastRespawnDate": 1475270405700,
            "money": 3957697.9500000584,
            "notifyPrefs": {
                "errorsInterval": 0
            },
            "ok": 1,
            "password": true,
            "promoPeriodUntil": 1471635211172,
            "steam": {
                "displayName": "daboross",
                "id": "76561198033802814",
                "ownership": [
                    464350
                ]
            },
            "subscription": true,
            "subscriptionTokens": 0,
            "username": "daboross"
        }"""

        val parsed: Either[Either[String,(String, argonaut.CursorHistory)], MyInfo] = json.decode[MyInfo]

        parsed should matchPattern { case MyInfo(1, _, _, _, _, _, _, _) => }
    }
}