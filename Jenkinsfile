pipeline {
    agent any 
    stages{
        stage('Maven Build'){
            steps {
            sh "git clone https://github.com/Sadashiv/maven"
            sh "cd maven && mvn clean install"
            }
        }
        stage('Deploy product'){
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


}
