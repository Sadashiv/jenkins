def owner = 'sadashiv'
def project = 'maven_pipeline'
def jobName = "${owner}-${project}".replaceAll('/','-')

pipelineJob('jobName') {
    definition {
        cpsScm {
            scm {
                git('https://github.com/${owner}/${project}.git')
            }
        }
    }
//  steps {
//      shell('mvn clean install')
//      maven('-e clean install')
//  }
}
