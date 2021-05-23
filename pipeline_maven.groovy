def owner = 'sadashiv_pipeline'
def project = 'maven'
def jobName = "${owner}-${project}".replaceAll('/','-')

pipelineJob(jobName) {
    definition {
        cps {
            script(readFileFromWorkspace('Jenkinsfile'))
            sandbox()
//        }
/*        cps {
        script('''
        pipeline {
    agent any 
    stages{
        stage('CleanWorkspace') {
            steps {
                cleanWs()
            }
        }
        stage('Maven Build'){
            steps {
            sh "git clone https://github.com/Sadashiv/maven"
            sh "cd maven && mvn clean install"
            }
        }
        stage('Deploy product'){
            agent { label 'deploy_server' }
            steps {
            echo "Deploy product to desired server"
            }
        }
        stage('Selenium Test'){
            steps {
            echo "Run Selenium test case"
            }
        }
        stage('Create docker image '){
            steps {
            echo "Docker image creation in progress"
            }
        }
    }


}''')*/
    }
  }
}
