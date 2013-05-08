module routes

import core.router

function router = |message| {
    println("=== Welcome to Router ===")

    return Routes(
        Route("GET", "/about/html", "/controllers/about.golo", "about_html"),
        Route("GET", "/about/txt", "/controllers/about.golo", "about_txt"),
        Route("GET", "/infos", "/controllers/about.golo", "about"),
        Route("POST", "/infos", "/controllers/about.golo", "about_post"),
        Route("POST", "/redis", "/controllers/redisdb.golo", "create"),
        Route("GET", "/redis/:key", "/controllers/redisdb.golo", "fetch"),
        Route("GET", "/sandbox", "/controllers/sandbox.golo", "Test::hello"),
        Route("POST", "/sandbox", "/controllers/sandbox.golo", "Test::hi"),
        Route("POST", "/fileupload", "/controllers/upload.golo", "upload"),
        Route("GET","/startw1","/controllers/workers.golo", "start_w1"),
        Route("GET","/startw2","/controllers/workers.golo", "start_w2"),
        Route("GET","/42","/controllers/plugins.golo", "tests")
    )

}