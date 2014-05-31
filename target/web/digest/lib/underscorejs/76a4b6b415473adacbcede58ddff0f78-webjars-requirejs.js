requirejs.config({
    paths: { "underscorejs": webjars.path("underscorejs", "underscore") },
    shim: { "underscorejs": { "exports": "_" } }
});
