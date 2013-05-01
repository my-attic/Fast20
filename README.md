# Fast 2.0

Fast 2.0 is a high productivity Java and [Golo](http://golo-lang.org/) Web application framework, integrating all components and API needed for modern Web application development.

## Installing

You first need to build Fast :

```bash
$ cd Fast20/
$ mvn compile assembly:single
```

Then, copy `/distribution/fast2.x.x.jar` to a directory

## Getting started (temporary)

- create a directory (ie `myapp`) and copy `fast2.x.x.jar` to it

### Generate the application skeleton

```bash
$ cd myapp
$ java -jar fast2.x.x.jar new
```
> The application is generated. You can change parameters with `app/parameters.golo`

### Run the application

```bash
$ cd myapp
$ java -jar fast2.x.x.jar
```
> The application will be available on port 8080.

Or you can run all from your ide

## Issues tracker

Report issues at [https://github.com/k33g/Fast20/issues](https://github.com/k33g/Fast20/issues).

## Contributors

Check for all contributors at [https://github.com/k33g/Fast20/graphs/contributors](https://github.com/k33g/Fast20/graphs/contributors).

## Licence

This software is licensed under the Apache 2 license, quoted below.

Copyright 2013 K33G_ORG ([https://twitter.com/k33g_org](https://twitter.com/k33g_org)).

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this project except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
