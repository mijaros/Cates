application {
    title = 'cates'
    startupGroups = ['cates']
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "cates"
    'cates' {
        model      = 'org.cates.CatesModel'
        view       = 'org.cates.CatesView'
        controller = 'org.cates.CatesController'
    }
}