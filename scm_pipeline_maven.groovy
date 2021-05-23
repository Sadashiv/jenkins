def owner = 'sadashiv_pipeline_scm'
def project = 'maven'
def jobName = "${owner}-${project}".replaceAll('/','-')

pipelineJob(jobName) {
    definition {
        cpsScm {
            scm {
                git('https://github.com/Sadashiv/maven')
            }
        }
        }
}
