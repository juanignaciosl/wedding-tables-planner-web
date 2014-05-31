{"optimize": "uglify2", "generateSourceMaps": true, "appDir": "/Users/juanignaciosl/Development/workspaceKepler/wedding-tables-planner-site/target/web/rjs/appdir", "onBuildWrite": /*
 * This is a build writing function for RequireJS configuration files. The purpose of it is to substitute any string literals that
 * have a value starting with libPath. The libPath is used to determine the name of a module that can be found in paths.
 * For example if libPath is "lib/" and paths is {"underscorejs/underscore":"http://somecdn/underscorejs"} then any string literals
 * containing "lib/underscorejs/underscore" will be substituted with "http://somecdn/underscorejs/underscore".
 *
 * The function is intended to perform well given the initial scanning phase. Once the substitution array is collected
 * then it is looped over and string concatenations are performed. The common scenario of a file not having anything
 * to substitute results in only one concatenation. There are only (n * 2) + 1 concatenations to perform where n
 * is the number of substitutions.
 */
(function (mainConfigFile, paths) {
    "use strict";

    function advance(contents, s, i) {
        i = contents.indexOf(s, i);
        if (i === -1) {
            i = contents.length;
        } else {
            i += s.length - 1;
        }
        return i;
    }

    function endsWith(s, suffix) {
        return s.indexOf(suffix, s.length - suffix.length) !== -1;
    }

    return function () {
        var path = arguments[1];
        var contents = arguments[2];

        if (!endsWith(path, mainConfigFile)) {
            return contents;
        }

        var substitutions = [];

        var prevC = "";
        for (var i = 0; i < contents.length; ++i) {
            var j, k, modulePath, pathChange;

            var c = contents[i];
            if (c === "*" && prevC === "/") {
                i = advance(contents, "*/", i);
                prevC = "";
            } else if (c === "/" && prevC === "/") {
                i = advance(contents, "\n", i);
                prevC = "";
            } else if (c === '"' || c === "'") {
                j = advance(contents, c, i + 1);
                k = advance(contents, "/", i + 1) + 1;
                if (k > j) k = i;
                modulePath = contents.substring(k, j);
                {
                    pathChange = paths[modulePath];
                    if (pathChange !== undefined) {
                        substitutions.push({
                            start: i,
                            end: j,
                            change: pathChange
                        });
                    }
                }
                prevC = "";
                i = j;
            } else {
                prevC = c;
            }
        }

        var newContents = "";
        var prevEnd = 0;
        substitutions.forEach(function (substitution) {
            newContents += contents.substring(prevEnd, substitution.start + 1);
            newContents += substitution.change;
            prevEnd = substitution.end;
        });
        newContents += contents.substring(prevEnd);

        return newContents;
    };

})(
          "javascripts/main.js",
          {}
          ), "preserveLicenseComments": false, "paths": {}, "dir": "/Users/juanignaciosl/Development/workspaceKepler/wedding-tables-planner-site/target/web/rjs/build", "modules": [{"name": "main"}], "mainConfigFile": "/Users/juanignaciosl/Development/workspaceKepler/wedding-tables-planner-site/target/web/rjs/appdir/javascripts/main.js", "baseUrl": "javascripts"}