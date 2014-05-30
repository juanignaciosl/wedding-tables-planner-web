/**
 * Main, shows the start page and provides controllers for the header and the footer.
 * This the entry module which serves as an entry point so other modules only have to include a
 * single module.
 */
define(["angular", "./routes", "./controllers", "./services"], function(angular, routes, controllers) {
  "use strict";

  var mod = angular.module("yourprefix.home", ["ngRoute", "home.routes", "home.services", "ngDragDrop"]);
  return mod;
});
