# Wedding Tables Planner web

You can try [Wedding Tables Planner online at OpenShift](http://www.juanignaciosl.com/ingenieria-del-software/wedding-tables-planner).

This is a small web application which you can use to arrange your guests. 
You can set "known", "loved" and "hated" relationships, the number and size of the tables, and the planner will arrange
loving guests together, hated at different tables, and will try to keep known people as together as possible, minimizing the
number of tables.

You can get [the core](https://github.com/juanignaciosl/wedding-tables-planner) if you're interested in *OptaPlanner* and want to get rid of the web layer.

The site is based on [Play+AngularJS+RequireJS Scala Activator template](http://typesafe.com/activator/template/play-with-angular-requirejs), so you might find some boilerplate example code.

## Trying It Out yourself

* Run via `activator run`
* Go to [localhost:9000](http://localhost:9000)


## OpenShift deployment

This is a Play app, ready to run in a DIY OpenShift Cartridge. It will install JDK 8 at first start.

Create a DIY app:

``rhc app-create weddingtableplanner2 diy-0.1 --from-code git://github.com/juanignaciosl/wedding-tables-planner-web.gitrhc app-create weddingtablesplanner diy-0.1 --from-code git://github.com/juanignaciosl/wedding-tables-planner-web.git``
