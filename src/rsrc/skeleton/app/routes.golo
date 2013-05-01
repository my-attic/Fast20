module routes

import core.router

function router = |message| {
    println("=== Welcome to Router ===")

    return Routes(
        Route("GET", "/infos", "/controllers/about.golo", "about")
    )

}