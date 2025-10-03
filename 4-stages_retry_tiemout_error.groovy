//retry,timeout,error 

pipeline{
    agent any
    stages{
        stage('build'){
            steps{
                retry(3){
                    echo "welcome"  
                    error "tes this retry block"
                }
            echo "after 3 retrys"   
            }
        }
    }
}

//timeout'

pipeline{
    agent any
    stages{
        stage('build'){
            steps{
                timeout (time: 5, unit: 'SECONDS') //values : NANOSECONDS, MICROSECONDS, MILLISECONDS
                {
                echo "sleeping for 60 seconds"
                sleep 60 
                }
            }
        }
    }
}