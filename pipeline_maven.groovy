def owner = 'sadashiv_pipeline'
def project = 'maven'
def jobName = "${owner}-${project}".replaceAll('/','-')

pipelineJob(jobName) {
    definition {
        cps {
            script(readFileFromWorkspace('Jenkinsfile'))
            sandbox()
        }
        }
//  steps {
//      shell('mvn clean install')
//      maven('-e clean install')
//  }
}
