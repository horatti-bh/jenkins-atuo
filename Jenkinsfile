pipeline {
agent any
environment {
    URL1 = "google.com"
}
    stages{
        stage ('TEST_FROM_STAGE_ONE'){
            steps{
                print "Hello stage one"
                print URL1
                }
}
        stage('TEST_FROM_STAGE_TWO') {
        environment {
            URL1 = "google1.com"
        }
            steps{
                print "Hello stage two"
                print URL1
            }
        }
    }
}