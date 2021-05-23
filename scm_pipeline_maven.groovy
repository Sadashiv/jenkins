def owner = 'sadashiv_pipeline_scm'
def project = 'maven'
def jobName = "${owner}-${project}".replaceAll('/','-')

pipelineJob(jobName) {
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
            scriptPath("Jenkinsfile.status")
        }
    }
}
