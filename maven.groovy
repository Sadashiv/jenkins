def owner = 'mesosphere'
def project = 'jenkins-mesos'
def branchApi = new URL("https://api.github.com/repos/${owner}/${project}/branches")
def branches = new groovy.json.JsonSlurper().parse(branchApi.newReader())
branches.each {
  def branchName = it.name
  def jobName = "${owner}-${project}-${branchName}".replaceAll('/','-')
  job(jobName) {
    scm {
        git {
            remote {
              github("${owner}/${project}")
            }
            branch("${branchName}")
            createTag(false)
        }
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        shell('ls -l')
    }
  }
}
