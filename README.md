## Intro

This is a very basic seed project, based on the official [*Hello World*](http://www.scala-js.org/tutorial/basic/) tutorial with the addition of lihaoyi's [workbench](https://github.com/lihaoyi/workbench) for live reload local development. 

## Requirements

This code has been tested on *Ubuntu 14.04* with the following setup

* *java 1.8*

* *sbt 0.13.9*

* *nodejs 4.3.1* (installed from https://nodejs.org/en/download/package-manager/)

* *phantomjs 2.1.1* (installed with `sudo npm install -g phantomjs-prebuilt`)

Additionally, `npm install source-map-support` was added for supporting source maps.

## How to run it

Navigate to the project's root directory and run `sbt` for the SBT console. This will also start the workbench and make your project accessible at http://localhost:12345/index-dev.html

There are a few tasks available in the console:

`fastOptJS` will fast compile the project (target file `*-fastopt.js` used for development)

`run` will run the project in *PhantomJS*

`test` will run the tests of the project in *PhantomJS*

`fullOptJS` will compile the project to fully optimised *JavaScript* (target file `*-opt.js` used for production)

If you want to `run` or `test` with a fully optimised *JavaScript*, type
`set scalaJSStage in Global := FullOptStage` in the console and then start your tasks.

`clean` will clean everything from `target/`

`reload` will reload the project in case `build.sbt` has changed

## Live recompile

While developing, most likely you would want to start the SBT console with `sbt` and then run `~fastOptJS` for auto-compiling the source code when changed and auto-reloading the page http://localhost:12345/index-dev.html in your browser.

## Deploying

Once done with the development, the project is compiled with `fullOptJS` and the following files can be deployed to an HTTP server:

```
index.html
target/scala-2.11/basic-scalajs-webapp-opt.js
target/scala-2.11/basic-scalajs-webapp-launcher.js
target/scala-2.11/basic-scalajs-webapp-jsdeps.js
```

The html file might need to be edited and the `<script>...</script>` tags pointed to the new path of the generated `JavaScript` files.

* `*-opt.js` is the compiled code of the app
* `*-launcher.js` is a boilerplate code to launch the app
* `*-jsdeps.js` contains all *JavaScript* dependencies declared in `build.sbt`

Assets such as `css` files and image files need to be taken care of separately.

## License

[MIT](./LICENSE)