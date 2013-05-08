module boot

import fast.store.MemoryStore

import java.lang.Thread
import java.util.concurrent
import gololang.concurrent.workers.WorkerEnvironment

function initialize  = |args| {
    println("=== booting application ===")

    println("- define WorkerEnvironment")
	let enHouse = WorkerEnvironment.builder(): withCachedThreadPool()

    println("- define worker1")
	let worker1 = enHouse:spawn(|message| {
		println("w1 : " + message)
		foreach (i in range(0, 30)) {
			println("w1 : " + i)
			Thread.sleep(1000_L)
		}

	})

    println("- define worker2")
	let worker2 = enHouse:spawn(|message| {
		println(message)
		foreach (i in range(0, 30)) {
			println("w2 : " +i)
			Thread.sleep(1000_L)
		}

	})

    MemoryStore.set("enHouse", enHouse)
    MemoryStore.set("worker1", worker1)
    MemoryStore.set("worker2", worker2)


    MemoryStore.each(|key, StoredValue| {
       println("---> key : " + key)
    })


}
