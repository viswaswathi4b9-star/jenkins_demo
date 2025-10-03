//script block will be available under steps block
//script block is used to write custom code in groovy
//script block will be very helpful when creation complex env 
pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo "hello world"
                sh "hostname -i"
            }
        }
        stage('groovystage') {
            steps {
                script {
                    def course = "k8s"
                    if (course == "k8s") {
                        println("thanks for enrolling to ${course}")
                    } else {
                        println("do learn k8s")
                    }
                    sleep 10
                    echo "script block has been executed"
                }
            }
        }
    }
}
