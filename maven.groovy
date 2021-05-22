def owner = 'mesosphere'
def project = 'jenkins-mesos'
def jobName = "${owner}-${project}".replaceAll('/','-')
job(jobName) {
  scm {
      git {
          remote {
            github("${owner}/${project}")
          }
//          createTag(false)
      }
  }
  triggers {
      scm('*/15 * * * *')
  }
  steps {
      shell('ls -l')
  }
}
