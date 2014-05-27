function removeCircularStructure(data) {
	for(var g = 0; g < data.guests.length; g++) {
		var guest = data.guests[g];
		removeCircularStructureAtRelation(guest.loves);
		removeCircularStructureAtRelation(guest.hates);
		removeCircularStructureAtRelation(guest.knows);
	}
	return data;
}

function removeCircularStructureAtRelation(guestList) {
	for(var g = 0; g < guestList.length; g++) {
		guestList[g] = { name: guestList[g].name };
	}
}

/**
 * User service, exposes user model to the rest of the app.
 */
define(["angular", "common"], function(angular) {
  "use strict";

  var mod = angular.module("home.services", ["yourprefix.common"]);
  mod.factory("plannerService", ["$http", "$q", "playRoutes", function($http, $q, playRoutes) {
    var user, token;
    return {
      plan : function(data) {
      	console.dir(data);
      	return playRoutes.controllers.PlannerController.plan().post(removeCircularStructure(data)).then(function(response) {
      		console.log('response', response);
      		var capacitiesAndGuests = response.data;
      		return capacitiesAndGuests;
      	});
      }
    };
  }]);
});
