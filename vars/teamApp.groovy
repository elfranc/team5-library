def call(string repoUrl)
pipeline {
       agent any
       tools {
           maven 'maven'
       }
       stages {
           stage("Tools initialization") {
               steps {
                   sh 'mvn --version'
                   sh 'java -version'
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'main',
                          url: "${repoUrl}"
               }
           }
           stage('team5-test-shared'){
            steps{
                echo "lets test this"
            }
           }
           stage("to-test-maven") {
               steps {
                   sh 'mvn -v'
               }
           }
       }
}