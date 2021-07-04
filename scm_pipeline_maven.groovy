def foldername = "maven"
def owner = 'sadashiv_pipeline_scm'
def project = 'maven'
def jobName = "${owner}-${project}".replaceAll('/','-')

folder("maven") {
    displayName("maven")
    description("Folder containing maven project")
}

pipelineJob("maven"/jobName) {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Sadashiv/jenkins')
                    }
                    branch("jenkins")
                }
            }
            scriptPath("Jenkinsfile")
        }
    }
}
