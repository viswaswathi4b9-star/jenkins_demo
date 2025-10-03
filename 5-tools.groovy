pipeline {
    agent {
        label 'java-slave'
    }

    tools {
        maven 'Maven1' // Make sure this matches the name configured in Global Tool Configuration
    }

    stages {
        stage('maven') {
            steps {
                echo "hello"
                sh 'mvn --version'
            }
        }
        stage('new maven'){
            //this jdk will take precedence
            tools{
                jdk 'JDK-17'
            }
            steps{
                echo "hello"
                sh 'mvn --version'
            }
        }
    }
}
