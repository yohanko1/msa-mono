pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Building..'
        dir("apigateway") {
          sh './gradlew build'
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
  triggers {
    githubPush()
  }
}
