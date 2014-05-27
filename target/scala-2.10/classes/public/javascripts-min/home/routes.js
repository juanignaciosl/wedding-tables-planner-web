/**
 * Home routes.
 */
define(["angular", "./controllers", "common"], function(angular, controllers) {
  "use strict";

  var mod = angular.module("home.routes", ["yourprefix.common"]);
  mod.config(["$routeProvider", function($routeProvider) {
    $routeProvider
      .when("/",  {templateUrl: "/assets/templates/home/home.html", controller:controllers.HomeCtrl})
      .otherwise( {templateUrl: "/assets/templates/home/notFound.html"});
  }]);
  return mod;
});
