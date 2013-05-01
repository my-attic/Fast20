#fast.jgolo.KlassLoader

cf. [https://github.com/k33g/jgolo](https://github.com/k33g/jgolo)

    JGoloKlassLoader k = new JGoloKlassLoader((new File("")).getAbsolutePath());
    k.loadAll();
    Object params = null;

    k.module("/scripts/main.golo").method("main", Object.class).run("");

    System.out.println(
            k.module("/scripts/libs/core.golo").method("hello", Object.class).run(params)
    );

    System.out.println(
            k.module("/scripts/libs/extensions.golo").method("hello", Object.class).run(params)
    );

    System.out.println(
            k.module("/scripts/libs/core.golo").method("add", Object.class, Object.class).run(4,5)
    );