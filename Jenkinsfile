pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build apigateway') {
          steps {
            dir(path: 'apigateway') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }

        stage('Build configservice') {
          steps {
            dir(path: 'configservice') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
        
        stage('Build productservice') {
          steps {
            dir(path: 'productservice') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
        
        stage('Build registry') {
          steps {
            dir(path: 'registry') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
          }
        }
        
        stage('Build reviewservice') {
          steps {
            dir(path: 'reviewservice') {
              sh 'chmod +x ./gradlew'
              sh './gradlew build'
            }
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
