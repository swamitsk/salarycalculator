var app = angular.module('clientsApp', []);

app
    .controller('ClientsCtrl', function ($scope, $http) {

        var currentDate = new Date();
        var locale = "en-us";
        var month = currentDate.toLocaleString(locale, {month: "long"});


        $scope.newemployee = {
            payDate: currentDate.getDate()+" "+month+"  "+currentDate.getFullYear(),
            payFrequency: 'Monthly',
            incomeTax: 0
        };

        $scope.calculateSalary = function () {

            if($scope.newemployee.firstName === "" || $scope.newemployee.lastName === "" || $scope.newemployee.salaryPaid === 0 ||
            $scope.newemployee.superPercent === 0) {
                $scope.invalidData = true;
                return;
            }

            function getIncomeTax(salary) {
                if (salary <= 18200) {
                    return 0;
                } else if (18200 < salary && salary < 37000) {
                    return ((salary - 18200) * .19) / 12;
                } else if (37000 < salary && salary < 80000) {
                    return (3572 + ( salary - 37000) * .325) / 12;
                } else if (80000 < salary && salary < 180000) {
                    return (17547 + ( salary - 80000) * .37) / 12;
                } else {
                    return (54547 + (salary - 180000) * .45) / 12;
                }
            }

            $scope.newemployee.grossIncome = Math.round($scope.newemployee.salaryPaid / 12);
            $scope.newemployee.incomeTax = Math.round(getIncomeTax($scope.newemployee.salaryPaid));

            $scope.newemployee.netIncome = $scope.newemployee.grossIncome - $scope.newemployee.incomeTax;
            $scope.newemployee.super = Math.round($scope.newemployee.grossIncome * $scope.newemployee.superPercent / 100);
            $scope.newemployee.finalPay = Math.round($scope.newemployee.netIncome - $scope.newemployee.super);
        };

        $scope.paySalary = function () {
            $http.post('/salary/employee', $scope.newemployee).then(function (response) {
                if (!response.data) {
                    alert("salary already paid");
                } else {
                    alert("salary paid");
                }
            });
        }
    });