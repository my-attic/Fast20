module upload

import java.util.HashMap

import fast.json.Json
import fast.streams.SimpleFileUpload

function upload = |request, response| {

    #println("uploading..."+request:body())

    let f = SimpleFileUpload()
                :doPost(
                    request, response, "/uploads"
                )

    response:type("application/json")

    return Json.stringify(
        Json.toJson(
            HashMap():add("UploadedFile",f:filesList())
        )
    )

}

