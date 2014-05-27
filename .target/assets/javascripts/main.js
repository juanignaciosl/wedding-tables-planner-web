(function(requirejs) {
  "use strict";

  // -- DEV RequireJS config --
  requirejs.config({
    // Packages = top-level folders; loads a contained file named "main.js"
    packages: ["common", "home" ],
    shim: {
      "jsRoutes" : {
        deps : [],
        // it's not a RequireJS module, so we have to tell it what var is returned
        exports : "jsRoutes"
      },
      "ngDragDrop": {
      	deps: ["angular"]
      }
    },
    paths: {
      "jsRoutes" : "/jsroutes",
      "ngDragDrop": "/assets/javascripts/third/dragandrop/draganddrop"
    }
  });

  requirejs.onError = function(err) {
    console.log(err);
  };

  // Load the app. This is kept minimal so it doesn't need much updating.
  require(["angular", "angular-cookies", "angular-route", "jquery", "bootstrap", "./app", "ngDragDrop"],
    function(angular) {
      angular.bootstrap(document, ["app"]);
    }
  );
})(requirejs);
