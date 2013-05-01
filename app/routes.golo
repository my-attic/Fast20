module routes

import core.router

function router = |message| {
    println("=== Welcome to Router ===")

    return Routes(
        Route("GET", "/about/html", "/controllers/about.golo", "about_html"),
        Route("GET", "/about/txt", "/controllers/about.golo", "about_txt"),
        Route("GET", "/infos", "/controllers/about.golo", "about"),
        Route("POST", "/infos", "/controllers/about.golo", "about_post")
    )

}