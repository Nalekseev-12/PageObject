pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
          stages {
      stage('Build') {
         steps {
            echo "It's Build"
            git credentialsId: '95152a3d-6859-4459-9451-a8ded21f3260', url: 'https://github.com/Nalekseev-12/PageObject.git'
            echo "Stop build"

         }
      }
      stage('Clean') {
          steps {
             echo "tests execute"
             bat 'mvn clean'

          }
      }
      stage('Test') {
          steps {
             echo "tests execute"
             bat 'mvn test'

          }
      }

    }
}