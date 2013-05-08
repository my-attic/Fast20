module workers

import fast.store.MemoryStore

function start_w1 = |request, response| {
	MemoryStore.get("worker1"):send("go")
    response:type("text/html")
    return "worker1 is started, see console"
}

function start_w2 = |request, response| {
    MemoryStore.get("worker2"):send("go"):send("go again"):send("go again and again")
    response:type("text/html")
    return "worker2 is started, see console"
}