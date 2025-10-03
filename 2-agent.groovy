//any - execute the pipeline in any available agent
//label -- this is a string which inform jenkins to run the pipeline or stage on a particular agent
//agent can be written under pipeline and stage as well
pipeline{
    agent{
        label 'java-slave' //this should be configured in slave section
    }
    stages{
        stage('build'){
            steps{
                    echo "hello world"
            }
        }
        stage('docker'){
            agent 'docker-slave'
            steps{
                echo "running on docker slave"
                sh "docker build -t siva:v1 ."
            }
        }
    }
}

// node agent

pipeline{
    agent none
    stages{
        stage('build'){
            agent{
                node{
                    label 'jave-slave'
                    customWorkspace "/home/siva/customwork"
                }
            }
            steps{
                echo "helo world"
                sh 'cat siva.txt'
            }
        }
    }
}