/**
 * A common directive. It would also be ok to put all directives into one file,
 * or to define one RequireJS module that references them all.
 */
define([ "angular" ], function(angular) {
	"use strict";

	var mod = angular.module("common.directives.example", []);
	mod.directive("guestGroup", [ function() {
		return {
			restrict : "E",
			scope : {
				group : '=',
				selected : '=',
				selectable : '='
			},
			templateUrl : "/assets/templates/home/guestGroup.html",
			controller: function($scope) {
				return $scope;
			},
			link : function($scope, $element, attrs) {
				$scope.isSelected = !!$scope.selected;
				if (!!$scope.selectable) {
					$scope.selectGroup = function() {
						$scope.isSelected = !$scope.isSelected;
						$scope.$emit($scope.isSelected ? 'selectGroup' : 'deselectGroup', $scope.group);
					};
				}
				$scope.onDrop = function($event, $data, guest) {
					console.log($event, $data, guest);
					$scope.$emit('addGuestToGroup', $data, $scope.group);
				}
			}
		}
	} ]);
	mod.directive("guest", [ function() {
		return {
			require: '^guestGroup',
			restrict : 'E',
			scope : {
				guest : '=guest'
			},
			templateUrl : '/assets/templates/home/guest.html',
			link : function($scope, $element, attrs, guestGroupController) {
				var guest = $scope.guest;
				
				$scope.removeGuest = function() {
					if(!guestGroupController.group.readOnly || confirm('¿Are you sure you want to remove "'+guest.name+'" from the guest list?')) {
						$scope.$emit('removeGuest', guest, guestGroupController.group);
					}
				};
				$scope.dropSuccessHandler = function(event, index, guest) {
				};
				$scope.onDrop = function($event, $data) {
					if($data === guest.name) {
						return false;
					}					
					$scope.$emit('guestsRelationship', $data, guest);
				};
			}
		}
	} ]);
	return mod;
});
