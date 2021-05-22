def owner = 'sadashiv'
def project = 'maven'
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
      shell('mvn clean install')
  }
}
