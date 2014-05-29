function addToRelation(list, other) {
	if (list.indexOf(other) == -1) {
		list.push(other);
	}
}

function removeFromRelation(list, other) {
	list.splice(list.indexOf(other), 1);
}

var findGuest = function(guests, guestName) {
	return guests.filter(function(element) {
		return element.name == guestName;
	})[0];
}

var guest = function(spec) {
	return {
		name : spec.name,
		loves : [],
		hates : [],
		knows : [],
		addKnown : function(other) {
			addToRelation(this.knows, other);
		},
		removeKnown : function(other) {
			removeFromRelation(this.knows, other);
		},
		addHated : function(other) {
			addToRelation(this.hates, other);
		},
		removeHated : function(other) {
			removeFromRelation(this.hates, other);
		},
		addLoved : function(other) {
			addToRelation(this.loves, other);
		},
		removeLoved : function(other) {
			removeFromRelation(this.loves, other);
		}
	}
}

function cloneGuestsData(guests) {
	var clonedGuests = [];
	for (var g = 0; g < guests.length; g++) {
		var aGuest = guests[g];
		var cloned = guest(aGuest);
		clonedGuests.push(cloned);
	}
	for (var g = 0; g < guests.length; g++) {
		var aGuest = guests[g];
		cloneGuestRelationships(aGuest, clonedGuests, findGuest(clonedGuests, aGuest.name));
	}
	return clonedGuests;
}

function cloneGuestRelationships(sourceGuest, clonedGuests, targetGuest) {
	cloneGuestArray(sourceGuest.loves, clonedGuests, targetGuest.loves);
	cloneGuestArray(sourceGuest.hates, clonedGuests, targetGuest.hates);
	cloneGuestArray(sourceGuest.knows, clonedGuests, targetGuest.knows);
};

function cloneGuestArray(sourceList, clonedGuests, targetList) {
	for (var g = 0; g < sourceList.length; g++) {
		var guest = sourceList[g];
		targetList.push(findGuest(clonedGuests, guest.name));
	}
}

var group = function(spec) {
	return {
		name : spec.name,
		readOnly : spec.readOnly === true,
		guests : [],
		addGuest : function(guest) {
			if (this.guests.map(function(element) {
				return element.name;
			}).indexOf(guest.name) == -1) {
				this.guests.push(guest);
				return true;
			} else {
				return false;
			}
		},
		removeGuest : function(guest) {
			this.guests.splice(this.guests.indexOf(guest), 1);
		}
	}
}

/**
 * Home controllers.
 */
define([ "angular" ], function(angular) {
	"use strict";

	/** Controls the index page */
	var HomeCtrl = function($scope, $rootScope, $location, plannerService) {

		$scope.newGuestName = '';
		$scope.newGuestGroupName = '';

		$scope.newTable = 5;
		$scope.tables = [];

		var allGuestsGroup = group({
			name : 'All guests',
			readOnly : true
		});
		$scope.allGuestsGroup = allGuestsGroup;

		$scope.guestGroups = [];
		var selectedGuestGroups = [];

		$scope.addTable = function() {
			$scope.tables.push($scope.newTable);
		};

		$scope.removeTable = function(table) {
			$scope.tables.splice($scope.tables.indexOf(group), 1);
		};

		$scope.addGuest = function() {
			if($scope.newGuestName === '') {
				alert('You must enter a guest name');
				return false;
			}
			
			var newGuest = guest({
				name : $scope.newGuestName
			});
			if (allGuestsGroup.addGuest(newGuest)) {
				for (var sgg = 0; sgg < selectedGuestGroups.length; sgg++) {
					selectedGuestGroups[sgg].addGuest(newGuest);
				}
			} else {
				alert('That guest name is already registered');
			}
			$scope.newGuestName = '';
		};

		$scope.$on('removeGuest', function(event, guest, group) {
			if (group === allGuestsGroup) {
				allGuestsGroup.removeGuest(guest);
				for (var gg = 0; gg < $scope.guestGroups.length; gg++) {
					$scope.guestGroups[gg].removeGuest(guest);
				}
			} else {
				group.removeGuest(guest);
			}
		});
		
		$scope.$on('addGuestToGroup', function(event, guestName, group) {
			group.addGuest(findGuest(allGuestsGroup.guests, guestName));
		});

		$scope.$on('guestsRelationship', function(event, guestName, targetGuest) {
			$scope.sourceGuest = findGuest(allGuestsGroup.guests, guestName);
			$scope.targetGuest = targetGuest;
			$('#guest-relationship-modal').modal();
		});

		$scope.addRelationship = function(relationship) {
			switch (relationship) {
			case 'loves':
				$scope.sourceGuest.addLoved($scope.targetGuest);
				$scope.targetGuest.addLoved($scope.sourceGuest);
				break;
			case 'hates':
				$scope.sourceGuest.addHated($scope.targetGuest);
				$scope.targetGuest.addHated($scope.sourceGuest);
				break;
			case 'knows':
				$scope.sourceGuest.addKnown($scope.targetGuest);
				$scope.targetGuest.addKnown($scope.sourceGuest);
				break;
			}
			$('#guest-relationship-modal').modal('hide');
		}

		$scope.addGuestGroup = function() {
			if($scope.newGuestGroupName === '') {
				alert('You must enter a guest group name');
				return false;
			}
			
			$scope.guestGroups.push(group({
				name : $scope.newGuestGroupName
			}));
			$scope.newGuestGroupName = '';
		};

		$scope.$on('selectGroup', function(event, group) {
			selectedGuestGroups.push(group);
		});

		$scope.$on('deselectGroup', function(event, group) {
			selectedGuestGroups.splice(selectedGuestGroups.indexOf(group), 1);
		});

		$scope.arrangeGuests = function() {
			if ($scope.allGuestsGroup.guests.length == 0) {
				alert("You must enter some guests");
			} else if ($scope.tables.length == 0) {
				alert("You must enter some tables");
			} else {
				$('#waiting-modal').modal({
					backdrop : 'static',
					keyboard : false
				});
				plannerService.plan(guestsAndTables()).then(function(response) {
					$scope.capacitiesAndGuests = response;
					$('#waiting-modal').modal('hide');
				});
			}
		};

		var guestsAndTables = function() {
			return {
				guests : mergeKnownRelationships($scope.allGuestsGroup.guests, $scope.guestGroups),
				tables : $scope.tables
			}
		};

		var mergeKnownRelationships = function(guests, groups) {
			var mergedGuests = cloneGuestsData(guests);
			for (var gr = 0; gr < groups.length; gr++) {
				var group = groups[gr];
				for (var gu = 0; gu < group.guests.length; gu++) {
					var groupGuest = findGuest(mergedGuests, group.guests[gu].name);
					for (var gg2 = 0; gg2 < group.guests.length; gg2++) {
						var otherGroupGuest = findGuest(mergedGuests, group.guests[gg2].name);
						if (groupGuest.name != otherGroupGuest.name) {
							groupGuest.knows.push(otherGroupGuest);
						}
					}
				}
			}
			return mergedGuests;
		};

	};
	HomeCtrl.$inject = [ "$scope", "$rootScope", "$location", "plannerService" ];

	return {
		HomeCtrl : HomeCtrl
	};

});
