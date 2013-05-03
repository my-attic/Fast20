module parameters

#Parameters
function parameters = |message| -> DynamicObject()
	:http(8080)
	:publicDir("public")
	:redis("localhost")
	:redisPort(6379)