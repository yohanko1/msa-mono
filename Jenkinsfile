pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Building..'
            dir(path: 'apigateway') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }

          }
        }

        stage('') {
          steps {
            echo 'Building...'
          }
        }

      }
    }

    stage('Test') {
      steps {
        echo 'Testing..'
      }
    }

    stage('Deploy') {
      steps {
        echo 'Deploying....'
      }
    }

  }
}