(function () {
    'use strict';
    angular.module("news-fe", ['ngResource', 'ng']);

    function NewsService($resource) {
        return $resource('../webservices/news/:id');
    }

    angular.module('news-fe').factory('NewsService', ['$resource', NewsService]);

    function NewsController(newsService) {
        var self = this;

        self.news = [];

        self.init = function (newsService) {
            newsService.get().$promise.then(function (response) {
                console.log('response: ' + JSON.stringify(response));
                self.news = response.list;
            });
        }

        self.init(newsService);
    }

    angular.module("news-fe").controller('NewsController', ['NewsService', NewsController]);

}());