// MyProject-Build.groovy

def gitUrl = "https://github.com/jleetutorial/maven-project"

job("MyProject-Build") {
    description "Builds MyProject from master branch."
    parameters {
        stringParam('COMMIT', 'HEAD', 'Commit to build')
    }
    scm {
        git {
            remote {
                url gitUrl.
                branch "master"
            }
            extensions {
                wipeOutWorkspace()
                localBranch master
            }
        }
    }
    steps {
        shell "Look: I'm building master!"
    }
}
