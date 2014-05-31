/**
 * Common functionality.
 */
define(["angular", "./services/playRoutes", "./filters", "./directives/example"],
    function(angular) {
  "use strict";

  return angular.module("yourprefix.common", ["common.playRoutes", "common.filters",
    "common.directives.example"]);
});
