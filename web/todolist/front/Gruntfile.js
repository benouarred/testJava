module.exports = function (grunt) {
	'use strict';

	require('load-grunt-tasks')(grunt);

	grunt.initConfig({

		connect : {
			dev : {
				options : {
					hostname : 'localhost',
					base: 'app',
					port : 8888,
					open : true,
					keepalive: true,
					middleware : function (connect, options) {
						var proxy = require('grunt-connect-proxy/lib/utils').proxyRequest;
						return [
							proxy,
							connect.static(options.base),
							connect.directory(options.base)
						];
					}
				},
				proxies : [
					{
						context : '/api',
						host : 'localhost',
						port : 3000
					}
				]
			}
		}
	});

	grunt.registerTask('default', ['configureProxies:dev', 'connect:dev']);

};